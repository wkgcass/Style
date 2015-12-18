package net.cassite.style.util;

import net.cassite.style.Style;

import java.io.*;
import java.nio.file.NotDirectoryException;

/**
 * file which easily supports streams
 */
public class SFile implements AutoCloseable {
        private File file;
        private InputStream is;
        private OutputStream os;

        public SFile(File file) throws IOException, FileOperationFailedException {
                if (!file.exists() && !file.createNewFile()) throw new FileNotFoundException(file.toString());
                if (!file.isFile()) throw new FileOperationFailedException(file.toString() + " is not file");
                this.file = file;
        }

        public InputStream read() {
                if (is == null) {
                        try {
                                is = new FileInputStream(file);
                        } catch (FileNotFoundException e) {
                                throw Style.$(e);
                        }
                }
                return is;
        }

        public BufferedReader reader() {
                return new BufferedReader(new InputStreamReader(read()));
        }

        public OutputStream write() {
                if (os == null) {
                        try {
                                os = new FileOutputStream(file);
                        } catch (FileNotFoundException e) {
                                throw Style.$(e);
                        }
                }
                return os;
        }

        public Writer writer() {
                return new BufferedWriter(new OutputStreamWriter(write()));
        }

        public String fullPath() {
                return file.getAbsolutePath();
        }

        public String parentPath() {
                String path = file.getParent();
                if (!path.endsWith("/")) path += "/";
                return path;
        }

        public Directory parent() {
                try {
                        return new Directory(file.getParentFile());
                } catch (FileNotFoundException | NotDirectoryException e) {
                        throw Style.$(e);
                }
        }

        @Override
        public void close() throws Exception {
                if (is != null) is.close();
                if (os != null) os.close();
        }

        public File getFile() {
                return file;
        }
}
