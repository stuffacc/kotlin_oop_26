package org.example.list

class SingleLinkedList : CustomList {

    private var head: Node? = null
    private var sizeList: Int = 0

    private class Node(var value: Int = 0,  var next: Node? = null)

    override val size: Int
        get() = this.sizeList

    override fun add(element: Int) {
        sizeList++
        val newNode = Node(value = element, next = null)


        if (head == null) {
            head = newNode
            return
        }

        var currentNode = head
        while (currentNode?.next != null) {
            currentNode = currentNode.next
        }

        currentNode?.next = newNode
    }

    override operator fun set(index: Int, value: Int) {
        if (index >= sizeList) {
            throw IndexOutOfBoundsException()
        }

        var currentIndex = 0

        var currentNode = head
        while (currentNode != null) {
            if (currentIndex == index) {
                currentNode.value = value
                break
            }

            currentNode = currentNode.next
            currentIndex++
        }


    }

    override fun addFirst(element: Int) {
        sizeList++

        val newHead = Node(value = element, next = head)
        head = newHead
    }

    override operator fun get(index: Int): Int {
        if (index >= sizeList) {
            throw IndexOutOfBoundsException()
        }

        var currentIndex = 0

        var currentNode = head
        while (currentNode != null) {
            if (currentIndex == index) {
                return currentNode.value
            }

            currentNode = currentNode.next
            currentIndex++
        }

        throw IndexOutOfBoundsException()
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
                sizeList--
                if (prevNode == null) {
                    head = null
                    return true
                }

                prevNode.next = currentNode.next

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
                return currentNode != null && currentNode?.next != null
            }

            override fun next(): Int {
                if (currentNode != null) {
                    val value: Int = currentNode?.value!!
                    currentNode = currentNode?.next

                    return value
                }

                return ITERATOR_ENDED_VALUE
            }
        }
    }

    companion object {
        const val ITERATOR_ENDED_VALUE = Int.MIN_VALUE

        fun singleLinkedListOf(vararg items: Int) =
            items.fold(SingleLinkedList()) { list, item ->
                list.also { it.add(item) }
            }
    }
}