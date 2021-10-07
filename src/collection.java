import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public class collection {
    //Парковочное место занято - true, свободно - false
    private static final boolean[] PARKING_PLACES = new boolean[5];
    //Устанавливаем флаг "справедливый", в таком случае метод
    //aсquire() будет раздавать разрешения в порядке очереди
    private static final Semaphore SEMAPHORE = new Semaphore(3, true);

    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        int key, value;
        System.out.print("key:");
        key = input.nextInt();
        //System.out.print("value:");
        value = 0;
        tree<Integer> col = new tree<>(key, value);
        for (int i = 0; i < 3; i++) {
            System.out.print("key:");
            key = input.nextInt();
            //System.out.print("value:");
            value = 0;
            col.add(key, value);
        }
        col.println();
        System.out.println(col.get(13));

        long st1;
        AtomicLong en1 = new AtomicLong();
       Vector<Integer> vec = new Vector<>();

        ArrayList<Integer> arr = new ArrayList();   //88  1615
        LinkedList<Integer> link = new LinkedList();//384 2661
        for (int i = 0; i < 1000000; i++) {

        }
        st1 = System.currentTimeMillis();
        for (int i = 0; i < 20000000; i++) {
            vec.add(1);
        }
        en1.set(System.currentTimeMillis());
        System.out.println(en1.get() - st1);

        st1 = System.currentTimeMillis();
        for (int i = 0; i < 20000000; i++) {
            arr.add(1);
        }
        en1.set(System.currentTimeMillis());
        System.out.println(en1.get() - st1);

        st1 = System.currentTimeMillis();
        for (int i = 0; i < 20000000; i++) {
            link.add(1);
        }
        en1.set(System.currentTimeMillis());
        System.out.println(en1.get() - st1);

        st1 = System.nanoTime();
        vec.get(19999999);
        en1.set(System.nanoTime());
        System.out.println(en1.get() - st1);

        st1 = System.nanoTime();
        arr.get(19999999);
        en1.set(System.nanoTime());
        System.out.println(en1.get() - st1);

        st1 = System.nanoTime();
        link.get(19999999);
        en1.set(System.nanoTime());
        System.out.println(en1.get() - st1);

        st1 = System.nanoTime();
        vec.remove(19999999);
        en1.set(System.nanoTime());
        System.out.println(en1.get() - st1);

        st1 = System.nanoTime();
        arr.remove(19999999);
        en1.set(System.nanoTime());
        System.out.println(en1.get() - st1);

        st1 = System.nanoTime();
        link.remove(19999999);
        en1.set(System.nanoTime());
        System.out.println(en1.get() - st1);

        //--------------------------------
        System.out.println("Set");
        HashSet<Integer> hset= new HashSet<>();
        st1 = System.currentTimeMillis();
        for (int i = 0; i < 20000000; i++) {
            hset.add(1);
        }
        en1.set(System.currentTimeMillis());
        System.out.println(en1.get() - st1);

        TreeSet<Integer> tset= new TreeSet<>();
        st1 = System.currentTimeMillis();
        for (int i = 0; i < 20000000; i++) {
            tset.add(1);
        }
        en1.set(System.currentTimeMillis());
        System.out.println(en1.get() - st1);

        SortedSet<Integer> sset= Collections.synchronizedSortedSet(new TreeSet());
        st1 = System.currentTimeMillis();
        for (int i = 0; i < 20000000; i++) {
            sset.add(1);
        }
        en1.set(System.currentTimeMillis());
        System.out.println(en1.get() - st1);

        st1 = System.nanoTime();
        hset.iterator().next();

        en1.set(System.nanoTime());
        System.out.println(en1.get() - st1);

        System.out.println("Map");

        LinkedHashMap<String, Integer> lhmap = new LinkedHashMap<>();
        st1 = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            lhmap.put("!" + i, 12);
        }
        en1.set(System.currentTimeMillis());
        System.out.println(en1.get() - st1);//71218

        st1 = System.nanoTime();
        lhmap.get("!");
        en1.set(System.nanoTime());
        System.out.println(en1.get() - st1);//12348200

        st1 = System.nanoTime();
        lhmap.remove("!");
        en1.set(System.nanoTime());
        System.out.println(en1.get() - st1);//113600

        TreeMap<Integer, Integer> treelink = new TreeMap();
        long start;
        long finish;
        start = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            treelink.put(i, 1);
        }
        finish = System.currentTimeMillis();
        System.out.println("TreeMap : time for adding: " + (finish - start));

        start = System.nanoTime();
        link.get(44444);
        finish = System.nanoTime();
        System.out.println("TreeMap : time for searching: " + (finish - start));

        start = System.nanoTime();
        link.remove(44444);
        finish = System.nanoTime();
        System.out.println("TreeMap : time for removing: " + (finish - start));


        Hashtable<Integer, Integer> ht = new Hashtable();
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            treelink.put(i, 1);
        }
        finish = System.currentTimeMillis();
        System.out.println("HASHTABLE : time for adding: " + (finish - start));

        start = System.nanoTime();
        link.get(44444444);
        finish = System.nanoTime();
        System.out.println("HASHTABLE : time for searching: " + (finish - start));

        start = System.nanoTime();
        link.remove(44444444);
        finish = System.nanoTime();
        System.out.println("HASHTABLE : time for removing: " + (finish - start));

        class A implements Runnable{
            void sl()  {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public void run(){
                try{
                    Thread.sleep(500);
                }
                catch(InterruptedException e){
                    System.out.println("Thread has been interrupted");
                }
                for(int i = 0;i<100;i++){
                    if(i==50){
                            //sl();
                        }
                    }
                }
            }


        Thread thread = new Thread(new A(), "thread");
        Thread thread1= new Thread(new A(), "thread1");
        Object object = new Object();
        thread.start();
        thread1.start();
        st1 = System.currentTimeMillis();
        synchronized(object) {
            System.out.println("Hello World");
            for(int i=0;i<10000000;i++){

            }
        }
        en1.set(System.currentTimeMillis());
        System.out.println(en1.get() - st1);
        class Car implements Runnable {
            private int carNumber;

            public Car(int carNumber) {
                this.carNumber = carNumber;
            }

            @Override
            public void run() {
                System.out.printf("Автомобиль №%d подъехал к парковке.\n", this.carNumber);
                try {
                    //acquire() запрашивает доступ к следующему за вызовом этого метода блоку кода,
                    //если доступ не разрешен, поток вызвавший этот метод блокируется до тех пор,
                    //пока семафор не разрешит доступ
                    SEMAPHORE.acquire();

                    int parkingNumber = -1;

                    //Ищем свободное место и паркуемся
                    synchronized (PARKING_PLACES) {
                        for (int i = 0; i < 5; i++)
                            if (!PARKING_PLACES[i]) {      //Если место свободно
                                PARKING_PLACES[i] = true;  //занимаем его
                                parkingNumber = i;         //Наличие свободного места, гарантирует семафор
                                System.out.printf("Автомобиль №%d припарковался на месте %d.\n", carNumber, i);
                                break;
                            }
                    }

                    Thread.sleep(5000);       //Уходим за покупками, к примеру

                    synchronized (PARKING_PLACES) {
                        PARKING_PLACES[parkingNumber] = false;//Освобождаем место
                    }

                    //release(), напротив, освобождает ресурс
                    SEMAPHORE.release();
                    System.out.printf("Автомобиль №%d покинул парковку.\n", carNumber);
                } catch (InterruptedException e) {
                }
            }
        }
        for(int i = 1;i<=7;i++)
            {
                new Thread(new Car(i)).start();
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }





