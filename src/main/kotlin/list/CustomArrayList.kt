package org.example.list

class CustomArrayList(size: Int): CustomList {
    private var inner = IntArray(size)
    private var lastIndex = 0

    override fun get(index: Int): Int {
        if (index >= lastIndex || index < 0) {
            throw IndexOutOfBoundsException()
        }

        return inner[index]
    }

    override fun set(index: Int, value: Int) {
        if (index >= lastIndex || index < 0) {
            throw IndexOutOfBoundsException()
        }

        inner[index] = value
    }

    override fun add(element: Int) {
        if (lastIndex == (inner.size * 3 / 4)) {
            resize()
        }

        inner[lastIndex] = element
        lastIndex++
    }

    override fun addFirst(element: Int) {
        if (lastIndex == (inner.size * 3 / 4)) {
            resize()
        }

        var prevValue = inner[0]
        for (i in 1 until lastIndex + 1) {
            val nextValue = inner[i]

            inner[i] = prevValue
            prevValue = nextValue
        }

        inner[0] = element
        lastIndex++
    }

    override fun remove(element: Int): Boolean {
        val firstIndex = indexOf(element)

        if (firstIndex == -1) {
            return false
        }

        lastIndex--

        for (i in firstIndex until lastIndex) {
            inner[i] = inner[i + 1]
        }

        return true
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
        get() = lastIndex

    private fun resize() {
        val oldSize = inner.size

        val newSize = if (oldSize == 0) 8 else oldSize * 2

        val newArray = inner.copyOf(newSize = newSize)

        inner = newArray
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            var currentIndex = 0
            override fun hasNext(): Boolean {
                return currentIndex < lastIndex
            }

            override fun next(): Int {
                if (hasNext()) {
                    val value = inner[currentIndex]
                    currentIndex++

                    return value
                }

                throw NoSuchElementException()
            }
        }
    }

    companion object {
        fun customArrayListOf(vararg items: Int) =
            items.fold(CustomArrayList(items.size)) { list, item ->
                list.also { it.add(item) }
            }
    }
}