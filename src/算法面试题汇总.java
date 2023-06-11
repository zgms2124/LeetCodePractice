/**
 * 学习JAVA
 *
 * @项目名称：
 * @计通2204李志杨
 * @Date：2023/5/28 - 05 - 28 - 23:21
 * @version： 1.0
 * @功能：
 */
public class 算法面试题汇总 {
    public int majorityElement(int[] nums) {
        int num=0,cnt=0;
        for(int i=0;i<nums.length;i++){
            if(cnt==0){
                num=nums[i];
            }
            else{
                cnt--;
            }
        }
        return num;
    }
}
