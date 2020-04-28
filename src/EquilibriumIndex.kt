/**
 * Equilibrium index of an array is an index such that the sum
 * of elements at lower indexes is equal to the sum of elements at higher indexes.
 *
 * Input: A[] = {-7, 1, 5, 2, -4, 3, 0}
 * Output: 3
 * 3 is an equilibrium index, because:
 * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
 * Input: A[] = {1, 2, 3}
 * Output: -1
 * Source:
 * https://www.geeksforgeeks.org/equilibrium-index-of-an-array/?ref=lbp
 */

fun main(){
    print("hello")

    val x:IntArray = intArrayOf(-7, 1, 5, 2, -4, 3, 0)
    val size = x.size

    println("Index of array: ${solution1(x, size)}")
}

fun solution1(arrays:IntArray, size:Int):Int{
    var leftSum = 0
    var sum =0

    for(i in 0 until size){
        sum += arrays[i]
    }

    for (i in 0 until size){
        sum -= arrays[i]

        if(sum == leftSum)return i
        leftSum += arrays[i]
    }
    return -1
}


