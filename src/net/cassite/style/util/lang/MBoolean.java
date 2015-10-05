package net.cassite.style.util.lang;

import java.io.Serializable;

public class MBoolean implements Serializable, Comparable<MBoolean> {
        /**
         * 
         */
        private static final long serialVersionUID = -7909424453284285590L;
        private Boolean b;

        public MBoolean(Boolean b) {
                this.b = b;
        }

        @Override
        public int compareTo(MBoolean o) {
                return b.compareTo(o.b);
        }

        public MBoolean inverse() {
                b = !b;
                return this;
        }

        public MBoolean assign(Boolean b) {
                this.b = b;
                return this;
        }

        public Boolean toBoolean() {
                return b;
        }

        @Override
        public String toString() {
                return b.toString();
        }

        @Override
        public boolean equals(Object o) {
                return b.equals(o);
        }

        @Override
        public int hashCode() {
                return b.hashCode();
        }
}
