
5.

fun main() {
    
        // Original List
        val firstNode = Node(1,"Email Message 1")
        firstNode.previousNode = Node(2,"Email Message 2")
        firstNode.previousNode!!.previousNode = Node(3,"Email Message 3")
        firstNode.previousNode!!.previousNode!!.previousNode = Node(4, "Email Message 1")
        firstNode.previousNode!!.previousNode!!.previousNode!!.previousNode = Node(5, "Email Message 2")
                
        printResult("Original List : ",firstNode)
        
        val modifiedNode = removeDuplicatedMessages(firstNode)
               
        printResult("Modified List : ",modifiedNode)
        
    }
    
    fun removeDuplicatedMessages(node: Node?) : Node?{

        val hashSet = hashSetOf<String>()
        var currentNode = node
        var previousNode: Node? = null

        while (currentNode != null) {
            val value = currentNode.message

            if (hashSet.contains(value)) {
                previousNode!!.previousNode = currentNode.previousNode
            } else {
                hashSet.add(value)
                previousNode = currentNode
            }
            currentNode = currentNode.previousNode
        }
        
        return node

    }
    
    fun printResult(label : String, node: Node?){
        
        print(label)
        
        var currentNode = node
        while (currentNode != null) {
            print(currentNode.message.toString() + "  ")
            currentNode = currentNode.previousNode
        }
        println()
    }
    
    class Node(var data: Long, var message : String) {
        var previousNode: Node? = null
    }






