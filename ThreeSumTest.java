import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ThreeSumTest {

    @Test
    void threeSum() {
        int[] arrayTreeSum = {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();

//        List<List<Integer>> results = threeSum.threeSum(arrayTreeSum);
////        System.err.println(results.size());
//        printList(results);
        // Test edgeCase array is less than 3
//        int[] lessThanThree = {0,0};
//        List<List<Integer>> lessThan3 = threeSum.threeSum(lessThanThree);
//        printList(lessThan3);
//        int[] arrayTreeSum1 = {-1,0,1,2,-1,4};
//        List<List<Integer>> lessThan3 = threeSum.threeSum(arrayTreeSum1);
//        printList(lessThan3);
//
//        int[] arrayTreeSum2 = {-1,0,1,0};
//        List<List<Integer>> lessThan2 = threeSum.threeSum(arrayTreeSum2);
//        printList(lessThan2);

        int[] arrayTreeSum3 = {0,0,0};
        List<List<Integer>> threeZero = threeSum.threeSum(arrayTreeSum3);
        printList(threeZero);
    }

    private void printList(List<List<Integer>> results) {

        for (int i = 0; i < results.size(); i++) {
            ArrayList<Integer> theThreeSum = (ArrayList<Integer>) results.get(i);
            for (int j = 0; j < theThreeSum.size(); j++) {
                System.out.println(theThreeSum.get(j));
            }
        }
    }


}