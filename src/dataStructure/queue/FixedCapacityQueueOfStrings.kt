package dataStructure.queue

/**
 * Avoid casting in client
 * Discover type dismatch errors at compile time instead of run time
 */
class FixedCapacityQueueOfStrings(private val capacity:Int) {
    private var arrayOfStrings = arrayOfNulls<String>(capacity)
    private var n=0

    fun enqueue(value:String){
        arrayOfStrings[n++] = value
    }

    fun dequeue():String?{
        if (n==0)return null
        val item = arrayOfStrings[0]
        --n
        shiftToLeft()
        return item
    }

    private fun shiftToLeft(){
        arrayOfStrings.forEachIndexed {i, v->
            if (i in 0 until n-1) {
                arrayOfStrings[i] = arrayOfStrings[i+1]
            }
        }
    }
}

fun main(){
    val enqueue = FixedCapacityQueueOfStrings(10)
    enqueue.enqueue("Samsung")
    enqueue.enqueue("Nokia")
    print(enqueue.dequeue())
    print(enqueue.dequeue())
    print(enqueue.dequeue())
    enqueue.enqueue("Nokia")
    print(enqueue.dequeue())
    print(enqueue.dequeue())
}