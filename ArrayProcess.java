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
}
