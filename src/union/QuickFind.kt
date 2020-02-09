package union


class QuickFind(size:Int): UnionProblem(size) {
    override fun union(first: Int, second: Int) {
        val firstValue = arrayList[first]
        val secondValue = arrayList[second]

        arrayList.forEachIndexed { index, _ ->
            if (secondValue == arrayList[index]) {
                arrayList[index] = firstValue
            }
        }
    }

   override fun isConnected(first: Int, second: Int) = arrayList[first] == arrayList[second]
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
    quickFind.arrayList.map(::print)
}

