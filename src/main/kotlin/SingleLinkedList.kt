package org.example

class SingleLinkedList : CustomList {
    private var head: Node? = null
    private var _size: Int = 0

    private class Node(var value: Int,  var next: Node? = null)

    override val size: Int
        get() = _size

    override fun add(element: Int) {
        val newNode = Node(value = element, next = null)

        if (head == null) {
            head = newNode
            _size++
            return
        }

        var currentNode = head
        while (currentNode?.next != null) {
            currentNode = currentNode.next
        }

        currentNode?.next = newNode
        _size++
    }

    override operator fun set(index: Int, value: Int) {
        val node = findNodeByIndex(index)
        node.value = value
    }

    override fun addFirst(element: Int) {
        val newHead = Node(value = element, next = head)
        head = newHead
        _size++
    }

    override operator fun get(index: Int): Int {
        val node = findNodeByIndex(index)
        return node.value
    }

    override fun indexOf(element: Int): Int {
        var currentIndex = 0

        var currentNode = head
        while (currentNode != null) {
            if (currentNode.value == element) {
                return currentIndex
            }

            currentNode = currentNode.next
            currentIndex++
        }

        return -1
    }

    override fun remove(element: Int): Boolean {
        var prevNode: Node? = null
        var currentNode = head

        while (currentNode != null) {
            if (currentNode.value == element) {
                if (prevNode == null) {
                    head = head?.next
                    _size--

                    return true
                }

                prevNode.next = currentNode.next
                _size--

                return true
            }

            prevNode = currentNode
            currentNode = currentNode.next
        }

        return false
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            var currentNode = head

            override fun hasNext(): Boolean {
                return currentNode != null
            }

            override fun next(): Int {
                if (hasNext()) {
                    val value: Int = currentNode!!.value
                    currentNode = currentNode?.next

                    return value
                }

                throw NoSuchElementException()
            }
        }
    }

    private fun findNodeByIndex(index: Int): Node {
        if (index >= _size || index < 0) {
            throw IndexOutOfBoundsException()
        }

        var currentIndex = 0

        var currentNode = head
        while (currentNode != null) {
            if (currentIndex == index) {
                return currentNode
            }

            currentNode = currentNode.next
            currentIndex++
        }

        throw IndexOutOfBoundsException()
    }



    companion object {
        fun singleLinkedListOf(vararg items: Int) =
            items.fold(SingleLinkedList()) { list, item ->
                list.also{ it.add(item) }
            }
    }
}