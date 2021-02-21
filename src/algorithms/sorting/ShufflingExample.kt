package algorithms.sorting

import kotlin.random.Random

fun main(){
    val nums = intArrayOf(1,2,3,4,5,6,7,8,9)
    shuffle(nums).forEach { println(it) }
}

/**
 * In iteration i, pick integer r between 0 and i uniformly at random. Swap a[i] and a[r].
 */
fun shuffle(nums:IntArray):IntArray{
    nums.forEachIndexed{i, v->
        val r = Random.nextInt(0, i+1)
        val tmp = nums[i]
        nums[i] = nums[r]
        nums[r] = tmp
    }
    return nums
}