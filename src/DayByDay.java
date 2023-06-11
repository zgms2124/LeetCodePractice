import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.javafx.geom.Edge;
import org.jcp.xml.dsig.internal.SignerOutputStream;
import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import java.awt.font.NumericShaper;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

/**
 * 学习JAVA
 *
 * @项目名称：
 * @计通2204李志杨
 * @Date：2023/5/11 - 05 - 11 - 19:33
 * @version： 1.0
 * @功能：
 */
public class DayByDay {
    class test{
        int a1;
        String c2;
        boolean []tt;

    }
    public static void main(String []args){
//        for(int j=7;j<10000;j++){
//            if(zhishu(j)){
//                System.out.print(j+":");
//                System.out.println(smallestRepunitDivByK(j));
//            }
//
//        }
        System.out.println();
        int[] arr=new int []{22,34,2,44,-8,49,-5,22,46,39,-23,-15,27,48,-37,10,22,-45,13,-2};
//        maxValueAfterReverse(arr);
//        findMaxK(arr);
        int [][]maxtrix=new int[][]{{0,1},{0,1}};
        System.out.println();
        System.out.println(maxEqualRowsAfterFlips(maxtrix));
        System.out.println(maxEqualRowsAfterFlipsBL(maxtrix,0));
        int [][]mat=new int[][]{{666,999,7777},{2,4,6}};
        System.out.println(kthSmallest(mat,9));
    }
    public static boolean zhishu(int x){
        for(int i=2;i<x;i++){
            if(x%i==0) return false;
        }
        return true;
    }
    public static void fenJie(){
        int j=1;
        while(j>0){
            System.out.print(j+":");
            fenjie(j);
            System.out.println();
            j=j*10+1;
        }
    }
    public static void fenjie(int x){
        for(int i=2;i<=x;i++){
            if(x%i==0){
                System.out.print(i+" ");
                x/=i;
                i=1;
            }
        }
    }
    public static void num11(){
        for(int i=1;i<100000;i++){
            double j=1;
            while(j>0&&j<Integer.MAX_VALUE&&j%i!=0){
                j=j*10+1;
            }

            if(j%i!=0) {
                System.out.print(i);
//                System.out.print(" "+j);
                System.out.println();
            }

        }
    }
    public boolean strStr(String haystack, char[] needle) {
        if(needle.length>haystack.length()) return false;
        if(needle.length==1){
            for(int i=0;i<haystack.length();i++){
                if(haystack.charAt(i)==needle[0]){
                    return true;
                }
            }
            return false;
        }
        int []next=new int[needle.length];
        next[0]=-1;
        next[1]=0;
        int i=2,j=0;
        while(i<needle.length){
            if(needle[j]==needle[i-1]){
                next[i++]=++j;
            }
            else if(j>0){
                j=next[j];
            }
            else{
                next[i++]=0;
            }
        }
        i=0;j=0;
        while(i<haystack.length()&&j<needle.length){
            if(haystack.charAt(i)==needle[j]){
                i++;
                j++;
            }
            else if(j!=0){
                j=next[j];
            }
            else{
                i++;
            }
        }
        if(j==needle.length) return true;
        return false;
    }
    public void reverseString(char[] s) {
        for(int i=0;i<s.length/2;i++){
            char temp=s[i];
            s[i]=s[s.length-i-1];
            s[s.length-i-1]=temp;
        }
    }
    public boolean queryStringdd(String s, int n) {
        for(int i=1;i<=n;i++){
            int t=i;
            StringBuilder temp=new StringBuilder();
            while(t>0){
                temp.append(t%2);
                t/=2;
            }
            temp.reverse();
            if(!s.contains(temp.toString())){
                return false;
            }
        }
        return true;
    }
    public boolean queryString(String s, int n) {
        for(int i=1;i<=n;i++){if(!s.contains(Integer.toBinaryString(i))){return false;}}
        return true;
    }
    public static int smallestRepunitDivByK(int k) {
        if(k%2==0||k%5==0) return-1;
        /*不考虑1的情况下，除了2（111不可能是偶数），5（111不可能以0/5结尾）之外的质数都有解，而任意非质数都可以化为质数的乘积，所以只要不是2、5倍数就有解*/
        int ans=1;
        for(int i=1;i%k!=0;ans++){
            i%=k;
            /*已知某个数i是k的x倍，那么i-k的y倍的时候，依旧是k的倍数（k的y-x倍），所以可以取模运算*/
            i=i*10+1;
        }
        return ans;
    }
    public int countTime(String time) {
        int ans=0;
        int a=time.charAt(0),b=time.charAt(1),c=time.charAt(3),d=time.charAt(4);
        if (a == '?') ans = (b == '?' || b < '4') ? 3 : 2;
        if (b == '?') ans = ans == 0 ? (a == '2' ? 4 : 10) : ans * 8;
        if (c == '?') ans = ans == 0 ? 6 : ans * 6;
        if (d == '?') ans = ans == 0 ? 10 : ans * 10;
        return ans;
    }
    public static int maxValueAfterReverse(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        for(int i=0;i<nums.length-1;i++){
            ans+= Math.abs(nums[i]-nums[i+1]);
        }
        System.out.println(ans);
        int max=0;
        for(int i=0;i<nums.length-1;i++){
            int d1=0,d2=0,d3=0,d4=0;
            d1= i!=0?Math.abs(nums[i]-nums[i-1]):0;
            for(int j=i+1;j<nums.length;j++){
                d2=j==nums.length-1?0:Math.abs(nums[j]-nums[j+1]);
                d3=j==nums.length-1?0:Math.abs(nums[i]-nums[j+1]);
                d4=i!=0?Math.abs(nums[j]-nums[i-1]):0;
                if((d3+d4>d1+d2)&&(d3+d4-d1-d2)>max){
                    max=d3+d4-d1-d2;

                }
            }
        }

        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        ans+=max;
        System.out.println(ans);

        return ans+max;
    }
    public static void swap(int[] arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
    public static int findMaxK(int[] nums) {
        PriorityQueue <Integer>q1=new PriorityQueue(new Mycmp()),q2=new PriorityQueue(new Mycmp());
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                q1.add(nums[i]);
            }
            else{
                q2.add(0-nums[i]);
            }
        }
        if(q1.isEmpty()||q2.isEmpty()) {
            return -1;
        }
        int temp1=q1.poll(),temp2=q2.poll();
        while(!q1.isEmpty()||!q2.isEmpty()){
            if(temp1==temp2) return temp1;
            else if(temp1>temp2) {
                if(q1.isEmpty()) return -1;
                temp1=q1.poll();
            }
            else {
                if(q2.isEmpty()) return -1;
                temp2 = q2.poll();
            }
        }
        return -1;
    }


    public int[] rearrangeBarcodes(int[] barcodes) {
        if(barcodes.length<=1) return barcodes;
        int []barket=new int[10006];
        for(int i=0;i<barcodes.length;i++){
            barket[barcodes[i]]++;
        }
        int []ans=new int[barcodes.length];
        PriorityQueue <Node>q=new PriorityQueue<>();
        for(int i=1;i<barket.length;i++){
            if(barket[i]!=0){
                q.add(new Node(i,barket[i],0));
            }
        }
        int r=0;
        Node temp1=q.poll();
        ans[r++]=temp1.value;
        temp1.count--;
        Node temp2;
        while(!q.isEmpty()){
            temp2=q.poll();
            ans[r++]=temp2.value;
            temp2.count--;
            Node temp3=temp2;
            temp2=temp1;
            temp1=temp3;
            if(temp2.count!=0){
                q.add(temp2);
            }
        }
        return ans;

    }
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        int ans=0;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<matrix.length;i++){
            StringBuilder str=new StringBuilder();
            for(int j=0;j<matrix[0].length;j++){
                str.append('0'+matrix[i][0]^matrix[i][j]);
            }
            map.put(str.toString(), map.getOrDefault(str.toString(), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans= Math.max(ans,entry.getValue());
        }
        return ans;
    }
    public static int maxEqualRowsAfterFlipsBL(int [][]matrix,int i){
        int [][]dp=new int[matrix[0].length+1][2];
        if(i==matrix[0].length) {
            int ans=0;
            for(int j=0;j<matrix.length;j++){
                int k;
                for(k=1;k<matrix[0].length;k++){
                    if(matrix[j][k]!=matrix[j][k-1]){
                        break;
                    }
                }
                if(k==matrix[0].length)ans++;
            }
            return ans;
        }
        int ans1=maxEqualRowsAfterFlipsBL(matrix,i+1);
        for(int j=0;j<matrix.length;j++){
            if(matrix[j][i]==0){
                matrix[j][i]=1;
            }
            else{
                matrix[j][i]=0;
            }
        }
        int ans2=maxEqualRowsAfterFlipsBL(matrix,i+1);
        for(int j=0;j<matrix.length;j++){
            if(matrix[j][i]==0){
            matrix[j][i]=1;
        }
        else{
            matrix[j][i]=0;
        }
        }
        return Math.max(ans1,ans2);
    }
    public boolean haveConflict(String[] event1, String[] event2) {
        int t1=((event1[0].charAt(0)-'0')*10+(event1[0].charAt(1)-'0'))*60+((event1[0].charAt(3)-'0')*10+(event1[0].charAt(4)-'0'));
        int t2=((event2[0].charAt(0)-'0')*10+(event2[0].charAt(1)-'0'))*60+((event2[0].charAt(3)-'0')*10+(event2[0].charAt(4)-'0'));
        int t3=((event1[1].charAt(0)-'0')*10+(event1[1].charAt(1)-'0'))*60+((event1[1].charAt(3)-'0')*10+(event1[1].charAt(4)-'0'));
        int t4=((event2[1].charAt(0)-'0')*10+(event2[1].charAt(1)-'0'))*60+((event2[1].charAt(3)-'0')*10+(event2[1].charAt(4)-'0'));
        return (t1>=t2&&t1<=t4)||(t2>=t1&&t2<=t3);
    }
    public int countPrimes(int n) {
            if(n<=2) return 0;
            int cnt=n-2;
            boolean []isZ=new boolean[n];
            for(int i=3;i*i<n;i++){
                if(isZ[i]==true) continue;;
                for(int j=i*2;j<n;j+=i){
                    if(isZ[j]==false) {

                        isZ[j]=true;
                        cnt--;
                    }
                }
            }
            return cnt;
    }

    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        return 1162261467%n==0;

    }
    public int romanToInt(String s) {
        int ans=0;
        int length=s.length();
        for(int i=0;i<length;i++){
            switch (s.charAt(i)){
                case 'I':{
                    if(i==length-1){
                        ans+=1;
                    }
                    else{
                        if(s.charAt(i+1)=='V'){
                            i++;
                            ans+=4;
                        }
                        else if(s.charAt(i+1)=='X'){
                            i++;
                            ans+=9;
                        }
                        else ans+=1;
                    }
                        break;

                }case 'V':{
                    ans+=5;
                    break;

                }case 'X':{if(i==length-1){
                    ans+=10;
                }
                else{
                    if(s.charAt(i+1)=='V'){
                        i++;
                        ans+=40;
                    }
                    else if(s.charAt(i+1)=='X'){
                        i++;
                        ans+=900;
                    }
                    else ans+=10;
                }break;

                }case 'L':{
                    ans+=50;
                    break;

                }case 'C':{if(i==length-1){
                    ans+=100;
                }
                else{
                    if(s.charAt(i+1)=='V'){
                        i++;
                        ans+=400;
                    }
                    else if(s.charAt(i+1)=='X'){
                        i++;
                        ans+=900;
                    }
                    else ans+=100;
                } break;

                }case 'D':{
                    ans+=500;
                    break;

                }case 'M':{
                    ans+=1000;
                    break;

                }


            }
        }
        return ans;
    }
    public int hammingWeight(int n) {
        int ans=0;
        while(n!=0){
            if((n&1)!=0) ans++;
            n=n>>1;
        }
        return ans;
    }
    public int hammingDistance(int x, int y) {
        int temp=x^y;
        return hammingWeight(temp);
    }

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int length1=arr1.length-1,length2=arr2.length-1;
        int length3=Math.max(length1,length2)+2;
        int []ans=new int[length3+1];
        while(length1>=0&&length2>=0){
            int c=(arr1[length1]+arr2[length2]+ans[length3])/2;
            ans[length3]=(arr1[length1]+arr2[length2]+ans[length3])%2;
            ans[length3+1]+=c;
            ans[length3+2]+=c;
            length1--;
            length2--;
            length3--;
        }
        while(length2>=0){
            int c=(arr2[length2]+ans[length3])/2;
            ans[length3]=(arr2[length2]+ans[length3])%2;
            ans[length3+1]+=c;
            ans[length3+2]+=c;
            length1--;
            length2--;
            length3--;
        }
        while(length1>=0){
            int c=(arr1[length1]+ans[length3])/2;
            ans[length3]=(arr1[length1]+ans[length3])%2;
            ans[length3+1]+=c;
            ans[length3+2]+=c;
            length1--;
            length2--;
            length3--;
        }
        ans[0]=(ans[0]+ans[1]/2)%2;
        ans[1]%=2;
        length3=ans.length;
        for(int i=0;i<ans.length-1;i++){
            if(ans[i]==0){
                length3--;
            }
            else {
                break;
            }
        }
        int []t=new int[length3];
        for(int i=0;i<length3;i++){
            t[i]=ans[i+ans.length-length3];
        }
        return t;
    }
    public class UnionFind{
        private class Node{
            private int value;
            public Node(int value){
                this.value=value;
            }
            public Node(){
            }
        }
        private HashMap<Integer,Node> nodes;
        private HashMap<Node,Node> parents;
        private HashMap<Node,Integer> sizeMap;
        public UnionFind(){
            nodes=new HashMap<>();
            parents=new HashMap<>();
            sizeMap=new HashMap<>();
        }
        public void union(int a,int b){
            if(!nodes.containsKey(a)){
                Node temp=new Node(a);
                nodes.put(a,temp);
                parents.put(temp,temp);
                sizeMap.put(temp,1);
            }
            if(!nodes.containsKey(b)){
                Node temp=new Node(b);
                nodes.put(b,temp);
                parents.put(temp,temp);
                sizeMap.put(temp,1);
            }
            Node aFather=findFather(nodes.get(a)),bFather=findFather(nodes.get(b));
            if(aFather!=bFather){
                int aSize=sizeMap.get(aFather);
                int bSize=sizeMap.get(bFather);
                Node big=aSize>=bSize?aFather:bFather;
                Node small=big==aFather?bFather:aFather;
                parents.put(small,big);
                sizeMap.put(big,aSize+bSize);
                sizeMap.remove(small);
            }
        }
        public boolean isSameSet(int a,int b){
            if(!nodes.containsKey(a)||!nodes.containsKey(b)) return false;
            return findFather(nodes.get(a))==findFather(nodes.get(b));
        }
        public Node findFather(Node cur){
            Stack<Node> path=new Stack<>();
            while(cur!=parents.get(cur)){
                path.push(cur);
                cur=parents.get(cur);
            }
            while(!path.isEmpty()){
                parents.put(path.pop(),cur);
            }
            return cur;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        UnionFind uu=new UnionFind();
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1){
                    uu.union(i,j);
                }
            }
        }
        return uu.sizeMap.size();
    }
    public int numTilePossibilities(String tiles) {
        int []cc=new int[26];
        for(int i=0;i<tiles.length();i++){
            cc[tiles.charAt(i)-'A']++;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            if(cc[i]>0){
                cc[i]--;
                ans+=numTilePossibilities(cc);
                cc[i]++;
            }
        }
        return ans;
    }
    public int numTilePossibilities(int []arr) {
        int ans=1;
        for(int i=0;i<26;i++){
            if(arr[i]>0){
                arr[i]--;
                ans+=numTilePossibilities(arr);
                arr[i]++;
            }
        }
        return ans;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class InFo{
        boolean flag;
        int sum;
        int max;
        int min;
        public InFo(boolean flag,int sum,int max,int min){
            this.flag=flag;
            this.sum=sum;
            this.max=max;
            this.min=min;
        }
    }
    int mmax=0;
    public InFo isValidBST(TreeNode root) {
        if(root==null) return new InFo(true,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        InFo info1=isValidBST(root.left);
        InFo info2=isValidBST(root.right);
        int min=root.val,max=root.val;
            min=Math.min(Math.min(min,info1.min),info2.min);
        max=Math.max(Math.min(max,info1.max),info2.max);

        if(info1.flag&&info2.flag&&info1.max<root.val&&info2.min>root.val){
            int sum=root.val+info1.sum+info2.sum;
            mmax=Math.max(mmax,sum);
            return new InFo(true,sum,Math.max(root.val,info2.max),Math.max(root.val,info1.min));
        }
        else{
            return new InFo(false,0,0,0);
        }


    }
    public int maxSumBST(TreeNode root) {
        if(root==null) return 0;
        isValidBST(root);
        return mmax;
    }
    public int storeWaterff(int[] bucket, int[] vat) {
        int i=0;
        for(i=0;i<vat.length;i++){
            if(vat[i]>0) break;
        }
        if(i==vat.length) return 0;
        for(i=0;i<vat.length;i++){
            vat[i]-=bucket[i];
        }
        int min=1+storeWater(bucket,vat);
        for(i=0;i<vat.length;i++){
            vat[i]+=bucket[i];
        }
        for(i=0;i<vat.length;i++){
            if(vat[i]>bucket[i]) break;
        }
        if(i==vat.length) return 0;
        for(i=0;i<vat.length;i++){
            bucket[i]++;
            min=Math.min(min,1+storeWater(bucket,vat));
            bucket[i]--;
        }
        return min;
    }
    public int storeWater(int[] bucket, int[] vat) {
        int maxTime=Integer.MIN_VALUE;
        for(int i=0;i<vat.length;i++){
            maxTime=Math.max(bucket[i],maxTime);
        }
        if(maxTime==0) return 0;
        int ans=Integer.MAX_VALUE;
        for(int t=1;t<=maxTime&&t<ans;t++){
            int temp = 0;
            for (int i = 0; i < bucket.length; ++i) {
                temp += Math.max(0, (vat[i] + t - 1) / t - bucket[i]);
            }
            ans = Math.min(ans, temp + t);
        }
        return ans;
    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root==null||(root.left==null&&root.right==null&&root.val<limit)) return null;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        path(root,root,limit);
        return root;
    }
    public int path(TreeNode father,TreeNode root,int limit){
        if(root==null) return 0;
        int temp=root.val+Math.max(path(root,root.left,limit),path(root,root.right,limit));
        if(temp<limit) {
            if(root==father) root=null;
            if(root==father.left){
                father.left=null;
            }
            else{
                father.right=null;
            }
        }
        return temp;

    }
    public static class Mycmp implements Comparator<Node>{
        @Override
        public int compare(Node o1,Node o2){
            return o2.value-o1.value;
        }
    }
    public class Node{
        int value=0;
        int label;
        int count=0;
        public Node(int value,int label,int count){
            this.count=count;
            this.label=label;
            this.value=value;
        }
    }
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
           PriorityQueue<Node> q=new PriorityQueue<>(new Mycmp());
           for(int i=0;i<values.length;i++){
               q.add(new Node(values[i],labels[i],useLimit));
           }
           int ans=0;
           HashMap<Integer,Integer> map=new HashMap<>();
           int i=0;
           while(i<numWanted){
               if(q.isEmpty()) break;
               Node temp=q.poll();
               if(!map.containsKey(temp.label)){
                   ans+=temp.value;
                   i++;
                   map.put(temp.label,useLimit-1);
               }
               else if(useLimit>0){
                   ans+=temp.value;
                   map.put(temp.label,map.get(temp)-1);
                   i++;
               }
           }
           return ans;
    }
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] G=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            G[i]=new ArrayList<>();
        }
        for(int[]e:edges){
            G[e[0]].add(e[1]);
            G[e[1]].add(e[0]);
        }
        boolean []complete=new boolean[n+1];
        return move(G,1,t,complete,target);
    }
    public double move(List<Integer>[] G,int cur,int t ,boolean []complete,int  target) {
        int cnt=cur==1?G[cur].size():G[cur].size()-1;//除了根结点都有父结点，计算子结点的时候要扣去
        if(t==0||cnt==0) return cur==target?1.0:0;
        complete[cur]=true;
        double ans=0.0;
        for(int i:G[cur]){
            if(!complete[i]){
                ans+=move(G,i,t-1,complete,target);
            }
        }
        return ans/cnt;
    }
    public double frogPositionMy(int n, int[][] edges, int t, int target){
        int [][] map=new int[n+1][n+1];
        for(int[]e:edges){
            map[e[0]][e[1]]=1;
            map[e[0]][0]++;
            map[e[1]][e[0]]=1;
            map[e[1]][0]++;
        }
        boolean []complete=new boolean[n+1];
        return moveMy(map,1,t,complete,target);
    }
    public double moveMy(int [][]map,int cur,int t,boolean []complete,int target){
        int cnt=cur==1?map[cur][0]:map[cur][0]-1;
        if(t==0||cnt==0) return cur==target?1.0:0;
        double ans=0.0;
        complete[cur]=true;
        for(int i=1;i<map[cur].length;i++){
            if(!complete[i]&&map[cur][i]==1){
                ans+=moveMy(map,i,t-1,complete,target);
            }
        }
        return ans/cnt;
    }
    public String oddString(String[] words) {
        int n=words[0].length();
        int []target=new int[n-1];
        for(int i=0;i<n-1;i++){
            target[i]=words[0].charAt(i+1)-words[0].charAt(i);
        }
        for(int j=0;j<n-1;j++){
            if((words[1].charAt(j+1)-words[1].charAt(j))!=target[j]) {
                for(j=0;j<n-1;j++){
                    if((words[2].charAt(j+1)-words[2].charAt(j))!=target[j]) {
                        return words[0];
                    }
                }
                return words[1];
            }
        }
        for(int i=1;i<words.length;i++){
            for(int j=0;j<n-1;j++){
                if((words[i].charAt(j+1)-words[i].charAt(j))!=target[j]) return words[i];
            }
        }
        return null;
    }
    public boolean isUnique(String astr) {
        int a=0;
        for(int i=0;i<astr.length();i++){
            int temp=1<<(astr.charAt(i)-'a');
            if((a&temp)==0){
                a=a|temp;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public double[] sampleStats(int[] count) {
        double []ans=new double[5];
        int maxi=0;
        for(int i=0;i<count.length;i++){
            if(count[i]!=0){
                ans[0]=i;
            }
        }
        for(int i=count.length-1;i>0;i--){
            if(count[i]!=0){
                ans[0]=i;
            }
        }
        int all=0;
        for(int i=0;i<count.length;i++){
            if(count[i]!=0){
                all+=i;
                ans[2]+=(count[i]*i);
                maxi=count[i]>count[maxi]?i:maxi;
            }
        }
        ans[2]/=all;
        ans[4]=maxi;
        int cnt=0;
        int m1=all/2-1;
        int m2=all/2;
        int t=all/2;
        for(int i=0;i<count.length;i++){
            if (count[i]>0){
                cnt+=count[i];
                if (cnt > all / 2 - 1 && m1 == -1) m1 = i;
                if (cnt > all / 2 && m2 == -1) m2 = i;
            }
        }
        if(all%2==0){
            ans[3]=m2;
        }
        else{
            ans[3]=(m1+m2)/2;
        }
        return ans;
    }

    public static int kthSmallest(int[][] mat, int k) {
        int []help=new int[k];
        for(int i=0;i< Math.min(k,mat[0].length);i++){
            help[i]=mat[0][i];
            System.out.print(help[i]);
        }
        for(int i=0;i<k;i++){
            System.out.println(help[i]);
        }
        for(int i=1;i<mat.length;i++){
            PriorityQueue<Integer>q=new PriorityQueue<>();
            for(int j=0;j<k;j++){
                if(help[j]==0){
                    break;
                }
                int temp=help[j];
                for(int m=0;m<mat[0].length;m++){
                    q.add(temp+mat[i][m]);
                }
            }
            for(int j=0;j<k&&(!q.isEmpty());j++){
                help[j]=q.poll();
            }
        }
        return help[k-1];
    }
    public int averageValue(int[] nums) {
        int cnt=0,sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%6==0){
                sum+=nums[i];
                cnt++;
            }
        }
        return cnt==0?0:sum/cnt;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        int length=grid.length;
        int [][]dp=new int[length][length];
        for(int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        Queue<int []> q=new ArrayDeque<>();
        q.add(new int[]{0,0});
        dp[0][0]=1;
        while(!q.isEmpty()){
            int []temp=q.poll();
            int x=temp[0],y=temp[1];
            if(x==length-1&&y==length-1) return dp[x][y];
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if(x+i<0||x+i>=length||y+j<0||y+j>=length){
                        continue;
                    }
                    if(grid[x+i][y+j]==1||dp[x+i][y+j]!=Integer.MAX_VALUE){
                        continue;
                    }
                    dp[x+i][y+j]=dp[x][y]+1;
                    q.add(new int[]{x+i,y+j});
                }
            }
        }
        return -1;
    }
    public int shortestPathBinaryMatrix(int[][] grid,int x,int y) {
        int length=grid.length;
        if(grid[x][y]==1) return -1;
        grid[x][y]=1;
        int min=Integer.MAX_VALUE;
        if(y<length-1&&grid[x][y+1]==0) {
            int temp=shortestPathBinaryMatrix(grid,x,y+1);
            if(temp!=-1) min=Math.min(min,temp+1);
        }
        if(x<length-1&&grid[x+1][y]==0) {
            int temp=shortestPathBinaryMatrix(grid,x+1,y);
            if(temp!=-1) min=Math.min(min,temp+1);
        }
        if(y>0&&grid[x][y-1]==0) {
            int temp=shortestPathBinaryMatrix(grid,x,y-1);
            if(temp!=-1) min=Math.min(min,temp+1);
        }
        if(x>0&&grid[x-1][y]==0) {
            int temp=shortestPathBinaryMatrix(grid,x-1,y);
            if(temp!=-1) min=Math.min(min,temp+1);
        }
        if(x>0&&y<length-1&&grid[x-1][y+1]==0) {
            int temp=shortestPathBinaryMatrix(grid,x-1,y+1);
            if(temp!=-1) min=Math.min(min,temp+1);
        }
        if(y>0&&x<length-1&&grid[x+1][y-1]==0) {
            int temp=shortestPathBinaryMatrix(grid,x+1,y-1);
            if(temp!=-1) min=Math.min(min,temp+1);
        }
        if(y>0&&x>0&&grid[x-1][y-1]==0) {
            int temp=shortestPathBinaryMatrix(grid,x-1,y-1);
            if(temp!=-1) min=Math.min(min,temp+1);
        }
        if(y<length-1&&x<length-1&&grid[x+1][y+1]==0) {
            int temp=shortestPathBinaryMatrix(grid,x+1,y+1);
            if(temp!=-1) min=Math.min(min,temp+1);
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
    public class isRoot{
        TreeNode node;
        boolean flag;

        public isRoot(TreeNode node, boolean flag) {
            this.node = node;
            this.flag = flag;
        }
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set=new HashSet<>();
        List<TreeNode> ans=new LinkedList<>();
        for(int i=0;i<to_delete.length;i++){
            set.add(to_delete[i]);
        }
        Queue<isRoot> q=new ArrayDeque<>();
        q.add(new isRoot(root,true));
        while(!q.isEmpty()){
            isRoot cur=q.poll();
            if(set.contains(cur.node.val)){
                if(cur.node.left!=null) q.add(new isRoot(cur.node.left,true));
                if(cur.node.right!=null) q.add(new isRoot(cur.node.right,true));
            }
            else{
                if(cur.node.left!=null) q.add(new isRoot(cur.node.left,false));
                if(cur.node.right!=null) q.add(new isRoot(cur.node.right,false));
                if(cur.flag==true) ans.add(cur.node);
            }
            if(set.contains(cur.node.left.val)) cur.node.left=null;
            if(set.contains(cur.node.right.val)) cur.node.right=null;
        }
        return ans;
    }
    public class Ifo{
        int sum;
        int max;

        public Ifo(int sum, int ji) {
            this.sum = sum;
            this.max = max;
        }
        public Ifo(){}

    }
    public int mctFromLeafValuesBL(int[] arr) {
        return mctFromLeafValues(arr,0,arr.length-1).sum;
    }
    public Ifo mctFromLeafValues(int[] arr,int L,int R) {
        if(L==R){
            return new Ifo(0,arr[L]);
        }
            Ifo ans=new Ifo(Integer.MAX_VALUE,1);
        for(int i=L;i<R;i++){
            Ifo ifo=new Ifo();
            Ifo ifo1=mctFromLeafValues(arr,L,i);
            Ifo ifo2=mctFromLeafValues(arr,i+1,R);
            ifo.max=Math.max(ifo1.max,ifo2.max);
            ifo.sum=ifo1.sum+ifo2.sum+ifo1.max*ifo2.max;
            if(ifo.sum<ans.sum){
                ans.sum=ifo.sum;
            }
        }
        return ans;
    }
    public int mctFromLeafValues(int[] arr) {
        int n=arr.length;
        int [][]dp=new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i]=0;
        }
        int [][]max=new int[n][n];
        for(int j=0;j<n;j++){
            max[j][j]=arr[j];
            for(int i=j-1;i>=0;i--){
                max[i][j]=Math.max(max[i+1][j],arr[i]);
                for(int k=i;k<j;k++){
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+max[i][k]*max[k+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int L=0,R=price[price.length-1]-price[0];
        while(L<R){
            int mid=L+(R-L+1)>>1;
            if(check(price,k,mid)){
                L=mid;
            }
            else{
                R=mid-1;
            }
        }
        return L;

    }
    public boolean check(int []price,int k,int target){
        int cnt=0,pre=-target;
        for(int cur:price){
            if(cur-pre>target){
                cnt++;
                pre=cur;
            }
        }
        return cnt>=k;
    }
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        int cnt=0;
        boolean[]help=new boolean[201];
        while(i<j){
            int temp= nums[i]+nums[j];
            if(!help[temp]){
                cnt++;
                help[temp]=true;
            }
            i++;
            j--;
        }
        return cnt;
    }
    public int[] applyOperations(int[] nums) {
        int r=nums.length-1;
        for(int i=0;i<r;i++){
            if(nums[i]==nums[i+1]){
                nums[i]=2*nums[i];
                swap(nums,i+1,r--);
            }

        }
        return nums;
    }
    public static void swap1(int []arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
        public int equalPairs(int[][] grid) {
            int ans=0;
            HashMap<List<Integer>,Integer> map=new HashMap<>();
            for(int i=0;i<grid.length;i++){
                List<Integer> arr=new ArrayList<>();
                for(int j=0;j<grid.length;j++){
                    arr.add(grid[i][j]);
                }
                map.put(arr, map.getOrDefault(arr, 0) + 1);
            }
            for(int i=0;i<grid.length;i++){
                List<Integer> arr=new ArrayList<>();
                for(int j=0;j<grid.length;j++){
                    arr.add(grid[j][i]);
                }
                if(map.containsKey(arr)){
                    ans+=map.get(arr);
                }

            }
            return ans;
        }
    public class ifo{
        int value;
        int position;

        public ifo(int value, int position) {
            this.value = value;
            this.position = position;
        }
    }
    public class myCmp implements Comparator<ifo>{
        public int compare(ifo o1,ifo o2){
            return o2.value-o1.value;
        }
    }
    public int miceAndCheesemy(int[] reward1, int[] reward2, int k) {
        PriorityQueue<ifo> pq=new PriorityQueue<>(new myCmp());
        for(int i=0;i<reward1.length;i++){
            pq.add(new ifo(reward1[i]-reward2[i],i));
        }
        int ans=0;
        for(int i=0;i<k;i++){
            ans+=reward1[pq.poll().position];
        }
        for(int i=0;i<reward1.length-k;i++){
            ans+=reward2[pq.poll().position];
        }
        return ans;
    }
    public class myCmp2 implements Comparator<Integer>{
        public int compare(Integer o1,Integer o2){
            return o2-o1;
        }
    }
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(new myCmp2());
        int ans=0;
        for(int i=0;i<reward1.length;i++){
            ans+=reward2[i];
            pq.add(reward1[i]-reward2[i]);
        }
        for(int i=0;i<k;i++){
            ans+=pq.poll();
        }
        return ans;
    }
    public String mergeAlternately(String word1, String word2) {
        String ans="";
        int r=0;
        int i;
        for(i=0;i<word1.length()&&i<word2.length();i++){
            ans+=word1.charAt(i);
            ans+=word2.charAt(i);
        }
        for(i=i;i<word1.length();i++){
            ans+=word1.charAt(i);
        }
        for(i=i;i<word2.length();i++){
            ans+=word2.charAt(i);
        }
        return ans;
    }
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2==str2+str1)) return "";
        return str1.substring(0,gcd(str1.length(),str2.length()));
    }
    public int gcd(int a,int b) {
        return b==0?a:gcd(b,a%b);
    }
    int ans=0;
    public int tilingRectangle(int n, int m) {
        ans=m*n;
        boolean[][]curStatus=new boolean[n][m];
        process(curStatus,0);
        return ans;
    }
    public void process(boolean [][]curStatus,int cnt){
        if(cnt>=ans) return;
        int[]cur=search(curStatus);
        if(cur[0]==-1) {
            ans=Math.min(ans,cnt);
            return;
        }
        for(int len=Math.min(curStatus.length-cur[0],curStatus[0].length-cur[1]);len>=1;len--){
            if(canOrNot(curStatus,cur[0],cur[1],len,true)){
                process(curStatus,cnt+1);
                canOrNot(curStatus,cur[0],cur[1],len,false);
            }
        }
    }
    public boolean canOrNot(boolean[][]curstatus,int i,int j,int len,boolean flag){
        if(flag) {
            for(int k=0;k<len;k++){
                for(int m=0;m<len;m++){
                    if(curstatus[i+k][j+m]){
                        return false;
                    }
                }
            }
        }
        for(int k=0;k<len;k++){
            for(int m=0;m<len;m++){
                curstatus[i+k][j+m]=flag;
            }
        }
        return true;
    }
    public int[] search(boolean [][]curStatus){
        for(int i=0;i<curStatus.length;i++){
            for(int j=0;j<curStatus[0].length;j++){
                if(!curStatus[i][j]) return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        int ans[][]=null;
        PriorityQueue<Edge> pq=ppee();

        return ans;
    }
    public PriorityQueue<Edge> ppee(){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        return pq;
    }
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int []help=new int [11];
        for(int i=0;i<words.length;i++){
            help[f(words[i])]++;
        }
        int sum=0;
        for(int i=10;i>=0;i--){
            int temp=help[i];
            help[i]=sum;
            sum+=temp;
        }
        int []ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i]=help[f(queries[i])];
        }
        return ans;
    }
    public int f(String str){
        int ans=0;
        char pre='z';
        for(int i=0;i<str.length();i++){
            char cur=str.charAt(i);
            if(cur<pre){
                ans=1;
                pre=str.charAt(i);
            }
            else if(cur==pre){
                ans++;
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

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode pre=null;
        int sum=0;
        ListNode cur=head;
        while(cur!=null){
            sum+=cur.val;
            if(sum==0){
                head=cur.next;
                cur=head;
                continue;
            }
            cur=cur.next;
        }
        pre=head;
        while(pre!=null){
            cur=pre.next;
            sum=0;
            while(cur!=null) {
                sum+=cur.val;
                if (sum == 0) {
                    pre.next=cur.next;
                    cur = cur.next;
                    continue;
                }
                cur = cur.next;
            }
            pre=pre.next;
        }
        return head;
    }

}


