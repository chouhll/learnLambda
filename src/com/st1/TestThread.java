package com.st1;

public class TestThread {
        private static class XRunnable implements Runnable{
            private int count;
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    getCount();
                }
            }
            private void getCount(){
                count++;
                //打印 计数值
                System.out.println(""+count);
            }
        }
        public static void main(String []arg){
            XRunnable runnable = new XRunnable();
            Thread a_thread = new Thread(runnable);
            Thread b_thread = new Thread(runnable);
            Thread c_thread = new Thread(runnable);
            a_thread.start();
            b_thread.start();
            c_thread.start();
        }
    }

