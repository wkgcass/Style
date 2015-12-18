package net.cassite.style.util;

import net.cassite.style.Style;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.NotDirectoryException;

import static net.cassite.style.Style.*;
import static net.cassite.style.aggregation.Aggregation.*;

/**
 * file support
 */
public class Directory {
        private File file;

        Directory(File file) throws FileNotFoundException, NotDirectoryException {
                if (!file.exists()) throw new FileNotFoundException(file.getPath());
                if (!file.isDirectory()) throw new NotDirectoryException(file.getPath());
                this.file = file.getAbsoluteFile();
        }

        public String name() {
                return file.getName();
        }

        public String fullPath() {
                String path = file.getAbsolutePath();
                path = path.replace('\\', '/');
                if (!path.endsWith("/")) {
                        path += "/";
                }
                return path;
        }

        public Directory cd(String dir) throws FileNotFoundException, NotDirectoryException {
                dir = dir.trim();
                if (dir.endsWith("/")) dir = dir.substring(0, dir.length() - 1);
                if (dir.startsWith("/")) {
                        return Utils.cd(dir);
                } else if (dir.contains("/")) {
                        return new Directory(new File(fullPath() + (dir.substring(0, dir.indexOf('/'))))).cd(dir.substring(dir.indexOf('/') + 1));
                } else {
                        return new Directory(new File(fullPath() + dir));
                }
        }

        public Directory mkdir(String dir) throws FileAlreadyExistsException, FileOperationFailedException {
                dir = dir.trim();
                try {
                        cd(dir);
                } catch (FileNotFoundException e) {
                        File f;
                        if (dir.startsWith("/")) {
                                f = new File(dir);
                        } else {
                                f = new File(fullPath() + dir);
                        }
                        if (!f.mkdir()) throw new FileOperationFailedException("mkdir " + dir);
                        try {
                                return new Directory(f);
                        } catch (FileNotFoundException | NotDirectoryException e1) {
                                throw Style.$(e1);
                        }
                } catch (NotDirectoryException ignore) {
                }
                throw new FileAlreadyExistsException(fullPath() + " " + dir);
        }

        public String parentPath() {
                String path = file.getParent();
                return path == null ? "" : (path.endsWith("/") ? path : path + "/");
        }

        public Directory parent() throws FileNotFoundException, NotDirectoryException {
                String parentPath = parentPath();
                return parentPath == null ? null : new Directory(new File(parentPath));
        }

        public File[] ls() {
                return file.listFiles();
        }

        public Directory[] lsDirs() {
                File[] dirs = file.listFiles(File::isDirectory);
                Directory[] directories = new Directory[dirs.length];
                try {
                        for (int i = 0; i < dirs.length; ++i) {
                                directories[i] = new Directory(dirs[i]);
                        }
                } catch (Exception e) {
                        throw Style.$(e);
                }
                return directories;
        }

        public SFile[] lsFiles() {
                File[] files = file.listFiles(File::isFile);
                SFile[] retFiles = new SFile[files.length];
                $(files).forEach((f, i) -> {
                        retFiles[$(i)] = new SFile(f);
                });
                return retFiles;
        }

        public SFile file(String file) throws IOException, FileOperationFailedException {
                return Utils.vim(fullPath() + file);
        }

        public File getFile() {
                return file;
        }

        @Override
        public String toString() {
                return fullPath();
        }
}
