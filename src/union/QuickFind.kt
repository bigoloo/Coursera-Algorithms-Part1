package union


class QuickFind(size:Int) {
    var mutableArrayList = IntArray(size) { it }
    fun union(first: Int, second: Int) {
        val firstValue = mutableArrayList[first]
        val secondValue = mutableArrayList[second]

        mutableArrayList.forEachIndexed { index, _ ->
            if (secondValue == mutableArrayList[index]) {
                mutableArrayList[index] = firstValue
            }
        }
    }

    fun isConnected(first: Int, second: Int) = mutableArrayList[first] == mutableArrayList[second]
}

fun main() {

    val quickFind = QuickFind(7).apply {
        union(0,1)
        union(1,2)
        union(6,2)
     }

    println("0 and 6 is connected: ${quickFind.isConnected(0,6)}")
    println("4 and 5 is not connected: ${quickFind.isConnected(4,5)}")
    println("0 and 2 is  connected: ${quickFind.isConnected(0,2)}")
    quickFind.mutableArrayList.map(::print)
}

