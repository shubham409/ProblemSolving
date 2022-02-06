package SolvedProblems;

class Kadane {
    int maxSubarraySum(int arr[], int size) {
        int max_ending_here = 0, max_so_far = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {

            if (arr[i] <= max_ending_here + arr[i]) {
                max_ending_here += arr[i];
            } else {
                max_ending_here = arr[i];
            }
            if (max_ending_here > max_so_far)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }
}

