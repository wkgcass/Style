package net.cassite.style;

/**
 * test 'implicit' type conversion
 */
public class User implements IUser {
        public static User from(String str) {
                String[] strs = str.split(",");
                return new User(strs[0], Integer.parseInt(strs[1]));
        }

        private String name;
        private int age;

        public User(String name, int age) {
                this.name = name;
                this.age = age;
        }

        public User() {
        }

        public String getName() {
                return name;
        }

        public int getAge() {
                return age;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setAge(int age) {
                this.age = age;
        }

        @Override
        public String toString() {
                return name + "," + age;
        }
}
