package org.example.stack

import org.example.list.SingleLinkedList


class SingleLinkedStack : Stack, SingleLinkedList() {


    override fun push(value: Int) {
        this.addFirst(value)
    }

    override fun pop(): Int {
        if (isEmpty) {
            throw NoSuchElementException()
        }

        val value = this[0]

        this.remove(value)

        return value
    }

    override fun peek(): Int {
        if (isEmpty) {
            throw NoSuchElementException()
        }

        return this[0]
    }

    override val isEmpty: Boolean
        get() = this.size == 0
}