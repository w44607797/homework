package demothread;

public class PutInt {
     public static void main(String[] args) {
        PutInt t3 = new PutInt();
            int[] arr1 = {1, 3, 5, 7, 9};
            int[] arr2 = {2, 4, 6, 8, 10};
            t3.startThread(arr1,arr2);
    }
    //创建线程执行线程
    public void startThread(int[] arr1,int[] arr2) {
        Thread thread1 = new Thread(new OutPutThread(arr1));
        Thread thread2 = new Thread(new OutPutThread(arr2));
        thread1.start();
        thread2.start();
    }
    //锁方法，输出数组内的数字
   synchronized public void outputInt(int[] arr,int temp) throws InterruptedException {
             System.out.print(arr[temp]);
             Thread.sleep(4);
    }
    //线程类
    class OutPutThread extends Thread{
         int[] arr;
         public OutPutThread(int[] arr){
             this.arr = arr;
         }
        @Override
        public void run() {
            int temp = 0;
            while (true){
                if(temp<arr.length){
                    try {
                        outputInt(arr,temp);
                        //让线程在锁里睡眠，形成两线程时间差进而交替输出
                        sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    temp++;
                }else{
                    break;
                }
            }

        }
    }
}

