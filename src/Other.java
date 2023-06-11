import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 学习JAVA
 *
 * @项目名称：
 * @子庚木上
 * @Date：2023/5/21 - 05 - 21 - 23:52
 * @version： 1.0
 * @功能：
 */
public class Other {
    public static void main(String[] args) {
        int a=1;
        System.out.println((1<<2)&4);
    }
    public int reverseBits(int n) {
         int ans=0;
         for(int i=0;i<32;i++){
             ans<<=1;
             ans|=n&1;
             n>>=1;
         }
         return ans;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> tem=new ArrayList<>();
        tem.add(1);
        ans.add(tem);
        for(int i=1;i<numRows;i++){
            List<Integer> temp=new LinkedList<>();
            temp.add(1);
            for(int j=1;j<i;j++){
                temp.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
            }
            temp.add(1);
            ans.add(temp);
        }
        return ans;
    }
    public boolean isValid(String s) {
        Stack<Character> ff=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{') ff.push(s.charAt(i));
            else{
                if(ff.isEmpty()) return false;
                else{
                    if(s.charAt(i)==')'&&(ff.pop()!='(')) return false;
                    if(s.charAt(i)==']'&&(ff.pop()!='[')) return false;
                    if(s.charAt(i)=='}'&&(ff.pop()!='{')) return false;
                }
            }
        }
        if(!ff.isEmpty()) return  false;
        return true;
    }
    public int missingNumber(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return (nums.length+nums.length+1)/2-sum;
    }
}
