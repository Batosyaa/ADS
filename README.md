Hello! Here's the second assignment for the Algorithms and Data Structures, I have tried my best, hope everything's clear.


Our task was to create ArrayList, LinkedList, Queue, Heap, Stack, connect, and test them.
As I understood, the task was to implement and understand on the practice how everything works, which was successfuly completed!

There in src/main/java/com/ads/Assignments/Assignment_2 you can observe various files, but don't worry, I'll explain what are they.

Each file is named after the data structure or implementation stucture that are located there, for instance, MyQueue.java doesn't include stack or LinkedList construction, but the queue
and the implementation through LinkedList (as we were told it's way better than ArrayList)

There are some comments for some often misundrstood functions.

Scheme of the connection and implementation kinda looks like this:
          MyLinkedList -- MyQueue
MyList -- |
          MyArrayList -- MyMinHeap, MyStack

So, basic interface is from MyList, MyLinkedList and MyArrayList explain methods that are used in MyQueue, MyStack, and MyMinHeap
