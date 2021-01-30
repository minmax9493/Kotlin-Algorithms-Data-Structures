package coursera.unionFind

class QuickFindUF constructor(n: Int) {
    private var id: IntArray = IntArray(n)

    init {
        for (i in 0 until n) {// set id of each object to itself( N array accesses)
            id[i] = i
        }
    }

    fun connected(p: Int, q: Int): Boolean {// check whether p and q are in the same component(2 array accesses)
        return id[p] == id[q]
    }

    fun union(p: Int, q: Int) {
        val pId = id[p]
        val qId = id[q]

        for (i in id.indices) {// change all entries with id[p] to id[q](at most 2N+2 array accesses)
            if (id[i] == pId) id[i] = qId
        }
    }
}
/**
 * Quick-find defect, Union too expensive.
 * Ex. Take N^2 array accesses to process sequence of N union commands of N objects
 *
 * algorithm     initialize      union       find
 *
 * quick-find       N              N           1 
 * **/