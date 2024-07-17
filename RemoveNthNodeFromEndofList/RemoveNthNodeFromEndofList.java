/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Création d'un nœud fictif qui pointe sur le début de la liste
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialisation de deux pointeurs
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Avancer le premier pointeur de n+1 étapes
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // Avancer les deux pointeurs jusqu'à ce que le premier atteigne la fin
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Le second pointeur pointe maintenant sur le nœud précédent celui à supprimer
        second.next = second.next.next;
        
        // Retourner la tête de la liste modifiée
        return dummy.next;
    }
}
