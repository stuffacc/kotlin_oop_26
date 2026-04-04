package org.example.stack

import org.example.list.CustomArrayList

class ArrayListStack : Stack {
    val customArrayList = CustomArrayList(size = 8)

    override fun push(value: Int) {
        customArrayList.addFirst(value)
    }

    override fun pop(): Int {
        if (isEmpty) {
            throw NoSuchElementException()
        }

        val value = customArrayList[0]

        customArrayList.remove(value)

        return value
    }

    override fun peek(): Int {
        if (isEmpty) {
            throw NoSuchElementException()
        }

        return customArrayList[0]
    }

    override val isEmpty: Boolean
        get() = customArrayList.size == 0

    override fun get(index: Int): Int {
        return customArrayList[index]
    }

    override fun set(index: Int, value: Int) {
        customArrayList[index] = value
    }

    override fun add(element: Int) {
        customArrayList.add(element)
    }

    override fun addFirst(element: Int) {
        customArrayList.addFirst(element)
    }

    override fun remove(element: Int): Boolean {
        return customArrayList.remove(element)
    }

    override fun indexOf(element: Int): Int {
        return customArrayList.indexOf(element)
    }

    override val size: Int
        get() = customArrayList.size

    override fun iterator(): Iterator<Int> {
        return customArrayList.iterator()
    }
}