package Java_2_AdvancedLevel.lesson5;

import java.util.Arrays;

public class ArraysAndStreams {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        method1();
        System.out.println();
        method2();
    }


    private static void method1(){
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        a = System.currentTimeMillis() - a;
        System.out.println(" Время работы метода 1: " + a + " милисек.");
    }

    private static void method2(){
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        MyRunnableClass runnableClass1 = new MyRunnableClass(a1, 0);
        MyRunnableClass runnableClass2 = new MyRunnableClass(a2, h);
        Thread thread1 = new Thread(runnableClass1);
        Thread thread2 = new Thread(runnableClass2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(runnableClass1.arr, 0, arr, 0, h);
        System.arraycopy(runnableClass2.arr, 0, arr, h, h);
        a = System.currentTimeMillis() - a;
        System.out.println(" Время работы метода 2: " + a + " милисек.");
    }

    private static class MyRunnableClass implements Runnable {
        float[] arr;
        int h;
        public MyRunnableClass(float[] arr, int h) {
            this.arr = arr;
            this.h = h;
        }

        @Override
        public void run() {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
            }
        }
    }
}
