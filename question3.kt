
3. 

fun main() {
    var input: Array<String> = arrayOf("pale", "pal")
    var verify = verify(input[0], input[1])
    printResult(input[0], input[1], verify)
}

fun verify(first : String, second : String) : String {
    	
    	val firstSize: Int = first.length
        val secondSize: Int = second.length
    	var countDifferentLetters = 0
    	
        val firstArray: CharArray = first.toCharArray()
        val secondArray: CharArray = second.toCharArray()
    	var compare = first.compareTo(second)
        
    	if(compare < 0){
            
            for (i in 0 until firstSize){
              if (firstArray[i] != secondArray[i]) {
                  return "Replace"
              }
            }       
            return "Insert"
            
        }else if (compare == 0){
            return "Equals"    
        }else {
                      
            return "Remove" 
        }      	      
}

fun printResult(first : String, second : String, result : String){
    print(first + " , " + second + " -> " )    
    println(result)
}




