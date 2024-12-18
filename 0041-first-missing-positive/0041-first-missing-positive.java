class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // Iterate through the array to place each number in its correct position
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] to its correct position
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        // Iterate through the array to find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // If all positive integers from 1 to n are present, return n+1
        return n + 1;
    }
    }