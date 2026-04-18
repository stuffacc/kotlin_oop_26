package org.example

import org.example.list.CustomList

object ListPrinter {
    fun printList(list: CustomList) {
        print(list.javaClass.simpleName + ": [")
        val iterator = list.iterator()
        while (iterator.hasNext()) {
            val value = iterator.next()

            if (!iterator.hasNext()) {
                print(value)
            }

            else {
                print("$value, ")
            }
        }
        print("]\n")
    }
}