/*
===============================================================================
                PRIORITYQUEUE & ARRAYDEQUE
===============================================================================

Topics Covered

1. Queue
2. PriorityQueue
3. ArrayDeque
4. Difference between them

===============================================================================
                            QUEUE
===============================================================================

Definition

Queue follows the FIFO principle.

FIFO = First In First Out

The element inserted first is removed first.

Real World Example

People standing in a ticket counter.

Person 1 enters first.

↓

Person 1 leaves first.

This is Queue.

===============================================================================
*/

import java.util.*;

public class QueueDemo {

    public static void main(String[] args) {

        /*
        ===============================================================
                        PRIORITY QUEUE
        ===============================================================

        Stores elements according to priority.

        By default,

        Smallest element gets highest priority.
        */

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(40);
        pq.offer(10);
        pq.offer(30);
        pq.offer(20);

        System.out.println("PriorityQueue : " + pq);

        /*
        peek()

        Returns first element.

        Does NOT remove it.
        */

        System.out.println("Peek : " + pq.peek());

        /*
        poll()

        Removes highest priority element.
        */

        System.out.println("Removed : " + pq.poll());

        System.out.println("After Poll : " + pq);

        System.out.println();

        /*
        ===============================================================
                        ARRAY DEQUE
        ===============================================================

        Double Ended Queue

        Insert/Delete can happen from both ends.
        */

        ArrayDeque<String> deque = new ArrayDeque<>();

        deque.addFirst("Java");

        deque.addLast("Python");

        deque.addFirst("C++");

        deque.addLast("JavaScript");

        System.out.println("ArrayDeque : " + deque);

        /*
        Remove from both ends
        */

        deque.removeFirst();

        deque.removeLast();

        System.out.println("After Remove : " + deque);

    }

}

/*
| PriorityQueue                          | ArrayDeque                         |
| -------------------------------------- | ---------------------------------- |
| Elements stored by priority            | Elements stored in insertion order |
| Smallest element comes first (default) | No automatic sorting               |
| One end is mainly used for removal     | Both ends can be used              |
| Used for scheduling/priorities         | Used as Queue or Stack             |
'

Queue
↓

FIFO

----------------------

PriorityQueue

↓

Stores by Priority

Smallest Element First

offer()

peek()

poll()

----------------------

ArrayDeque

↓

Double Ended Queue

addFirst()

addLast()

removeFirst()

removeLast()' */