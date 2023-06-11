import java.util.*;

/**
 * 学习JAVA
 *
 * @项目名称：
 * @子庚木上
 * @Date：2023/5/10 - 05 - 10 - 15:10
 * @version： 1.0
 * @功能：
 */
public class ArrPractice {

    public static void main(String []args){
            System.out.println(1<<1);
            int[] nums={3,2,4,7,8};
            sum(nums);
            for(int cur:nums){
                System.out.println(cur);
            }
            int [][]accounts={{1,2,3},{3,2,1}};
            System.out.println(maximumWealth(accounts));
            int []prices={7,6,4,3,7,1,3,71,2,4,6,9,123,234,1};
            System.out.println(maxProfitdp(prices));
            System.out.println(maxProfitdp2(prices));
            System.out.println(maxProfittx(prices));
            int []rotatearr={1,2,3,4,5,6,7,8};
            rotate(rotatearr,3);
            for(int cur:rotatearr){
                System.out.print(cur+" ");
            }
            System.out.println();
            System.out.println(containsDuplicate(rotatearr));
            int []nums1=new int[]{3,2,4};
            int []twoSumArr=twoSum(nums1,6);
            System.out.println(twoSumArr[0]+" "+twoSumArr[1]);
        }
        public static int [] sum(int[]arr){
            int all=0;
            for(int i=0;i<arr.length;i++){
                all+=arr[i];
                arr[i]=all;
            }
            return arr;
        }
        public static int toMakeItZero(int num){
            int i=0;
            while(num>0){
                num=num%2==0?num/2:num-1;
                i++;
            }
            return i;
        }
        public static int maximumWealth(int[][] accounts) {
            int max=0;
            for(int i=0;i<accounts.length;i++){
                for(int j=1;j<accounts[0].length;j++){
                    accounts[i][j]=accounts[i][j]+accounts[i][j-1];
                }
                max=accounts[i][accounts[i].length-1]>max?accounts[i][accounts[i].length-1]:max;
            }
            return max;
        }
        public List<String> fizzBuzz(int n) {
            List<String> ans=new ArrayList<>();
            for(int i=1;i<=n;i++){
                if(i%3==0&&i%5==0){
                    ans.add("FizzBuzz");
                }
                else if(i%3==0){
                    ans.add("Fizz");
                }
                else if(i%5==0){
                    ans.add("Buzz");
                }
                else{
                    ans.add(""+i);
                }
            }
            return ans;
        }
        public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
        public ListNode middleNode(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            ListNode fast=head;
            ListNode slow=head;
            while(fast!=null&&fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow;
        }
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] target=new int[26];
            int[] use=new int[26];
            for(int i=0;i<magazine.length();i++){
                use[magazine.charAt(i)-'a']++;
            }
            for(int i=0;i<ransomNote.length();i++){
                target[ransomNote.charAt(i)-'a']++;
                if(target[ransomNote.charAt(i)-'a']>use[ransomNote.charAt(i)-'a']){
                    return false;
                }
            }
            return true;
        }
        public int removeDuplicates(int[] nums) {
            int length=nums.length;
            for(int i=1;i<nums.length;i++){
                if(nums[i]!=nums[length]){
                    nums[++length]=nums[i];
                }
            }
            return length;
        }
        public static int maxProfit(int[] prices) {
            return toOrNot(prices,0,0,false);
        }
        public static int toOrNot(int[]prices,int ans,int i,boolean flag){
            if(i==prices.length) return 0;
            return !flag?Math.max(ans-prices[i]+toOrNot(prices,ans,i+1,true),
                    ans+toOrNot(prices,ans,i+1,false)):
                    Math.max(ans+prices[i]+toOrNot(prices,ans,i+1,false),ans+toOrNot(prices,ans,i+1,true));
        }
        public static int maxProfitdp(int[] prices){
            if(prices.length<=1)return 0;
            int [][]dp=new int[prices.length][2];
            dp[0][0]=0-prices[0];
            for(int i=1;i<prices.length;i++){
                dp[i][0]=Math.max(dp[i-1][1]-prices
                        [i],dp[i-1][0]);
                dp[i][1]=Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
            }
            return dp[prices.length-1][1];
        }
        public static int maxProfitdp2(int[] prices){
            if(prices.length<=1)return 0;
            int []dp=new int[2];
            dp[0]=0-prices[0];
            for(int i=1;i<prices.length;i++){
                int temp=dp[0];
                dp[0]=Math.max(dp[1]-prices
                        [i],dp[0]);
                dp[1]=Math.max(temp+prices[i],dp[1]);
            }
            return dp[1];
        }
        public static int maxProfittx(int[] prices){
            if(prices.length<=1)return 0;
            int ans=0;
            for(int i=1;i<prices.length;i++){
                if(prices[i]>prices[i-1]){
                    ans+=prices[i]-prices[i-1];
                }
            }
            return ans;
        }
        public boolean searchMatrix(int[][] matrix, int target) {
            int ansi=matrix.length-1,ansj=matrix[0].length-1;
            for(int i=0,j=0;i<=ansi&&j<=ansj;i++,j++){
                for(int p=i;p<=ansi;p++){
                    if(matrix[p][j]==target) return true;
                    if(matrix[p][j]>target) ansi=p-1;
                }
                for(int p=j;p<=ansj;p++){
                    if(matrix[i][p]==target) return true;
                    if(matrix[i][p]>target) ansj=p-1;
                }
            }
            return false;
        }
        public boolean searchMatrixMN(int[][] matrix, int target) {
            if(matrix==null||matrix.length==0) return false;
            int i=0,j=matrix[0].length-1;
            while(i<matrix.length&&j>=0){
                if(matrix[i][j]==target) return true;
                if(matrix[i][j]>target) j--;
                else i++;
            }
            return false;
        }
        public static void rotate(int[] nums, int k) {
            k=k%nums.length;
            int t=nums[0];
            int pre=0;
            int i=0;
            int length=nums.length;
            while(length-->1){
                if((i+nums.length-k)%nums.length==pre){
                    nums[i]=t;
                    pre++;
                    pre=pre%nums.length;
                    i=pre;
                    t=nums[pre];
                }
                else{
                    nums[i]=nums[(i+nums.length-k)%nums.length];
                    i=(i+nums.length-k)%nums.length;
                }
            }
            nums[i]=t;
        }
        public static boolean containsDuplicate(int[] nums){
            if(nums.length<1) return false;
            Set<Integer> set=new HashSet<>();
            for(int cur:nums){
                if(!set.contains(cur)) {
                    set.add(cur);
                }
                else return true;
            }
            return false;
        }
        public int singleNumber(int[] nums) {
            int eor=0;
            for(int i=0;i<nums.length;i++){
                eor=eor^nums[i];
            }
            return eor;
        }
        public int[] plusOne(int[] digits) {
            int cnt=1;
            for(int i=digits.length-1;i>=0;i--){
                if(digits[i]==9) {
                    digits[i]=0;
                }
                else {
                    digits[i]++;
                    break;
                }
            }
            if(digits[0]==0) {
                int []ans=new int [digits.length+1];
                ans[0]=1;
                return ans;
            }
            return digits;
        }
        public void moveZeroes(int[] nums) {
            int r=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0){
                    nums[r++]=nums[i];
                }
            }
            for(int i=r;i<nums.length;i++){
                nums[i]=0;
            }
        }
        public static void swap(int[] arr,int i,int j){
            arr[i]=arr[i]+arr[j];
            arr[j]=arr[i]-arr[j];
            arr[i]=arr[i]-arr[j];
        }
        public int[] intersect(int[] nums1, int[] nums2) {
            int []ans=new int [Math.min(nums1.length,nums2.length)];
            selectSort(nums1);
            selectSort(nums2);
            int r=0,r1=0,r2=0;
            while(r1<nums1.length&&r2<nums2.length){
                if(nums1[r1]==nums2[r2]){
                    ans[r++]=nums1[r1];
                    r1++;
                    r2++;
                }
                else if(nums1[r1]<nums2[r2]){
                    r1++;
                }
                else r2++;
            }
            int []help=new int [r];
            for(int i=0;i<r;i++){
                help[i]=ans[i];
            }
            return help;
        }
        public static void selectSort(int[]arr){
            for(int i=0;i<arr.length-1;i++){
                for(int j=i+1;j<arr.length;j++){
                    if(arr[j]<arr[i]){
                        swap(arr,i,j);
                    }
                }
            }
        }
        public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<nums.length;i++){
                map.put(nums[i],i);
            }
            int []ans=new int [2];
            for(int i=0;i<nums.length;i++){
                if(map.get(target-nums[i])!=null&&map.get(target-nums[i])!=i){

                    ans[0]=i;
                    ans[1]=map.get(target-nums[i]);
                    break;
                }
            }
            return ans;
        }
        public void rotate(int[][] matrix) {
            int a=0,b=0,c=matrix.length,d=matrix.length;
            singalCircle(matrix,a,b,c,d);
        }
        public void singalCircle(int[][]matrix,int a,int b,int c,int d){
            if(a==c) return;
            for(int i=0;i<c-a;i++){
                int temp=matrix[a][b+i];
                matrix[a][b+i]=matrix[c-i][b];
                matrix[c-i][b]=matrix[c][d-i];
                matrix[c][d-i]=temp;
            }
            singalCircle(matrix,a++,b++,c--,d--);
        }
        public boolean isValidSudoku(char[][] board) {
            int flag=0;
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]!='.'){
                        int temp=1<<(board[i][j]-'0'-1);
                        if((flag&temp)!=0){
                            return false;
                        }
                        flag=flag|temp;
                    }
                }
                flag=0;
            }
            for(int j=0;j<board[0].length;j++){
                for(int i=0;i<board.length;i++){
                    if(board[i][j]!='.'){
                        int temp=1<<(board[i][j]-'0'-1);
                        if((flag&temp)!=0){
                            return false;
                        }
                        flag=flag|temp;
                    }

                }
                flag=0;
            }
            if(!singalNine(board,0,0)) return false;
            if(!singalNine(board,0,3)) return false;
            if(!singalNine(board,0,6)) return false;
            if(!singalNine(board,3,0)) return false;
            if(!singalNine(board,3,3)) return false;
            if(!singalNine(board,3,6)) return false;
            if(!singalNine(board,6,0)) return false;
            if(!singalNine(board,6,3)) return false;
            if(!singalNine(board,6,6)) return false;
            return true;
        }
        public boolean singalNine(char [][]board,int a,int b){
            int flag=0;
            for(int i=a;i<a+3;i++){
                for(int j=b;j<b+3;j++){
                    if(board[i][j]!='.'){
                        int temp=1<<(board[i][j]-'0'-1);
                        if((flag&temp)!=0){
                            return false;
                        }
                        flag=flag|temp;
                    }
                }
            }

            return true;
        }

}
