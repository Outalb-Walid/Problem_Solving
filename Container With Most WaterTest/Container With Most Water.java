class Solution {
    public int maxArea(int[] height) {
        int left = 0; // Initialise le pointeur gauche au début du tableau
        int right = height.length - 1; // Initialise le pointeur droit à la fin du tableau
        int maxArea = 0; // Initialise la variable pour stocker l'aire maximale

        while (left < right) { // Continue tant que les deux pointeurs ne se sont pas croisés
            int width = right - left; // La largeur est la distance entre les deux pointeurs
            int h = Math.min(height[left], height[right]); // La hauteur est la plus petite des deux hauteurs pointées
            maxArea = Math.max(maxArea, width * h); // Calcule l'aire et met à jour maxArea si nécessaire

            if (height[left] < height[right]) {
                left++; // Déplace le pointeur gauche vers l'intérieur si la hauteur gauche est plus petite
            } else {
                right--; // Déplace le pointeur droit vers l'intérieur si la hauteur droite est plus petite
            }
        }

        return maxArea; // Retourne l'aire maximale trouvée
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height)); // Affiche 49
    }
}
