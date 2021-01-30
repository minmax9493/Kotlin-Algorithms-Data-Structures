package algorithms.sorting

class BubbleSortingExample {

    // Buble algorithms.sorting.sort
    // Time complexity O(n^2), it is always n^2 even if the array is sorted
    fun sort(nums: IntArray): IntArray {
        for (i in 0 until nums.size - 1) {
            for (j in 0 until nums.size - 1 - i) {
                if (nums[j] > nums[j + 1]) {
                    // swap nums[j+1] and nums[j]
                    val tmp = nums[j]
                    nums[j] = nums[j + 1]
                    nums[j + 1] = tmp
                }
            }
        }
        return nums
    }

    // Bubble algorithms.sorting.sort, optimized version
    // time complexity: worst and average case O(n^n), worst case occurs when array is reversed sorted
    // best time complexity: O(n), best case occurs when array is already sorted
    // auxiliary space: O(1)
    fun sort2(nums:IntArray):IntArray{
        for(i in 0 until nums.size-1){
            var swapped = false
            for (j in 0 until nums.size-1-i){
                if (nums[j]>nums[j+1]){
                    val tmp = nums[j]
                    nums[j] = nums[j+1]
                    nums[j+1] = tmp
                    swapped = true
                }
            }
            if (!swapped){
                return nums
            }
        }
        return nums
    }
}

fun main() {
    val nums = intArrayOf(10, -90, 290, 23, -9, 87)
    val bubble = BubbleSortingExample()
    val sortedArray = bubble.sort2(nums)
    sortedArray.forEach { print("$it ") }
}