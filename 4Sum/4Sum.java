import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        // Trier le tableau pour utiliser efficacement les deux pointeurs
        Arrays.sort(nums);
        
        // Parcourir chaque élément du tableau pour former des quadruplets
        for (int i = 0; i < nums.length - 3; i++) {
            // Éviter les doublons pour le premier élément du quadruplet
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                // Éviter les doublons pour le deuxième élément du quadruplet
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                int left = j + 1;
                int right = nums.length - 1;
                
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Éviter les doublons pour le troisième élément du quadruplet
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Éviter les doublons pour le quatrième élément du quadruplet
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}
