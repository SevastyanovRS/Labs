package algorithms;

public class DummySort {

    public static void main(String[] args) {

        int[] ints = new int[]{10,4,3,6,5,1,9,8,2,7};
        for (int i = 0; i < ints.length-1; i++) {
            int finalI = i;
            Runnable r = () -> {
                try {
                    Thread.sleep(ints[finalI] * ints.length);
                    System.out.println(ints[finalI]);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            Thread t = new Thread(r);
            t.start();
        }

    }
}