package algorithms.sorting

fun main() {
    val sorting = InsertionSortingExample()
    val nums = intArrayOf(23, -90, 89, -78, 123)
    sorting.sort(nums).forEach { print("$it ") }
}

class InsertionSortingExample {

    // Insertion sort
    // Time Complexity: O(n^2)
    // Auxiliary Space: O(1)
    // Sorting in-place: true
    // stable: true
    fun sort(nums: IntArray): IntArray {
        for (i in 1 until nums.size) {
            val key = nums[i]
            var j = i - 1
            while (j>=0 && nums[j]>key){
                nums[j+1] = nums[j]
                j -= 1
            }
            nums[j+1] = key
        }
        return nums
    }
}