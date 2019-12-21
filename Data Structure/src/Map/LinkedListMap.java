package Map;
import java.util.ArrayList;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key){
            this(key, null, null);
        }

        public Node(){
            this(null, null, null);
        }

        @Override
        public String toString(){
            return key.toString()+" : " + value.toString();
        }
    }

    private Node dummyhead;
    private int size;

    public LinkedListMap(){
        dummyhead = new Node();
        size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 辅助函数
    private Node getNode(K key){

        Node cur = dummyhead.next;
        while(cur != null){
            if(cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key){
        return getNode(key) != null;
    }

    @Override
    public V get(K key){
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void add(K key, V value){

        Node node = getNode(key);
        if(node == null){
            dummyhead.next = new Node(key, value, dummyhead.next);
            size++;
        }
        else node.value = value; // 也可以报错，是一个设计问题
    }

    @Override
    public void set(K key, V newValue){

        Node node = getNode(key);
        if(node == null){
            throw new IllegalArgumentException(key + "doesn't exist");
        }
        node.value = newValue;
    }

    @Override
    public V remove(K key){

        Node prev = dummyhead;
        while(prev.next != null){
            if(prev.next.key.equals(key)){
                break;
            } prev = prev.next;
        }
        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<String, Integer>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
