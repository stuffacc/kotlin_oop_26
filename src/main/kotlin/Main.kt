package org.example

import org.example.list.CustomArrayList.Companion.customArrayListOf
import org.example.list.SingleLinkedList.Companion.singleLinkedListOf
import org.example.stack.ArrayListStack
import org.example.stack.SingleLinkedStack

fun main() {
    val singleLinkedList = singleLinkedListOf(1, 2, 3)
    ListPrinter.printList(singleLinkedList)

    val customArrayList = customArrayListOf(1, 2, 3)
    ListPrinter.printList(customArrayList)

    val singleLinkedStack = SingleLinkedStack()
    singleLinkedStack.push(1)
    singleLinkedStack.push(2)
    singleLinkedStack.push(3)
    ListPrinter.printList(singleLinkedStack)


    val arrayListStack = ArrayListStack()
    arrayListStack.push(1)
    arrayListStack.push(2)
    arrayListStack.push(3)
    ListPrinter.printList(arrayListStack)
}