package Stack;

public class Main {

    public static void main(String[] args) {

//        Array<Integer> arr = new Array<>();
//        for (int i=0; i<10; i++){
//            arr.addLast(i);
//        }
//        System.out.println(arr);
//
//        arr.add(1,100);
//        System.out.println(arr);
//
//        arr.addFirst(-1);
//        System.out.println(arr);
//
//        arr.remove(2);
//        System.out.println(arr);
//
//        arr.removeElement(4);
//        System.out.println(arr);
//
//        arr.removeFirst();
//        System.out.println(arr);

        ArrayStack<Integer> stack = new ArrayStack<Integer>();

        for (int i = 0; i<5; i++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
