package dataStructure.arrays

import kotlin.math.max

fun main() {

    val nums1 = intArrayOf(0)
    val nums2 = intArrayOf(1)

    merge(nums1,1,nums2,1)
}

// duplicate zeros
fun duplicateZeros(nums: IntArray): IntArray {
    var i = 0
    var replaced = false
    var tmp = 0
    while (i < nums.size) {
        if (i < nums.size - 1) {
            if (nums[i] == 0) {
                tmp = nums[i + 1]
                nums[i + 1] = 0
                replaced = true
                i++
            } else {
                if (replaced) nums[i] = tmp
                replaced = false
            }
        } else {
            if (replaced) nums[i] = tmp
        }
        i++
    }
    return nums
}


// merge sorted array
// assume that num1.size = m+n
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var first = m - 1
    var second = n - 1

    for (i in m + n - 1 downTo 0) {
        if (second < 0) break

        if (nums1[first] > nums2[second]) {
            nums1[i] = nums1[first]
            first--
        } else {
            nums1[i] = nums2[second]
            second--
        }
    }
    nums1.forEach {
        print(" ${it}")
    }

}

// find the max number of consecutive 1s in this array
fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var max = 0
    var ones = 0
    nums.forEach {
        if (it == 1) {
            ones++
        } else {
            if (ones > max) max = ones
            if (max > nums.size) return max
            ones = 0
        }
    }
    return kotlin.math.max(ones, max)
}

// find numbers with even number of digits
fun findNumbers(nums: IntArray): Int {
    var evenNumOfDigit = 0
    nums.forEach {
        var numOfDigit = 0
        var num = it
        while (num > 0) {
            num /= 10
            numOfDigit++
        }
        println("digit: $numOfDigit")
        if (numOfDigit % 2 == 0) evenNumOfDigit++
    }

    return evenNumOfDigit
}

// squares of sorted array
fun sortedSquares(nums: IntArray): IntArray {
    for (i in nums.indices) {

    }
    nums.forEachIndexed { i, v ->
        nums[i] = v * v
    }
    nums.sort()
    return nums
}

