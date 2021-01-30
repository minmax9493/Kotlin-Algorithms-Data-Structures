package dataStructure.queue

class ResizingArrayQueueOfStrings {

    private var arrayOfString = arrayOfNulls<String>(1)
    private var n = 0

    fun enqueue(value: String) {
        if (n == arrayOfString.size - 1) resize(n * 2)
        arrayOfString[n++] = value
    }

    fun dequeue(): String? {
        if (n==0)return null
        val item = arrayOfString[0]
        n--
        if (n>0 && n== arrayOfString.size/4)resize(n/2)
        shiftToLeft()
        return item
    }

    private fun shiftToLeft(){
        arrayOfString.forEachIndexed { index, s ->
            if (index in 0 until n){
                arrayOfString[index] = arrayOfString[index+1]
            }
        }
    }

    private fun resize(capacity: Int) {
        val newArrayOfString = arrayOfNulls<String>(capacity)
        arrayOfString.forEachIndexed{i, v->
            newArrayOfString[i] = v
        }
        arrayOfString = newArrayOfString
    }
}

fun main(){
    val enqueue = ResizingArrayQueueOfStrings()
    enqueue.enqueue("Samsung")
    enqueue.enqueue("Nokia")
    print(enqueue.dequeue())
}