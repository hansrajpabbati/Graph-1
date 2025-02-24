/**
 Time Complexity - O(E) where E is the number of trust relationships (edges)
 Space Complexity - O(N)
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] netScore = new int[n];

        for (int[] entry : trust) {
            int trustee = entry[0];
            int trusted = entry[1];
            netScore[trusted-1]++;
            netScore[trustee-1]--;
        }
        for (int i=0; i<n; i++) {
            if (netScore[i] == n-1) {
                return i+1;
            }
        }
        return -1;
    }
}