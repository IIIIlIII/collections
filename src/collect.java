public class collect<T> {
    class spis{
        int i=0;
        T info;
        spis next;
    }
    private spis sp2  = new spis();
    private spis sp1  = new spis();

    public void add(T info){
        sp1.info=info;
        sp2=sp1;
    for(int i =0;i<10;i++){
        sp2.next=new spis();
        sp2= sp2.next;
        sp2.info=info;
        sp2.i=i;
        sp2.next=null;
    }
    }
    public void print(){
        sp2=sp1.next;
        for(int i =0;i<10;i++){
            System.out.println(sp2.info);
            System.out.println(sp2.i);
            sp2=sp2.next;
        }
    }


}
