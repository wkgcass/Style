package net.cassite.style.util;

/**
 * file operation failed
 */
public class FileOperationFailedException extends Exception {
        public FileOperationFailedException() {
        }

        public FileOperationFailedException(String message) {
                super(message);
        }

        public FileOperationFailedException(String message, Throwable cause) {
                super(message, cause);
        }

        public FileOperationFailedException(Throwable cause) {
                super(cause);
        }
}
