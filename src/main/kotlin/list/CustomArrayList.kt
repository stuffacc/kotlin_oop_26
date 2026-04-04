package org.example.list

class CustomArrayList(size: Int): CustomList {
    private var inner = IntArray(size)
    private var lastIndex = 0

    override fun get(index: Int): Int {
        return inner[index]
    }

    override fun set(index: Int, value: Int) {
        inner[index] = value
    }

    override fun add(element: Int) {
        if (lastIndex == (inner.size * 3 / 4)) {
            resize(newSize = inner.size * 2)
        }

        inner[lastIndex] = element
        lastIndex++
    }

    override fun addFirst(element: Int) {
        val intArr = IntArray(1)
        intArr[0] = element

        val newArr = intArr + inner
        inner = newArr
        lastIndex++
    }

    override fun remove(element: Int): Boolean {
        val newArray = IntArray(lastIndex)
        var deleted = false
        for (i in 0 until lastIndex) {
            val value = inner[i]

            if (value == element && !deleted) {
                deleted = true
                continue
            }

            newArray[i] = value
        }

        inner = newArray

        return deleted
    }

    override fun indexOf(element: Int): Int {
        for (i in 0 until lastIndex) {
            val value = inner[i]

            if (value == element) {
                return i
            }
        }

        return -1
    }

    override val size: Int
        get() = TODO("Not yet implemented")

    private fun resize(newSize: Int) {
        val newArray = inner.copyOf(newSize = newSize)

        inner = newArray
    }

    override fun iterator(): Iterator<Int> {
        TODO("Not yet implemented")
    }

    companion object {
        fun customArrayListOf(vararg items: Int) =
            items.fold(CustomArrayList(items.size)) { list, item ->
                list.also { it.add(item) }
            }
    }
}