package union


class WeightedUnion(size: Int) : UnionProblem(size) {

    private val sizeArray = IntArray(size) { 1 }
    override fun union(first: Int, second: Int) {
        val firstRoot = root(first)
        val secondRoot = root(second)
        if (firstRoot == secondRoot) return
        if (sizeArray[firstRoot] >= sizeArray[secondRoot]) {
            arrayList[secondRoot] = firstRoot
            sizeArray[firstRoot] += sizeArray[firstRoot]
        } else {
            arrayList[firstRoot] = secondRoot
            sizeArray[secondRoot] += sizeArray[secondRoot]
        }
        arrayList.map(::print)
        println()
        println("-------------")
    }

    private fun root(index: Int): Int {
        var i = index
        while (arrayList[i] != i) i = arrayList[i]
        return i
    }

    override fun isConnected(first: Int, second: Int) = root(first) == root(second)
}

fun main() {

    val weightedUnion = WeightedUnion(7).apply {
        union(0, 1)
        union(1, 2)
        union(6, 2)
    }

    println("0 and 6 is connected: ${weightedUnion.isConnected(0, 6)}")
    println("4 and 5 is not connected: ${weightedUnion.isConnected(4, 5)}")
    println("0 and 2 is  connected: ${weightedUnion.isConnected(0, 2)}")
    weightedUnion.arrayList.map(::print)
}
