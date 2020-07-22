package lambda;

public class ConcurrentGreeter extends Greeter{
    public void greet(){
        Thread thread = new Thread(super::greet);
        thread.start();
    }

    public static void main(String[] args) {
        ConcurrentGreeter concurrentGreeter = new ConcurrentGreeter();
        new Thread(concurrentGreeter::greet).start();
        System.out.println("!!!!!!!!!!!!!!!!");
        new Thread(ConcurrentGreeter::new).start();
    }
}
