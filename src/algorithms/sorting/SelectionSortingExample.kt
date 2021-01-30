package algorithms.sorting

fun main(){
    val nums = intArrayOf(10, -90, 290, 23, -9, 87)
    val sortedArray = sort(nums)
    sortedArray.forEach { print("$it ") }
}

// selection algorithms.sorting(ascending order)
// Time complexity O(n^2)
// Auxiliary space O(1)
fun sort(nums:IntArray):IntArray{
    nums.forEachIndexed { index, i ->
        var minIndex = index
        for (j in index+1 until nums.size){
            if (nums[minIndex]>nums[j])minIndex = j
        }
        val tmp = nums[index]
        nums[index] = nums[minIndex]
        nums[minIndex] = tmp
    }
    return nums
}