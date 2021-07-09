package JavaBasicFourAssignment;

import java.util.ArrayList;

class Producer extends Thread{
    final ArrayList<Integer> buffer;
    Producer(){
        buffer = new ArrayList<>(10);
    }

    public void run(){
        synchronized (buffer){
            for (int i = 1;i<11;i++){
                try {
                    buffer.add(i);
                    System.out.println("Produced " + i);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("Buffer is FUll");
            buffer.notify();
        }
    }
}

class Consumer extends Thread{
    Producer p;

    Consumer(Producer temp){
        p = temp;
    }

    public void run(){
        synchronized (p.buffer){
            try{
                p.buffer.wait();
                System.out.println("First Thread await");
            }catch (Exception e)
            {e.printStackTrace();
            }
            for(Integer number: p.buffer){
                System.out.print(number+" ");

            }
            System.out.println("\nBuffer is Empty");
        }
    }

}



public class ProducerAndConsumer {
    public static void main(String [] args){
        Producer producer =new Producer();

        Consumer consumer = new Consumer(producer);
        Thread thread1 = new Thread(producer);
        Thread thread2= new Thread(consumer);
        thread2.start();
        thread1.start();
    }
}
