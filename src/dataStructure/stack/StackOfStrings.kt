package dataStructure.stack

/**
 * Stack: LinkedList implementation in kotlin
 *
 * Performance:
 * Proposition: Every operation takes constant time in the worst case
 *
 * A stack with N items uses ~40N bytes
 *
 * 16 bytes(object overhead)
 * 8 bytes (inner class extra overhead)
 * 8 bytes (reference to String)
 * 8 bytes (reference to Node)
 *
 * Total 40 bytes per stack node
 *
 * USes extra time and space to deal with the links
 * **/
class StackOfStrings {

    private var first:Node?=null
    private data class Node(val item:String, var next:Node?)// private inner class

    fun isEmpty():Boolean{
        return first == null
    }

    fun push(item:String){
        val oldFirst = first
        first = Node(item, oldFirst)
        first?.next = oldFirst
    }

    fun pop():String?{
        val item = first?.item
        first = first?.next
        return item
    }


}

fun main(){
    val stackOfStrings = StackOfStrings()

    stackOfStrings.push("Samsung")
    stackOfStrings.push("Huawei")
    stackOfStrings.push("Xiaomi")

    println(stackOfStrings.pop())
    println(stackOfStrings.pop())
    println(stackOfStrings.pop())
    println(stackOfStrings.pop())
}
