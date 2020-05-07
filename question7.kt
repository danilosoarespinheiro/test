
7. 


    fun main() {
        // First List
        val firstNode = Node('C')
        firstNode.nextNode = Node('A')
        firstNode.nextNode!!.nextNode = Node('E')
        firstNode.nextNode!!.nextNode!!.nextNode = Node('H')
        firstNode.nextNode!!.nextNode!!.nextNode!!.nextNode = Node('J')
        
        // Second List
        val secondNode = Node('D')
        secondNode.nextNode = Node('F')
        secondNode.nextNode!!.nextNode = Node('J')
        secondNode.nextNode!!.nextNode!!.nextNode = firstNode.nextNode!!.nextNode!!.nextNode!!.nextNode
        
        printResult("First List : ",firstNode)
        printResult("Second List : ",secondNode)     
        println("Intersection : " + MegeNode(firstNode, secondNode)!!.data)
    }
    
    fun MegeNode(firstNode: Node?, secondNode: Node?): Node? {

        var firstNode = firstNode
        var secondNode = secondNode
        val hashSet = HashSet<Node>()
        while (firstNode != null) {
            hashSet.add(firstNode)
            firstNode = firstNode.nextNode
        }
        while (secondNode != null) {
            if (hashSet.contains(secondNode)) {
                return secondNode
            }
            secondNode = secondNode.nextNode
        }
        return null
    }
    
    
    fun printResult(label : String, node: Node?){
        
        print(label)
        
        var currentNode = node
        while (currentNode != null) {
            print(currentNode.data.toString() + "  ")
            currentNode = currentNode.nextNode
        }
        
        println()
    }
    
    class Node(var data: Char) {
        var nextNode: Node? = null
    }




