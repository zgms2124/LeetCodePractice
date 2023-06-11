import com.sun.org.apache.xml.internal.security.Init;

import java.util.ArrayList;
import java.util.List;

/**
 * 学习JAVA
 *
 * @项目名称：
 * @计通2204李志杨
 * @Date：2023/6/11 - 06 - 11 - 18:27
 * @version： 1.0
 * @功能：
 */
public class LeetCode75 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max= -1;
        for(int i=0;i<candies.length;i++){
            if(candies[i]>max){
                max=candies[i];
            }
        }
        List<Boolean>ans=new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max){
                ans.add(true);
            }
            else {
                ans.add(false);
            }
        }
        return ans;

    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int []help=new int[flowerbed.length+2];
        for(int i=1;i<flowerbed.length;i++){
            help[i]=flowerbed[i];
        }
        for(int i=1;i<help.length&&n>0;i++){
            if(help[i]==0&&help[i-1]==0&&help[i+1]==0){
                n--;
                flowerbed[i]=1;
            }
        }
        return n==0;
    }
    boolean []all=new boolean['z'+1];
    public void init(){
        all['a']=true;
        all['a']=true;
        all['e']=true;
        all['i']=true;
        all['o']=true;
        all['u']=true;
        all['A']=true;
        all['E']=true;
        all['I']=true;
        all['O']=true;
        all['U']=true;
    }
    public String reverseVowels(String s) {
        init();
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !isVowel(arr[i])) {
                ++i;
            }
            while (j > 0 && !isVowel(arr[j])) {
                --j;
            }
            if (i < j) {
                swap(arr, i, j);
                ++i;
                --j;
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char ch) {
        return all[ch];
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[]test=new int[]{1,0,0,0,1,0,0};
        System.out.println(canPlaceFlowers(test,2));
    }
}
