package org.example.stack

import org.example.list.CustomArrayList

class ArrayListStack : Stack {
    // TODO: use delegation instead of inheritance here, use CustomArrayList
    val customArrayList = CustomArrayList(size = 8)

    override fun push(value: Int) {
        customArrayList.add(value)
    }

    override fun pop(): Int {
        TODO("Not yet implemented")
    }

    override fun peek(): Int {
        TODO("Not yet implemented")
    }

    override val isEmpty: Boolean
        get() = TODO("Not yet implemented")

    override fun get(index: Int): Int {
        TODO("Not yet implemented")
    }

    override fun set(index: Int, value: Int) {
        TODO("Not yet implemented")
    }

    override fun add(element: Int) {
        TODO("Not yet implemented")
    }

    override fun addFirst(element: Int) {
        TODO("Not yet implemented")
    }

    override fun remove(element: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: Int): Int {
        TODO("Not yet implemented")
    }

    override val size: Int
        get() = TODO("Not yet implemented")

    override fun iterator(): Iterator<Int> {
        TODO("Not yet implemented")
    }
}