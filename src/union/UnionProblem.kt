package union

abstract class UnionProblem(size: Int) {
    val arrayList = IntArray(size) { it }
   abstract fun union(first:Int,second:Int)
   abstract fun isConnected(first:Int,second:Int) : Boolean
}