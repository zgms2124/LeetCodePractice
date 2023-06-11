import java.util.List;

/**
 * 学习JAVA
 *
 * @项目名称：
 * @子庚木上
 * @Date：2023/5/10 - 05 - 10 - 15:10
 * @version： 1.0
 * @功能：
 */
public class StringPractice {
    public static void main(String[] args){
        System.out.println(firstUniqChar("a"));
    }
    public void reverseString(char[] s) {
        for(int i=0;i<s.length/2;i++){
            char temp=s[i];
            s[i]=s[s.length-i-1];
            s[s.length-i-1]=temp;
        }
    }
    public int reverse(int x) {
        int temp=0;
        while(x>0){
            temp=temp*10+x%10;
            if(temp%10!=x%10){
                return 0;
            }
            x/=10;
        }
        return temp;
    }
    public static int firstUniqChar(String s) {
        int temp1=0;
        int temp2=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if((temp1&1<<c-'a')==0){
                temp1=temp1|(1<<c-'a');
            }
            else{
                temp2=temp2|(1<<c-'a');
            }
        }
        temp1=temp1^temp2;
        System.out.println(temp1+" "+temp2);
        if(temp1==0)
            return -1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if((temp1&(1<<c-'a'))!=0) return i;
        }
        return -1;
//        temp1=temp1&(~temp1+1);
//        return ans[(int)(Math.log(temp1)/ Math.log(2))];

//        for(int i=0;i<26;i++){
//            if((temp1&1<<i)!=0) return ans[i];
//        }
//        return -1;

    }
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int []temp=new int [26];
        for(int i=0;i<s.length();i++){
            temp[s.charAt(i)]++;
            temp[t.charAt(i)]--;
        }
        for(int i=0;i<26;i++){
            if(temp[i]!=0) return false;
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        int a=0;
        int i=0,j=s.length()-1;
        while(i<=j){
            while(i<=j&&!((s.charAt(i)<='9'&&s.charAt(i)>='0')
                    ||(s.charAt(i)<='z'&&s.charAt(i)>='a')
                    ||(s.charAt(i)>='A'&&s.charAt(i)<='Z'))){
                    i++;
            }
            while(i<=j&&!((s.charAt(j)<='9'&&s.charAt(j)>='0')
                    ||(s.charAt(j)<='z'&&s.charAt(j)>='a')
                    ||(s.charAt(j)>='A'&&s.charAt(j)<='Z'))){
                j--;
            }
            int c1=s.charAt(i),c2=s.charAt(j);
            if(c1>='A'&&c1<='Z'){
                c1=c1-'A'+'a';
            }
            if(c2>='A'&&c2<='Z'){
                c2=c2-'A'+'a';
            }
            if(c1!=c2) return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
    public int myAtoi(String s) {
        long ans=0;
        int i;
        for(i=0;i<s.length();i++){
            if(s.charAt(i)!=' ') break;
        }
        boolean flag=true;
        if(i<s.length()){
            if(s.charAt(i)=='-'||s.charAt(i)=='+'){
                if(s.charAt(i)=='-') flag=false;
                i++;
            }
        }
        if(flag){
            for(i=i;i<s.length()&&s.charAt(i)<='9'&&s.charAt(i)>='0';i++) {
                ans = ans * 10 + s.charAt(i) - '0';
                if (ans >Integer.MAX_VALUE ) {
                    ans = Integer.MAX_VALUE;
                    break;
                }
            }
        }
        else {
            for (i = i; i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0'; i++) {
                ans = ans * 10 - (s.charAt(i) - '0');
                if (ans <Integer.MIN_VALUE) {
                    ans = Integer.MIN_VALUE;
                    break;
                }
            }

        }
        return (int)ans;
        //"-9128347123"
    }
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        if(needle.length()==1){
            for(int i=0;i<haystack.length();i++){
                if(haystack.charAt(i)==needle.charAt(0)){
                    return i;
                }
            }
            return -1;
        }
        int []next=new int[needle.length()];
        next[0]=-1;
        next[1]=0;
        int i=2,j=0;
        while(i<needle.length()){
            if(needle.charAt(j)==needle.charAt(i-1)){
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
        while(i<haystack.length()&&j<needle.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
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
        if(j==needle.length()) return i-j;
        return -1;
    }
    public String countAndSay(int n) {
        StringBuilder ans=new StringBuilder("1");
        for(int i=1;i<n;i++){
            String temp=ans.toString();
            ans=new StringBuilder();
            int count=1;
            char c=temp.charAt(0);
            for(int j=1;j<temp.length();j++){
                if(temp.charAt(j)!=c){
                    ans.append(count).append(c);
                    c=temp.charAt(j);
                    count=1;

                }
                else{
                    count++;
                }
            }
            ans.append(count).append(c);
        }
        return ans.toString();
    }
    public String countAndSaydg(int n) {
        if (n==1) return "1";
        String temp=countAndSaydg(n-1);
        StringBuilder ans=new StringBuilder();
        int count=1;
        char c=temp.charAt(0);
        for(int j=1;j<temp.length();j++){
            if(temp.charAt(j)!=c){
                ans.append(count).append(c);
                c=temp.charAt(j);
                count=1;

            }
            else{
                count++;
            }
        }
        ans.append(count).append(c);
        return ans.toString();

    }
    public String longestCommonPrefix(String[] strs) {
        String ans=new String(strs[0]);
        for(int i=1;i<strs.length&&ans.length()>0;i++){
            StringBuilder temp=new StringBuilder("");
            for(int j=0;j<strs[i].length()&&j<ans.length();j++){
                if(ans.charAt(j)==strs[i].charAt(j)){
                    temp.append(ans.charAt(j));
                }
                else {
                    break;
                }
            }
            ans=temp.toString();
        }
        return ans;
    }
      public class ListNode {
               int val;
      ListNode next;
      ListNode() {

      }
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     }
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode quick=head;
        ListNode slow=head;
        for(int i=0;i<n;i++){
            quick=quick.next;
        }
        while(quick!=null&&quick.next!=null){
            slow=slow.next;
            quick=quick.next;
        }
        if(quick==null){
            head=head.next;
            return head;
        }
        slow.next=slow.next.next;
        return head;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre=null,cur=head;
        while(cur.next!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        cur.next=pre;
        return cur;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode p1=list1;
        if(list1.val>list2.val){
            ListNode tt=list2;
            while(list2.next!=null&&list1.val>=list2.next.val){
                list2=list2.next;
            }
            list1=tt;
            tt=list2.next;
            list2.next=p1;
            list2=tt;}
        while(p1!=null&&list2!=null){
            while(p1.next!=null&&p1.next.val<=list2.val){
                p1=p1.next;
            }
            ListNode temp=list2.next;
            list2.next=p1.next;
            p1.next=list2;
            list2=temp;
            p1=p1.next;
        }
        return list1;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode quick=head.next,slow=head.next;
        ListNode pre=null,cur=null;
        while(quick.next!=null&&quick.next.next!=null){
            quick=quick.next.next;
            slow=slow.next;
        }
        while(slow!=null){
            cur=slow.next;
            slow.next=pre;
            pre=slow;
            slow=cur;
        }
        boolean flag=true;
        quick=head;
        slow=pre;
        while(slow!=null&&slow!=quick){
            if(slow.val!=quick.val) flag=false;
            cur=slow.next;
            slow.next=pre;
            pre=slow;
            slow=cur;
            quick=quick.next;
        }
        return flag;
    }
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode s=head.next,f=head.next.next;
        while(f!=null){
            if(f==s) return true;
            s=s.next;
            f=f.next.next;
        }
        return false;
    }
}

