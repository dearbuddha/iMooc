package Stack;

import java.util.Random;

public class Main {

//    public static void main(String[] args) {
//
//        ArrayStack<Integer> stack = new ArrayStack<Integer>();
//
//        for (int i = 0; i<5; i++){
//            stack.push(i);
//            System.out.println(stack);
//        }
//
//        stack.pop();
//        System.out.println(stack);
//    }


        //测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
    public static double testStack(Stack<Integer> stack, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0; i<opCount;i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0; i<opCount;i++)
            stack.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 1000000;

        ArrayStack<Integer> arrayQueue = new ArrayStack<Integer>();
        double time1 = testStack(arrayQueue, opCount);
        System.out.println("ArrayStack.time: "+time1+" s");

        LinkedListStack<Integer> loopQueue = new LinkedListStack<Integer>();
        double time2 = testStack(loopQueue, opCount);
        System.out.println("LinkedListStack.time: "+time2+" s");
    }
}

