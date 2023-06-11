/**
 * 学习JAVA
 *
 * @项目名称：
 * @计通2204李志杨
 * @Date：2023/5/15 - 05 - 15 - 20:06
 * @version： 1.0
 * @功能：
 */
public class SortAndSearch {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int []help=new int[m+n];
        int i=0,j=0,r=0;
        while(i<m&&j<n){
            help[r++]=nums1[i]<=nums2[j]?nums1[i++]:nums2[j++];
        }
        while(i<m){
            help[r++]=nums1[i++];
        }
        while(j<n){
            help[r++]=nums2[j++];
        }
        for(i=0;i<m+n;i++){
            nums1[i]=help[i];
        }
    }
    public int firstBadVersion(int n) {
        int L = 1, R = n;
        while (L < R) {
            if (!isBadVersion(L + ((R - L) >> 1))) {
                L = L + ((R - L) >> 1) + 1;
            } else {
                R = L + ((R - L) >> 1);
            }
        }
        return L;
    }
    public boolean isBadVersion(int i){
        return true;
    }

}
