import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ArrayProcessTest {
    @Test
    void singleNumber() {
        int[] findOne = {1,3,1,-1,3};
        ArrayProcess aPro = new ArrayProcess();
        aPro.singleNumber(findOne);
    }
    @Test
    void rotate(){
        ArrayProcess ap = new ArrayProcess();

        int[] arr = {1,2};
        int k = 3;
        ap.rotate(arr,k);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    void reverseArray() {
        ArrayProcess ap = new ArrayProcess();
        int[] arr = {1,2};
        int[] arrOdd = {1,2,3};
        int[] arrOdd2 = {1,2,3,4,5,6,7};

        ap.reverseArray(arr);
        System.out.println(Arrays.toString(arr));
        ap.reverseArray(arrOdd);
        System.out.println(Arrays.toString(arrOdd));
        int[] empty = {};
        ap.reverseArray(empty);
        ap.reverseArray(arrOdd2);
        System.out.println(Arrays.toString(arrOdd2));
    }

    @Test
    void rotateTwo() {
        ArrayProcess ap = new ArrayProcess();

        int[] arr = {1,2};
        int k = 0;
        ap.rotateUsingExtraArray(arr,k);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    void reversePartialArray() {
        ArrayProcess ap = new ArrayProcess();
        int[] arr = {1,2};
        int[] arrOdd = {1,2,3};
        ap.reversePartialArray(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
        ap.reversePartialArray(arrOdd,0,arrOdd.length);
        System.out.println(Arrays.toString(arrOdd));
        int[] empty = {};
        ap.reversePartialArray(empty,0,empty.length);
    }
}