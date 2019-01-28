package chapter3_1;

public class Novisibility {
    private static boolean ready;
    private static int number=0;

    private static class ReadThread extends Thread{
        public void run(){
            while (!ready)
                Thread.yield();

            System.out.printf("number="+number);

        }
    }

    public static void main(String[] args) {
        new ReadThread().start();
        number=42;
        ready=true;
    }
}