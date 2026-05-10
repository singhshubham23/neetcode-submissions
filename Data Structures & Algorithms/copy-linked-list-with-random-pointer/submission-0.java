/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node newHead = head.next;
        Node currOld = head;
        Node currNew = newHead;

        while(currOld != null){
            currOld.next = currOld.next.next;
                if(currNew.next != null){
                    currNew.next = currNew.next.next;
                }
                currOld = currOld.next;
                currNew = currNew.next;
            }
        return newHead;
    }
}
