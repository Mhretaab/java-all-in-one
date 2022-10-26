package generics;

public class Lesson1 {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>(2);
        System.out.println(integerBox.get());

        OrderedPair<String, Integer> stringInteger = new OrderedPair<>("age", 36);
        OrderedPair<String, Box<String>> stringBox = new OrderedPair<>("name", new Box<>("Berhe"));

        PrintService<Integer> printService = new IntPrintServiceImpl<>();
        printService.print(10);
    }

    public static class Box<T> {
        private T t;

        public Box(T t) {
            this.t = t;
        }

        public T get() {
            return this.t;
        }

        public void set(T t) {
            this.t = t;
        }
    }

    public static class OrderedPair<K, V> {
        private K k;
        private V v;

        public OrderedPair(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public K getKey(){
            return this.k;
        }

        public V getValue(){
            return this.v;
        }
    }

    public interface PrintService<T>{
        void print(T t);
    }

    public static class IntPrintServiceImpl<T> implements PrintService<T>{

        @Override
        public void print(T t) {
            System.out.println(t);
        }
    }
}
