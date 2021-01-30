package dataStructure.stack

/**
 * Cost of inserting N+(2+4+8+..+N) ~ 3N
 *
 *              best  worst   amortized
 * construct      1     1         1
 * push           1     N         1
 * pop            1     N         1
 * size           1     1         1
 *
 * N-Doubling and halving operations
 *
 * USes between ~8N and 32 N bytes to represent a stack with N items
 *
 * ~8N when full
 * ~32N when one-quarter full.
 *
 *
 * Stack implementation: resizing array and linked list
 *
 * Liked-list impl:
 * Every operation takes constant time in the worst case
 * USes extra time and space to deal with the links
 *
 * Resizing array:
 *
 * Every operation takes constant amortized time.
 * Less wasted space
 */
class ResizingArrayStackOfStrings{
    private var s= arrayOfNulls<String>(1)
    private var n:Int = 0

    fun push(v:String){
        if (n == s.size)resize(2*n)
        s[n++] = v
    }

    /**
     * Halve size of array s[] when array is one quarter full
     */
    fun pop():String?{
        val item = s[--n]
        s[n] = null
        if (n>0 && n == s.size/4)resize(s.size/2)
        return item
    }

    /**
     * Create a new array of twice the size and copy items
     */
    private fun resize(capacity:Int) {
        val newArray = arrayOfNulls<String>(capacity)
        s.forEachIndexed { index, s -> newArray[index] = s }
        s = newArray
    }
}

fun main(){
    val array = ResizingArrayStackOfStrings()
    array.push("10")
    array.push("11")
    array.push("12")
    print(array.pop())
}