//TYAGHER MSURSHIMA
//VUG/SEN/24/11923

import java.util.Random;

/**
 * LeetCode 382: Linked List Random Node
 * Approach: Reservoir Sampling (O(1) Space, O(N) Time)
 */
public class LinkedListRandomNode {

    // Definition for singly-linked list node.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        private ListNode head;
        private Random random;

        /**
         * Initializes the object with the head of the singly-linked list.
         * @param head The head node of the linked list.
         */
        public Solution(ListNode head) {
            this.head = head;
            this.random = new Random();
        }

        /**
         * Chooses a node randomly from the list and returns its value.
         * Every node has an equal probability (1/N) of being selected.
         *
         * @return The value of the randomly selected node.
         */
        public int getRandom() {
            int chosenVal = this.head.val;
            ListNode curr = this.head;
            int i = 1;

            while (curr != null) {
                // Generate random integer in range [0, i - 1].
                // Probability of picking 0 is exactly 1/i.
                if (random.nextInt(i) == 0) {
                    chosenVal = curr.val;
                }
                curr = curr.next;
                i++;
            }

            return chosenVal;
        }
    }

    public static void main(String[] args) {
        // Sample Test Case: 1 -> 2 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        Solution solution = new Solution(head);

        System.out.println("Random node value: " + solution.getRandom());
        System.out.println("Random node value: " + solution.getRandom());
        System.out.println("Random node value: " + solution.getRandom());
    }
}