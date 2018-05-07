import java.util.Arrays;

public class ArrayProcess {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        boolean found = false;
        int size = nums.length;
        if (size < 2) return nums[0];
        for (int i = 1; i < size; i += 2) {
            index = i;
            if (nums[i] != nums[i - 1]) {
                found = true;
                break;

            }

        }
        // EdgeCase
        if (!found) {
            return nums[size - 1];
        }

        return nums[index - 1];
    }


    // The brutal force solution would be create two arrays and copy the need k elmenents
    // to the first array, then copy the remaining element to the second
    // We need to swap from a[n-i] for a[k-i], and stop when k - i < 0
    public void rotate(int[] nums, int k) {
        // TODO FIXED IT, IT IS WRONG
        int n = nums.length;
        if (k > n) k = k%n;
        for (int i = 1; i <= k && k-i>=0 && k <= n ; i++) {
            int temp = nums[n-i];
            nums[n-i] = nums[k-i];
            nums[k-i] = temp;
        }

    }

    public void reverseArray(int[] arr) {
        int sizeArray = arr.length;
        for (int i = 0, j = sizeArray-1 ; i < j ; i++,j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    public void reversePartialArray(int[] arr, int start, int end) {
        for (int i = start, j = end-1 ; i <  j; i++,j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


    public void rotateUsingExtraArray(int[] nums, int k) {
        // TODO CAN I DO IT BETTER?
        int n = nums.length;
        if(k>=n) {
            k = k%n;
        }
        if (k > 0) {
            int[] tempArray = new int[n];
            for (int i = 0; i < n-k ; i++) {
                tempArray[i] = nums[i];
            }
            // copy the k element to first array
            for (int j = n-k, m = 0; j < n; j++,m++ ) {
                nums[m] = nums[j];
            }
            for (int x = 0, y = k ; y < n ;x++,y++ ) {
                nums[y] = tempArray[x];
            }
        }
    }

    /**
     *
     * This method using two pointers technique to remove element
     * The key here is j is continue to decrease
     * @param a
     * @param val
     * @return
     */
    public int removeElement(int[] a, int val) {
        int i = 0, j = a.length-1;

        while(i<=j) { // equals handle the case only one element
            while(a[j]==val) {
                if(j == i) {
                    j--;
                    break;
                }
                j--;
            }

            while(a[i]!=val) {
                if(i==j) break;
                i++;
            }

            if(i>=j) break;
            a[i++] = a[j--];
        }
        if(j < 0 ) return 0;
        return j+1;

    }

    /**
     *
     * @param a
     * @return
     */
    public int removeDuplicates(int[] a) {
        int N = a.length;
        int i = 0;
        int j = i+1;
        while(j < N) {
            if(a[j-1] == a[j]) j++;
            // when assign different element, move the i pointer a head
            else a[++i] = a[j++];
        }
        return i+1;
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            if(nums[i] == nums[i-1]) return true;
        }
        return false;
    }

    /**
     *  using the same technique in merge of merge short
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        int[] tempArray = new int[m];
        for(int k = 0; k < m; k++)
            tempArray[k] = nums1[k];

        int i = 0, j = 0, k = 0;
        while(k < m+n) {
            if (i == m)                         nums1[k++] = nums2[j++];
            else if (j == n)                    nums1[k++] = tempArray[i++];
            else if(tempArray[i] > nums2[j])    nums1[k++] = nums2[j++];
            else                                nums1[k++] = tempArray[i++];
        }
    }


}
