package com.example.study.vip.waitNotiy;

public class WaitNotify {

    class Persion{
        private String name;
        private String sex;
        private Boolean flag = false;
    }

    public static void main(String[] args) {
        new WaitNotify().print();
    }

    public void print(){
        Persion persion = new Persion();
        new InputThread(persion).start();
        new OutputThread(persion).start();
    }

    class InputThread extends Thread{
        private Persion persion;

        public InputThread(Persion persion){
            this.persion=persion;
        }

        @Override
        public void run(){
            int count =0;
            while(true){
                synchronized (persion){
                    if(persion.flag){
                        try {
                            persion.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(count==0){
                        persion.name="张三";
                        persion.sex="男";
                    }else{
                        persion.name="小薇";
                        persion.sex="女";
                    }
                    count=(count+1)%2;

                    persion.flag=true;
                    persion.notify();
                }
            }
        }
    }

    class OutputThread extends Thread{
        private Persion persion;

        public OutputThread(Persion persion){
            this.persion=persion;
        }

        @Override
        public void run(){
            while (true){
                synchronized (persion) {
                    if(!persion.flag){
                        try {
                            persion.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("姓名:" + persion.name + ",性别:" + persion.sex);
                    persion.flag=false;
                    persion.notify();
                }
            }
        }
    }
}
