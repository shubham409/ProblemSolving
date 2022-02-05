package Solutions;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.IntStream;

class Main {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b  = sc.nextInt();
//
//        int max = Math.max(a,b);
//        int min = Math.min(a,b);
//
//        int ans = giveAns(max,min);
//        System.out.println(ans);
//        int[] ar = {5, 25, 75};
//        int target = 100;
//        Solution solution = new Solution();
        ArrayList<Integer> size = new ArrayList<>();
        Vector<Integer> sizev = new Vector<>();
        System.out.println(size.size());
        System.out.println(sizev.size());

    }


    private static int giveAns(int max, int min) {
    return 0;
    }

}
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {

        // using collections' sort to sort in nlog(n) time
        ArrayList<Integer>ar = toNonPrimitive(nums);
        Collections.sort(ar);
        nums = toPrimitive(ar);

        // iterating till third last element
        for (int i = 0; i <= nums.length-3; i++) {
            // if size of answer list so far is non-zero
            if(ans.size()!=0){
                // since list are stored in this manner -> [ [first_0, second_0 , third_0] ,[first_1, second_2, third_3 ] ] so we are using size -1 to get last inserted element and get(0) to get first element from that for checking repetition
                int previousFirstValue = ans.get(ans.size()-1).get(0);
                // checking if previous element is not equal to current element then only we can take current element
                if (nums[i]!= previousFirstValue){
                    int currentFirstValue = nums[i];
                    twoPointer(nums, (-nums[i]),i+1, nums.length-1,currentFirstValue);
                }
            }
            // if size of answer list is 0, so we can take current element without thinking about repetition
            else {
                int currentFirstValue = nums[i];
                twoPointer(nums, (-nums[i]),i+1, nums.length-1,currentFirstValue);
            }
        }
        return ans;
    }
    public void twoPointer(int[] num, int target, int startIndex, int endIndex,int currentFirstValue){
        int left = startIndex;
        int right = endIndex;
        // running two pointer which gives target in time complexity of O(n) which is less than using a loop and binary search's O(nlog(n))
        while(left<right && num[left] + num[right] != target && left<=endIndex && right>= startIndex){
            if (num[left]+num[right]> target){
                right--;
            }
            else {
                left++;
            }
        }
        boolean ansFound = true;
        if(left>endIndex || right <startIndex || num[left] + num[right] != target || left==right){
            ansFound = false;
        }
        if(ansFound){
            int currentSecondValue = num[left];
            int currentThirdValue = num[right];
            // again two condition if current answer array size is non-zero so we have to check for repetition. Else we can add directly
            if(ans.size()!=0){
                if(num[left]!=ans.get(ans.size()-1).get(1)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(currentFirstValue);
                    temp.add(currentSecondValue);
                    temp.add(currentThirdValue);
                    ans.add(temp);
                }
                else if (num[right]!=ans.get(ans.size()-1).get(2)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(currentFirstValue);
                    temp.add(currentSecondValue);
                    temp.add(currentThirdValue);
                    ans.add(temp);
                }
            }
            // adding directly to the answer list because answer list is empty so no chances of repetition
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(currentFirstValue);
                temp.add(currentSecondValue);
                temp.add(currentThirdValue);
                ans.add(temp);
            }
        }
    }
    public void twoSum(int[] num, int target, int startIndex, int endIndex,int currentFirstValue) {
        // iterating till second last element
        for (int left = startIndex; left < endIndex; left++) {
            // iterating till last element
            int right  = binarysearch(num,left+1, endIndex, target-num[left]);
            //when we have element present with target value so we can now take this element after checking about repetition of second and third element
            if (right !=-1){
                int currentSecondValue = num[left];
                int currentThirdValue = num[right];
                // again two condition if current answer array size is non-zero so we have to check for repetition. Else we can add directly
                if(ans.size()!=0){
                        if(num[left]!=ans.get(ans.size()-1).get(1)){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(currentFirstValue);
                            temp.add(currentSecondValue);
                            temp.add(currentThirdValue);
                            ans.add(temp);
                        }
                        else if (num[right]!=ans.get(ans.size()-1).get(2)){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(currentFirstValue);
                            temp.add(currentSecondValue);
                            temp.add(currentThirdValue);
                            ans.add(temp);
                        }
                }
                // adding directly to the answer list because answer list is empty so no chances of repetition
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(currentFirstValue);
                    temp.add(currentSecondValue);
                    temp.add(currentThirdValue);
                    ans.add(temp);
                }
            }
        }
    }
    //here is binary search function to find last element . Here left and right indexes are inclusive(0 to n-1).
    private int binarysearch(int[] num, int left, int right, int target) {
        int mid =-1;
        while(left<=right){
            int temp = (left+right)/2;
            if(num[temp] ==target){
                mid = temp;
                break;
            }
            else if(num[temp] >target){
                right= --temp;
            }
            else{
                left = ++temp;
            }
        }
        return mid;
    }

    // extra work to convert
    public ArrayList<Integer> toNonPrimitive(int [] ar){
        ArrayList<Integer> ans = new ArrayList<>(ar.length);
        for (int i = 0; i < ar.length; i++) {
            ans.add(ar[i]);
        }
        return ans;
    }
    // extra work to convert
    public int [] toPrimitive(ArrayList<Integer>  ar){
        int [] ans = new int[ar.size()];
        for (int i = 0; i < ar.size(); i++) {
            ans[i] = ar.get(i);
        }
        return ans;
    }

}
class Kadane {
    int maxSubarraySum(int arr[], int size)
    {
        int max_ending_here = 0, max_so_far = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {

            if (arr[i] <= max_ending_here + arr[i]) {
                max_ending_here += arr[i];
            }

            else {
                max_ending_here = arr[i];
            }
            if (max_ending_here > max_so_far)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }
}
