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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;
        int min = Integer.MAX_VALUE;
        while(curr!=null){
            list.add(curr.val);
            curr=curr.next;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(list.size()<=2)return new int[]{-1,-1};
        int prev = list.get(0);
        int n = list.size();
        for(int i=1;i<=n-2;i++){
            int cur = list.get(i);
            if(cur>prev && cur>list.get(i+1)){
                ans.add(i);
            }
            else if(cur<prev && cur<list.get(i+1)){
                ans.add(i);
            }
            prev = cur;
        }
        if(ans.size()<=1)return new int[]{-1,-1};
        int max = ans.get(ans.size()-1)-ans.get(0);
        for(int i=1;i<ans.size();i++){
            min = Math.min(min,ans.get(i)-ans.get(i-1));
        }
        if(min==Integer.MAX_VALUE) return new int[]{-1,-1};
        return new int[]{min,max};
    }
}