public class pot extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            if (i % 10 == 0) {
                System.out.print(i);
            }
        }
    }
    Object obj=new Object();
    void pek()  {
        synchronized (obj) {
            for(int i=0;i<100000;i++){

            }
        }
    }
}
