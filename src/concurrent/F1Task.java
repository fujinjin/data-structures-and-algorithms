package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class F1Task implements Callable<String> {
    private FutureTask<String> f1;

    public F1Task(FutureTask<String> f1) {
        this.f1 = f1;
    }

    @Override
    public String call() throws Exception {
        System.out.println("T1:洗水壶...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("T1:烧开水...");
        TimeUnit.SECONDS.sleep(15); // 获取T2线程的茶叶
        String tf = f1.get();
        System.out.println("T1:拿到茶叶:" + tf);
        System.out.println("T1:泡茶...");
        return "上茶:" + tf;
    }

    public static void main(String[] args) {
        F1Task.getResult();
    }
    public static void getResult() {
        String s = "abc";
        int[] array = new int[5];
        for (int i = 0;i< array.length;i++){
            array[i] = Math.toIntExact(Math.round(Math.random()*10));
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
