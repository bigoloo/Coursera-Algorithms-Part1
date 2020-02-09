package union


class QuickUnion(size: Int) :UnionProblem(size){

   override fun union(first: Int, second: Int) {
        val i = root(first)
        val j = root(second)
        arrayList[i] = j
    }

    private fun root(index: Int): Int {
        var i = index
        while (arrayList[i] != i) i = arrayList[i]
        return i
    }

   override fun isConnected(first: Int, second: Int) = root(first) == root(second)
}

fun main() {

    val quickFind = QuickUnion(7).apply {
        union(0, 1)
        union(1, 2)
        union(6, 2)
    }

    println("0 and 6 is connected: ${quickFind.isConnected(0, 6)}")
    println("4 and 5 is not connected: ${quickFind.isConnected(4, 5)}")
    println("0 and 2 is  connected: ${quickFind.isConnected(0, 2)}")
    quickFind.arrayList.map(::print)
}

