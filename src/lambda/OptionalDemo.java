package lambda;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args){
        User user = new User();
        user = Optional.ofNullable(user).orElse(createUser());
        System.out.println(user.getName());
        user = Optional.ofNullable(user).orElseGet(()->createUser());
        System.out.println(user.getName());
        try {
            user = null;
            Optional.ofNullable(user).orElseThrow(()->new Exception("用户不存在"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static User createUser(){
        User user = new User();
        user.setName("hale");
        return user;
    }
}
