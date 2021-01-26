package Date;

public class MainRun {
    public static void main(String[] args){
     MyRun r = new MyRun();
     Thread t = new Thread(r);
     Thread t2 = new Thread(r);
     Thread t3 = new Thread(r);
     Thread t4 = new Thread(r);
     t.start();
     t2.start();
     //t3.start();
     //t4.start();
    }
}
class MyRun implements Runnable {
    private boolean x;
    public MyRun(){
        x = true;
    }
    public void run() {
        myTask();
    }
    public synchronized void myTask(){
        try {
            for (int i = 0; i < 6; i++) {
                if(i == 3 && x){
                    x = false;
                    wait();
                }
                else if(i == 3 && !x){
                   // x = true;
                    //notifyAll();
                }
                System.out.println("Thread " + Thread.currentThread());
                Thread.sleep(1);
            }
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        finally {
          notifyAll();
        }
    }
}