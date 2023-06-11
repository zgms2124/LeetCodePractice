/**
 * 学习JAVA
 *
 * @项目名称：
 * @计通2204李志杨
 * @Date：2023/5/15 - 05 - 15 - 20:06
 * @version： 1.0
 * @功能：
 */
public class DpPractice {
    public static void main(String []args){
//        for(int i=0;i<10;i++){
//                   System.out.println( (int)(Math.random()*1));
//        }
        MinStack mm=new MinStack();
        mm.push(1);
        System.out.println(mm.top()+" "+mm.getMin());
        mm.push(2);
        System.out.println(mm.top()+" "+mm.getMin());
        mm.push(3);
        System.out.println(mm.top()+" "+mm.getMin());
        mm.push(4);
        System.out.println(mm.top()+" "+mm.getMin());
        mm.pop();
        System.out.println(mm.top()+" "+mm.getMin());
        mm.pop();
        System.out.println(mm.top()+" "+mm.getMin());
        mm.pop();
        System.out.println(mm.top()+" "+mm.getMin());
    }

    public int climbStairsdg(int n) {
        return climbStairs(n,0);
    }
    public int climbStairsdp(int n) {
        int []dp=new int[n+1];
        dp[n]=0;
        dp[n-1]=1;
        for(int i=n-1;i>=0;i--){
            dp[i]=dp[i+1]+dp[i+2];
        }
        return dp[0];
    }
    public int climbStairs(int n,int cur) {
        if(cur==n) return 1;
        if(cur>n) return 0;
        return climbStairs(n,cur+1)+climbStairs(n,cur+2);
    }
    public int maxProfitdg(int[] prices) {
        return maxProfit(prices,0,0);
    }
    public int maxProfit(int[] prices,int cur,int n) {
        if(n==prices.length) return 0;
        if(cur==0){
            return Math.max(maxProfit(prices,-1,n+1)-prices[n],maxProfit(prices,cur,n+1));
        }
        if(cur==-1){
            return Math.max(prices[n],maxProfit(prices,cur,n+1));
        }
        return 0;
    }
    public int maxProfitdp(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int n=prices.length;
        int [][]dp=new int[n][2];
        dp[0][0]=0;
        dp[0][1]=0-prices[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[n-1][0];
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d>jobDifficulty.length) return -1;
        return minDifficulty(jobDifficulty,d,0,0);
    }
    public int minDifficulty(int[] jobDifficulty, int d,int cur,int day) {
        if(jobDifficulty.length-cur<d-day) return 333333;
        if(day==d) {
            if(cur==jobDifficulty.length) return 0;
            return 333333;
        }
        int min=333333;
        for(int i=cur;i<=jobDifficulty.length-(d-day);i++){
            min=Math.min(hard(jobDifficulty,cur,i)+minDifficulty(jobDifficulty,d,i+1,day+1),min);
        }
        if(min==333333) return -1;
        return min;
    }
    public int hard(int[] jobDifficulty,int cur,int i){
        int max=0;
        for(cur=cur;cur<=i;cur++){
            if(jobDifficulty[cur]>max) max=jobDifficulty[cur];
        }
        return max;
    }
    public int minDifficultydp(int[] jobDifficulty, int d) {
        if(d>jobDifficulty.length) return -1;
        int[][] dp=new int[jobDifficulty.length+1][d+1];
        int[][]hard=new int[jobDifficulty.length+1][jobDifficulty.length+1];
        for(int i=1;i<=jobDifficulty.length;i++){
            for(int j=i;j<=jobDifficulty.length;j++){
                int max=0;
                for(int cur=i;cur<=j;cur++){
                    if(jobDifficulty[cur]>max) max=jobDifficulty[cur];
                }
                hard[i][j]=max;
            }
        }
        for(int i=jobDifficulty.length;i>=0;i--){
            for(int j=d;j>=0;j--){
                if(jobDifficulty.length-i<d-j) {
                    dp[i][j]=333333;
                    continue;
                }
                if(j==d) {
                    if(!(i==jobDifficulty.length)) dp[i][j]=333333;
                    else{
                        if(j==jobDifficulty.length) dp[i][j] =0;
                    }
                    continue;
                }
                int min=333333;
                for(int k=i;k<=jobDifficulty.length-(d-j);k++){
                    min=Math.min(hard[i][k]+dp[k+1][j+1],min);
                }
                if(min==333333) dp[i][j]=-1;
                else dp[i][j]=min;
            }
        }
        return dp[0][0]!=333333?dp[0][0]:-1;
    }
    public int maxSubArray(int[] nums) {
        int sum1=Integer.MIN_VALUE,sum2=0;
        for(int i=0;i<nums.length;i++){
            sum2+=nums[i];
            if(sum2>sum1) sum1=sum2;
            if(sum2<0) sum2=0;
        }
        return sum1;
    }
    public int rob(int[] nums) {
        int length=nums.length;
        int [][]dp=new int [length][2];
        dp[length-1][0]=nums[length-1];
        for(int i=length-2;i>=0;i--){
            dp[i][0]=nums[i]+dp[i+1][1];
            dp[i][1]=Math.max(dp[i+1][0],dp[i+1][1]);
        }
        return Math.max(dp[0][0],dp[0][1]);
    }
    class Solution {
        int []nums=new int[55];
        int length;
        public Solution(int[] nums) {
            for(int i=0;i<nums.length;i++){
                this.nums[i]=nums[i];
            }
            this.length=nums.length;
        }
        public int[] reset() {
            return nums;
        }
        public int[] shuffle() {
            int []ans=nums;
            int r=0;
            for(int i=length-1;i>=0;i--){
                int kill=(int)(Math.random()*(i+1));
                ans[r++]=nums[kill];
                nums[i]=nums[i]+nums[kill];
                nums[kill]=nums[i]-nums[kill];
                nums[i]=nums[i]-nums[kill];

            }
            return nums;
        }
    }
    public static class MinStack  {
        Node minStack;
        Node stack;
        class Node{
            int value;
            Node next;
            public Node(){
            }
            public Node(int value){
                this.value=value;
            }
        }
        public MinStack() {
        }
        public void push(int val) {
            Node temp=stack;
            stack=new Node(val);
            stack.next=temp;
            temp=minStack;
            minStack=new Node(getMin()<val?getMin():val);
            minStack.next=temp;
        }

        public void pop() {
            stack=stack.next;
            minStack=minStack.next;

        }

        public int top() {
            return stack.value;
        }

        public int getMin() {
            if(minStack==null) return Integer.MAX_VALUE;
            return minStack.value;
        }
    }
}
