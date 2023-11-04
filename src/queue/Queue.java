package queue;

import java.util.LinkedList;

public class Queue<T> {
    LinkedList<T> list = new LinkedList<>();

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void add(T value) {
        this.list.addLast(value);
    }

    public T peek() {
        if(this.list.isEmpty()) return null;
        return this.list.getFirst();
    }
    public T remove(){
        return this.list.remove();
    }


}
