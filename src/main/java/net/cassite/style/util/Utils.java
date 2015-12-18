package net.cassite.style.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NotDirectoryException;
import java.util.Date;

import net.cassite.style.Style;
import net.cassite.style.def;
import net.cassite.style.ptr;
import net.cassite.style.interfaces.VFunc0;
import net.cassite.style.util.lang.*;

import static net.cassite.style.Style.*;

public abstract class Utils {
        protected Utils() {

        }

        // date

        /**
         * Create a date supporter
         *
         * @param date the date to support
         * @return Date supporter
         * @see DateFuncSup
         */
        public static DateFuncSup $(Date date) {
                return new DateFuncSup(date);
        }

        // regex

        /**
         * Create a simplified regex tool from a string.
         *
         * @param regex a string assembled in the form of regex in JavaScript
         * @return new RegEx object helps you work with regex
         * @see RegEx
         */
        public static RegEx regex(String regex) {
                return new RegEx(regex);
        }

        // comparable

        /**
         * Enables you to compare two comparable objects with more readable
         * coding.<br>
         * e.g.
         * <p>
         * <pre>
         *  lt, gt, le, lte, ge, gte, eq, ne, neq
         * </pre>
         *
         * @param comparable the first comparable object to be compared
         * @return ComparableFuncSup
         * @see ComparableFuncSup
         */
        public static <T> ComparableFuncSup<T> $(Comparable<T> comparable) {
                return new ComparableFuncSup<>(comparable);
        }

        // rand

        /**
         * get an integer randomly from start (inclusive) to end (inclusive)
         *
         * @param start start inclusive
         * @param end   end inclusive
         * @return random integer
         */
        public static int rand(int start, int end) {
                return (int) (Math.random() * (end - start + 1)) + start;
        }

        /**
         * get a double randomly from start (inclusive) to end (exclusive)
         *
         * @param start start inclusive
         * @param end   end exclusive
         * @return random double
         */
        public static double rand(double start, double end) {
                return Math.random() * (end - start) + start;
        }

        /**
         * get an integer littler than max (inclusive)
         *
         * @param max 0 - maximum inclusive
         * @return random integer
         */
        public static int rand(int max) {
                return (int) (Math.random() * (max + 1));
        }

        /**
         * get a double littler than max
         *
         * @param max 0 - maximum exclusive
         * @return random double
         */
        public static double rand(double max) {
                return Math.random() * max;
        }

        /**
         * generate a random string serial with characters from $chooseFrom and
         * given length.
         *
         * @param chooseFrom   characters to choose from
         * @param length       generated serial length
         * @param unrepeatable true if the serial doesn't contain repeating
         *                     characters. false otherwise.
         * @param ignoreCase   true if the serial doesn't contain repeating
         *                     case-ignored characters. false otherwise.<br>
         *                     Only consider this argument when $unrepeatable is true
         * @return random string serial
         */
        public static String rand(String chooseFrom, int length, boolean unrepeatable, boolean ignoreCase) {
                if (length > chooseFrom.length() && unrepeatable) {
                        throw new RuntimeException("unrepeatable but length > chooseFrom.length");
                }
                StringBuilder sb = new StringBuilder();
                ptr<String> $chooseFrom = ptr(chooseFrom);
                For(1).to(length).loop(i -> {
                        char c = $chooseFrom.item.charAt(rand($chooseFrom.item.length() - 1));
                        while (sb.indexOf("" + c) != -1 && unrepeatable) {
                                c = $chooseFrom.item.charAt(rand(chooseFrom.length() - 1));
                        }
                        sb.append(c);
                        if (unrepeatable) {
                                if (ignoreCase) {
                                        $chooseFrom.item = $chooseFrom.item.replace(("" + c).toLowerCase(), "");
                                        $chooseFrom.item = $chooseFrom.item.replace(("" + c).toUpperCase(), "");
                                } else {
                                        $chooseFrom.item = $chooseFrom.item.replace(("" + c), "");
                                }
                        }
                });
                return sb.toString();
        }

        /**
         * generate a random string serial with characters from $chooseFrom and
         * given length.
         *
         * @param chooseFrom   characters to choose from
         * @param length       generated serial length
         * @param unrepeatable true if the serial doesn't contain repeating
         *                     characters. false otherwise.
         * @return random string serial
         */
        public static String rand(String chooseFrom, int length, boolean unrepeatable) {
                return rand(chooseFrom, length, unrepeatable, false);
        }

        /**
         * generate a random string serial with characters from $chooseFrom and
         * given length.
         *
         * @param chooseFrom characters to choose from
         * @param length     generated serial length
         * @return random string serial
         */
        public static String rand(String chooseFrom, int length) {
                return rand(chooseFrom, length, false, false);
        }

        /**
         * create a string supporter
         *
         * @param base the string to be supported
         * @return String supporter
         * @see string
         */
        public static string $(String base) {
                return string.get(base);
        }

        /**
         * Create a new thread and invoke start on it.
         *
         * @param runnable function run on the new thread
         * @return created thread
         * @see Utils#run(def)
         */
        public static Thread run(VFunc0 runnable) {
                return Utils.run(Style.$(runnable));
        }

        /**
         * Create a new thread and invoke start on it.
         *
         * @param toRun function run on the new thread
         * @return created thread
         */
        public static Thread run(def<Void> toRun) {
                Thread t = new Thread(toRun::apply);
                t.start();
                return t;
        }

        /**
         * mutable integer and enhanced operations<br>
         * which also supports <code>to</code> and <code>until</code> operations<br>
         * e.g. <code>$(0).until(9)</code> means list(0,1,2,3,4,5,6,7,8)<br>
         * and <code>$(0).to(9)</code> means list(0,1,2,3,4,5,6,7,8,9)
         *
         * @param n integer
         * @return mutable integer
         */
        public static MInteger $(Integer n) {
                return new MInteger(n);
        }

        /**
         * mutable double and enhanced operations
         *
         * @param n double
         * @return mutable double
         */
        public static MDouble $(Double n) {
                return new MDouble(n);
        }

        /**
         * mutable float and enhanced operations
         *
         * @param n float
         * @return mutable float
         */
        public static MFloat $(Float n) {
                return new MFloat(n);
        }

        /**
         * mutable long and enhanced operations
         *
         * @param n long
         * @return mutable long
         */
        public static MLong $(Long n) {
                return new MLong(n);
        }

        /**
         * mutable short and enhanced operations
         *
         * @param n short
         * @return mutable short
         */
        public static MShort $(Short n) {
                return new MShort(n);
        }

        /**
         * mutable byte and enhanced operations
         *
         * @param n byte
         * @return mutable byte
         */
        public static MByte $(Byte n) {
                return new MByte(n);
        }

        /**
         * mutable char and enhanced operations
         *
         * @param c char
         * @return mutable char
         */
        public static MCharacter $(Character c) {
                return new MCharacter(c);
        }

        /**
         * mutable bool and enhanced operations
         *
         * @param b bool
         * @return mutable bool
         */
        public static MBoolean $(Boolean b) {
                return new MBoolean(b);
        }

        /**
         * locate the directory
         *
         * @param dir path
         * @return directory object
         * @throws FileNotFoundException the given path is not found
         * @throws NotDirectoryException the given path is not a directory
         */
        public static Directory cd(String dir) throws FileNotFoundException, NotDirectoryException {
                return cd(new File(dir));
        }

        /**
         * locate the directory
         *
         * @param dir file representing the directory
         * @return directory object
         * @throws FileNotFoundException the given path is not found
         * @throws NotDirectoryException the given path is not a directory
         */
        public static Directory cd(File dir) throws FileNotFoundException, NotDirectoryException {
                return new Directory(dir);
        }

        /**
         * rename the dir to newDir
         *
         * @param dir    the directory to rename
         * @param newDir new name
         * @return new directory object
         * @throws FileOperationFailedException failed when moving
         */
        public static Directory mv(Directory dir, String newDir) throws FileOperationFailedException {
                if (!new File(dir.fullPath()).renameTo(new File(dir.parentPath() + newDir))) throw new FileOperationFailedException("mv " + dir + " " + newDir);
                try {
                        return cd(dir.parentPath() + newDir);
                } catch (FileNotFoundException | NotDirectoryException e) {
                        throw Style.$(e);
                }
        }

        /**
         * move the path to new path
         *
         * @param path    original path
         * @param newPath new path
         * @throws FileOperationFailedException failed when moving
         */
        public static void mv(String path, String newPath) throws FileOperationFailedException {
                if (!new File(path).renameTo(new File(newPath))) throw new FileOperationFailedException("mv " + path + " " + newPath);
        }

        /**
         * rename the file to new name
         *
         * @param file    original file
         * @param newFile new file name
         * @return new file object
         * @throws FileOperationFailedException failed when moving
         */
        public static SFile mv(SFile file, String newFile) throws FileOperationFailedException {
                if (!file.getFile().renameTo(new File(file.parentPath() + newFile))) throw new FileOperationFailedException("mv " + file + " " + newFile);
                try {
                        return new SFile(new File(file.parentPath() + newFile));
                } catch (IOException e) {
                        throw Style.$(e);
                }
        }

        /**
         * get the file
         *
         * @param file file
         * @return sfile
         * @throws IOException                  not found || creation failed
         * @throws FileOperationFailedException not file
         */
        public static SFile vim(File file) throws IOException, FileOperationFailedException {
                return new SFile(file);
        }

        /**
         * get file
         *
         * @param file file
         * @return sfile
         * @throws IOException                  not found || creation failed
         * @throws FileOperationFailedException not file
         */
        public static SFile vim(String file) throws IOException, FileOperationFailedException {
                return vim(new File(file));
        }

        /**
         * remove the path
         *
         * @param path path
         * @throws FileOperationFailedException failed when deleting the path
         */
        public static void rm(String path) throws FileOperationFailedException {
                if (!new File(path).delete()) throw new FileOperationFailedException(path + " not deleted");
        }

        private static void removeDir(File dir) throws FileOperationFailedException {
                File[] children = dir.listFiles();
                assert children != null;
                for (File f : children) {
                        if (f.isFile()) {
                                if (!f.delete()) throw new FileOperationFailedException(f + " not deleted");
                        } else if (f.isDirectory()) removeDir(f);
                }
                if (!dir.delete()) throw new FileOperationFailedException(dir + " not deleted");
        }

        /**
         * recursively remove the dir
         *
         * @param dir directory
         * @throws FileOperationFailedException failed removing the dir
         */
        public static void rm(Directory dir) throws FileOperationFailedException {
                removeDir(dir.getFile());
        }

        /**
         * remove the file
         *
         * @param file file
         * @throws FileOperationFailedException failed removing the file
         */
        public static void rm(SFile file) throws FileOperationFailedException {
                rm(file.fullPath());
        }
}
