package algorithms.sorting

fun main() {
    val numbers = intArrayOf(2, 5, 9, 14, 89, 112, 2003)
    // iterative impl answer
    print(bs(numbers, 2003))

    //recursive impl answer
    print(bs(numbers, 112))
}

// Iterative implementation of binary search
private fun bs(nums: IntArray, x: Int): Int {
    var l = 0
    var r = nums.size - 1
    while (l <= r) {
        val mid = l + (r - l) / 2
        when {
            nums[mid] > x -> r = mid - 1
            nums[mid] < x -> l = mid + 1
            else -> return mid
        }
    }
    return -1
}

// recursive implementation of binary search
private fun bs(nums: Array<Int>, l: Int, r: Int, x: Int):Int {
    if (r>=l){
        val midIndex = l + (r - l) / 2
        if (nums[midIndex] == x)return midIndex
        if (nums[midIndex]>x) return bs(nums, l, midIndex - 1, x)
        if (nums[midIndex]<x)return bs(nums, l + 1, r, x)
    }
    return -1
}

