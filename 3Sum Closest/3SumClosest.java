class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Trier le tableau pour utiliser deux pointeurs
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];

        // Parcourir chaque élément du tableau
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            // Utiliser deux pointeurs pour trouver les deux autres éléments
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // Si la somme actuelle est plus proche du target que la somme la plus proche jusqu'à présent
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Déplacer les pointeurs selon la valeur de currentSum par rapport à target
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    // Si currentSum est exactement égal à target, retourner currentSum
                    return currentSum;
                }
            }
        }

        // Retourner la somme la plus proche trouvée
        return closestSum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test case 1
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        System.out.println(sol.threeSumClosest(nums1, target1)); // Output: 2

        // Test case 2
        int[] nums2 = {0, 0, 0};
        int target2 = 1;
        System.out.println(sol.threeSumClosest(nums2, target2)); // Output: 0
    }
}
