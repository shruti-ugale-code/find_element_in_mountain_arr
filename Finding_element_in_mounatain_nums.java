public class Finding_element_in_mounatain_nums {
    public static void main(String[] args) {
        int nums[]={1,3,5,7,6,4,2};
        int target=5;
        int ans=searchele(nums,target);
        System.out.println(ans);


    }

   public static int searchele(int nums[],int target){
        int peek=peekelement(nums);
        int firsttry=findEle(nums,target,0,peek);
        if(firsttry!=-1){
            return firsttry;
        }


        return findtarget(nums,target,peek+1,nums.length-1);
    }
    //firdt to find peak element and then search for two diff halves
    public static int peekelement(int nums[]){
        int start=0;
        int end=nums.length-1;



        while(start<end){

            int mid=start+(end-start)/2;

            if(nums[mid]>nums[mid+1]){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return start;

    }
    public static int findEle(int nums[], int target ,int start,int end) {


        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
    public static int findtarget(int nums[], int target,int start,int end) {

        boolean assnums = nums[start] < nums[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (assnums) {  //assending order
                if (target < nums[mid]) {
                    start = mid - 1;
                } else {
                    end = mid + 1;
                }
            } else {  // Descending order
                if (target > nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }


}
