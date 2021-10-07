
public class tree<T> {
    private node parent;

    private class node {
        int key;
        T data;
        node rigth;
        node left;
    }

    tree(int key, T data) {//создание вершины
        node zero = new node();
        this.parent = zero;
        this.parent.data = data;
        this.parent.key = key;
    }

    private void create(node head, int key, T data) {
        node cur = head;
        System.out.println(cur.key + " " + key);
        if (cur.key > key) {
            System.out.println("меньше");
            if (cur.left == null) {     //если нет детей,
                node left = new node(); //создаёт нового
                cur.left = left;
                left.key = key;
                left.data = data;
            } else {
                create(cur.left, key, data);//если есть, то переключается на него и проверяе
            }
        } else if (cur.key < key) {
            System.out.println("больше");
            if (cur.rigth == null) {
                node rigth = new node();
                cur.rigth = rigth;
                rigth.key = key;
                rigth.data = data;
            } else
                create(cur.rigth, key, data);
        } else if (cur.key == key) {
            System.out.println("равно");
        }
    }

    public void add(int key, T data) {
        create(this.parent, key, data);
    }

    public void println() {
        //System.out.println(this.parent.key+" ");
        print(this.parent);
    }

    private void print(node parent) {
        System.out.println(parent.key);
        if (parent.left != null) {
            print(parent.left);
        }
        if (parent.rigth != null) {
            print(parent.rigth);
        }
    }

    public T get(int key) {
        return get_prot(this.parent, key);
    }

    private T get_prot(node head, int key) {
        node cur = head;
        System.out.println(cur.key + " " + key);
        if (cur.key > key) {
            if (cur.left == null) {
                return cur.data;
            }
            get_prot(cur.left, key);
        } else if (cur.key < key) {
            if (cur.rigth == null) {
                return cur.data;
            }
            get_prot(cur.rigth, key);
        } else if (cur.key == key) {
            return cur.data;
        }
        return cur.data;
    }
}
