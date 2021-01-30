package dataStructure.stack

/**
 * Stack: Array implementation
 *
 * Considerations:
 *
 * Overflow and underflow
 *
 * Underflow: throw exception if pop from an empty stack.
 * Overflow: use resizing array for array implementation
 *
 * Null items. We allow null items to be inserted
 *
 * Loitering. Holding a reference to an object when it is no longer needed
 *
 */
class FixedCapacityStackOfStrings(private val capacity:Int) {

    private var s = arrayOfNulls<String>(capacity)
    private var n:Int = 0

    fun isEmpty():Boolean{
        return n == 0
    }

    fun push(item:String){
        s[n++]=item// use to index into array, then increment n
    }

//    fun pop():String?{// first version, loitering
//        return s[--n]// decrement N; then use to index into array
//    }

    /**
     * This version avoids "loitering":
     * garbagee collector can reclaim memory only if no outstanding references
     */
    fun pop():String?{
        val item = s[--n]
        s[n] = null
        return item// decrement N; then use to index into array
    }
}

fun main(){
    val stack = FixedCapacityStackOfStrings(10)

    stack.push("Samsung")
    stack.push("Huawei")
    stack.push("Nokia")

    print(stack.pop())
    print(stack.pop())
    print(stack.pop())
}