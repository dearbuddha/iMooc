package BST;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

//        BST<Integer> bst = new BST<Integer>();
//        int[] nums = {5,3,6,8,4,2};
//        for (int num:nums){
//            bst.add(num);
//        }
//        bst.preOrder();
//        System.out.println();
//
//        bst.preOrderNR();
//        System.out.println();

//        bst.inOrder();
//        System.out.println();
//
//        bst.postOrder();
//        System.out.println();
        //        System.out.println(bst);

//        bst.levelOrder();

        BST<Integer> bst = new BST<Integer>();
        Random random = new Random();

        int n = 1000;

        // test removeMin
        for (int i = 0; i<n;i ++){
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums= new ArrayList<>();
        while(!bst.isEmpty()){
            nums.add(bst.removeMin());
        }
        System.out.println(nums);

        for (int i = 1; i<nums.size();i++){
            if(nums.get(i-1)> nums.get(i)){
                throw new IllegalArgumentException("Error");
            }System.out.println("Test completed");
        }
    }
}
