
2. 

fun main() {
    var input: Array<String> = arrayOf("you", "yuo")
    var verifyFirstLetter = verifyFirstLetter(input[0], input[1])
    var verifyParcialPermutation = verifyParcialPermutation(input[0], input[1])
    var permutation = false
        
    if(verifyFirstLetter && verifyParcialPermutation){
        permutation = true
    }
    
    printResult(input[0], input[1], permutation)
}

fun verifyFirstLetter(first : String, second : String) : Boolean {
    if(first.first() == second.first()){
        return true
    }else{
        return false
    }
}

fun verifyParcialPermutation(first : String, second : String) : Boolean {
    
        val firstSize: Int = first.length
        val secondSize: Int = second.length
    	var countDifferentLetters = 0
       
        if (firstSize != secondSize) {
           return false 
        }
        val firstArray: CharArray = first.toCharArray()
        val secondArray: CharArray = second.toCharArray()
      
        for (i in 0 until firstSize){
          if (firstArray[i] != secondArray[i]) {
              countDifferentLetters++
              if(countDifferentLetters == 4){
                  return false     
              }
          }
        }       
        
        return true
}

fun printResult(first : String, second : String, result : Boolean){
    print(first + " , " + second + " -> " )    
    println(result)
}




