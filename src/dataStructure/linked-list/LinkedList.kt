package dataStructure.`linked-list`

/**
 * LinkedList examples, the source is from geeks for geeks
 * https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/?ref=lbp
 */
fun main(){

    val link = LinkedList()

    link.pushFront(10)
    link.pushFront(20)
    link.pushFront(30)

    link.append(5)
    link.append(6)
    link.append(7)

    link.pushAt(link.head!!.next, 100)

    link.printLinkedList()
}

class LinkedList {
    var head: Node?=null

    class Node(var data: Int) {
        var next: Node?=null
    }

    /**
     * Push data at the front
     */
    fun pushFront(newData:Int){
        val newNode = Node(newData)
        newNode.next = head
        head = newNode
    }

    /**
     * Push data at the end
     */
    fun append(data:Int){
        val newNode = Node(data)
        if(head == null){
            head = newNode
            return
        }

        var last = head
        while(last!!.next!=null)
            last = last!!.next
        last.next = newNode
    }

    fun pushAt(prevNode: Node?, newData: Int){
        if(prevNode==null){
            println("The given previous prevNode can not be null")
            return
        }

        var newNode = Node(newData)
        newNode.next = prevNode.next
        prevNode.next = newNode
    }

    /**
     * Print linked list nodes
     */
    fun printLinkedList(){
        var node = head
        while(node!=null){
            print("${node.data} ")
            node = node.next
        }
    }
}