
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
    int start=0,mid=0,end=nums.length-1;
    while(start<end){
        mid=(end+start)/2;
        if(nums[mid]>nums[end]) start=mid+1;
        else if(nums[mid]==nums[end]) end--;
        else end=mid;
    }
    return nums[start];
    }
}
