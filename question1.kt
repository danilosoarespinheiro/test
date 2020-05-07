1. 


fun main() {

    var stringWithSpaces = "User is not allowed      ".toCharArray()
    
    var stringModified = replaceSpaces(stringWithSpaces)
    
    printResult(stringModified)
}

fun replaceSpaces(stringProcessed: CharArray) : CharArray {
    while (stringProcessed.contains(' ')) {
        
        var spacePosition = stringProcessed.indexOf(' ')
        var lastCharPosition = stringProcessed.indexOfLast { 
            aux -> aux != ' ' 
        }

        for (i in lastCharPosition downTo spacePosition) {
            stringProcessed[i + 2] = stringProcessed[i]
        }
        stringProcessed[spacePosition] = '&'
        stringProcessed[spacePosition + 1] = '3'
        stringProcessed[spacePosition + 2] = '2'
    }
    
    return stringProcessed
}

fun printResult(result : CharArray){
    println(result)
}



