package dataStructure.queue

/**
 * Queue: Linked-list implementation
 *
 * linear time for enqueue
 * constant time for dequeue
 */
class LinkedQueueOfStrings{

    private var first:Node?=null
    private var last:Node?=null
    private data class Node(var item:String, var next:Node?=null)

    fun enqueue(item:String){
        val oldNode = last
        last = Node(item)
        if (isEmpty()) first = last
        else oldNode?.next = last
    }

    fun dequeue():String?{
        val item = first?.item
        first = first?.next
        if (isEmpty()) last = null
        return item
    }

    fun isEmpty():Boolean{
        return first == null
    }
}

fun main(){
    val queue = LinkedQueueOfStrings()

    queue.enqueue("First")
    queue.enqueue("Second")

    print(queue.dequeue())
    print(queue.dequeue())
}