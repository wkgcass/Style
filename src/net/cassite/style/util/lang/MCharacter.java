package net.cassite.style.util.lang;

import java.io.Serializable;

public class MCharacter implements Serializable, Comparable<MCharacter> {

        /**
         * 
         */
        private static final long serialVersionUID = -6427752744287998392L;

        private Character c;

        public MCharacter(Character c) {
                this.c = c;
        }

        @Override
        public int compareTo(MCharacter o) {
                return c.compareTo(o.c);
        }

        public MCharacter assign(Character c) {
                this.c = c;
                return this;
        }

        public Character toCharacter() {
                return c;
        }

        @Override
        public String toString() {
                return c.toString();
        }

        @Override
        public boolean equals(Object o) {
                return c.equals(o);
        }

        @Override
        public int hashCode() {
                return c.hashCode();
        }

}
