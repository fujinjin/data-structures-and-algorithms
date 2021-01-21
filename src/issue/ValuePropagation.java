package issue;

public class ValuePropagation {
    public static void main(String[] args) {
        String a = "a";
        passString(a);
        System.out.println(a);
        User user = new User();
        user.setName("xiao");
        user.setGender("man");
        passObject2(user);
        System.out.println(user);
        passObject(user);
        System.out.println(user);
    }

    private static void passObject(User user) {
        user.setName("guang");
        user.setGender("woman");
        System.out.println(user);
    }

    private static void passObject2(User user) {
        user = new User();
        user.setName("guang");
        user.setGender("woman");
        System.out.println(user);
    }

    private static void passString(String a) {
        a = "b";
        System.out.println(a);

    }

    static class User {
        private String name;
        private String gender;

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }
}
