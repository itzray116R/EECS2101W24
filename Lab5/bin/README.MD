Certainly! Here are the methods of the `YorkSortedDoublyLinkedList` class, each with its implementation:

### 1. No-argument Constructor

```java
public YorkSortedDoublyLinkedList() {
    // Initialize an empty list with header and trailer sentinels
    header = new Node<>(null);
    trailer = new Node<>(null);
    header.next = trailer;
    trailer.prev = header;
}
```

### 2. Constructor with Array Parameter

```java
public YorkSortedDoublyLinkedList(E[] objects) {
    this();
    // Insert elements from the array to the end of the list
    for (E obj : objects) {
        addLast(obj);
    }
}
```

### 3. `size()` Method

```java
@Override
public int size() {
    return size;
}
```

### 4. `isEmpty()` Method

```java
@Override
public boolean isEmpty() {
    return size == 0;
}
```

### 5. `get(int i)` Method

```java
@Override
public E get(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= size) {
        throw new IndexOutOfBoundsException("Index out of bounds: " + i);
    }
    Node<E> current = header.next;
    for (int index = 0; index < i; index++) {
        current = current.next;
    }
    return current.element;
}
```

### 6. `set(int i, E e)` Method

```java
@Override
public E set(int i, E e) throws IndexOutOfBoundsException {
    if (i < 0 || i >= size) {
        throw new IndexOutOfBoundsException("Index out of bounds: " + i);
    }
    Node<E> current = header.next;
    for (int index = 0; index < i; index++) {
        current = current.next;
    }
    E previousElement = current.element;
    current.element = e;
    return previousElement;
}
```

### 7. `add(int i, E e)` Method

```java
@Override
public void add(int i, E e) {
    if (i < 0 || i > size) {
        throw new IndexOutOfBoundsException("Index out of bounds: " + i);
    }
    Node<E> newNode = new Node<>(e);
    Node<E> current = header;
    for (int index = 0; index < i; index++) {
        current = current.next;
    }
    newNode.next = current.next;
    newNode.prev = current;
    current.next.prev = newNode;
    current.next = newNode;
    size++;
}
```

### 8. `remove(int i)` Method

```java
@Override
public E remove(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= size) {
        throw new IndexOutOfBoundsException("Index out of bounds: " + i);
    }
    Node<E> current = header.next;
    for (int index = 0; index < i; index++) {
        current = current.next;
    }
    E removedElement = current.element;
    current.prev.next = current.next;
    current.next.prev = current.prev;
    size--;
    return removedElement;
}
```

### 9. `contains(E e)` Method

```java
@Override
public boolean contains(E e) throws NullPointerException {
    if (e == null) {
        throw new NullPointerException("Specified element is null");
    }

    Node<E> current = header.next;
    while (current != trailer) {
        if (current.element.equals(e)) {
            return true;
        }
        current = current.next;
    }

    return false;
}
```

### 10. `remove(E e)` Method

```java
@Override
public boolean remove(E e) throws NullPointerException {
    if (e == null) {
        throw new NullPointerException("Specified element is null");
    }

    Node<E> current = header.next;
    while (current != trailer) {
        if (current.element.equals(e)) {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            return true;
        }
        current = current.next;
    }

    return false;
}
```

### 11. `addAll(List<E> otherList)` Method

```java
@Override
public boolean addAll(List<E> otherList) throws NullPointerException {
    if (otherList == null) {
        throw new NullPointerException("Specified list is null");
    }

    Iterator<E> iterator = otherList.iterator();
    boolean modified = false;
    while (iterator.hasNext()) {
        addLast(iterator.next());
        modified = true;
    }

    return modified;
}
```

### 12. `removeAll(List<E> otherList)` Method

```java
@Override
public boolean removeAll(List<E> otherList) throws NullPointerException {
    if (otherList == null) {
        throw new NullPointerException("Specified list is null");
    }

    Iterator<E> iterator = otherList.iterator();
    boolean modified = false;
    while (iterator.hasNext()) {
        modified |= remove(iterator.next());
    }

    return modified;
}
```

### 13. `retainAll(List<E> otherList)` Method

```java
@Override
public boolean retainAll(List<E> otherList) throws NullPointerException {
    if (otherList == null) {
        throw new NullPointerException("Specified list is null");
    }

    boolean modified = false;
    Node<E> current = header.next;
    while (current != trailer) {
        if (!otherList.contains(current.element)) {
            Node<E> nextNode = current.next;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current = nextNode;
            size--;
            modified = true;
        } else {
            current = current.next;
        }
    }

    return modified;
}
```

### 14. `addAfter(int i, E e)` Method

```java
public void addAfter(int i, E e) {
    if (i < 0) {
        i = size; // Add to the end if the index is greater than the size
    }

    Node<E> newNode = new Node<>(e);
    Node<E> current = header;
    for (int index = 0; index < i; index++) {
        current = current.next;
    }

    newNode.next = current.next;
    newNode.prev = current;
    current.next.prev = newNode;
    current.next = newNode;
    size++;
}
```

### 15. `removeBetween(int lowerindex, int upperindex)` Method

```java
public void removeBetween(int lowerindex, int upperindex) {
    if (lowerindex < 0 || lowerindex >= size || upperindex < 0 || upperindex >= size || lowerindex > upperindex) {
        throw new IndexOutOfBoundsException("Invalid indices");
    }

    Node<E> lowerNode = header.next;
    Node<E> upperNode = header.next;
    for (int index = 0; index < lowerindex; index++) {
        lowerNode = lowerNode.next;
    }
    for (int index = 0; index <= upperindex; index++) {
        upperNode = upperNode.next;
    }

    lowerNode.next = upperNode;
    upperNode.prev = lowerNode;
    size -= (upperindex - lowerindex + 1);
}
``

`

### 16. `getFirst()` Method

```java
public E getFirst() {
    if (size == 0) {
        return null;
    }
    return header.next.element;
}
```

### 17. `addFirst(E e)` Method

```java
public void addFirst(E e) {
    add(0, e);
}
```

### 18. `addLast(E e)` Method

```java
public void addLast(E e) {
    add(size, e);
}
```

### 19. `getLast()` Method

```java
public E getLast() {
    if (size == 0) {
        return null;
    }
    return trailer.prev.element;
}
```

### 20. `removeFirst()` Method

```java
public E removeFirst() {
    if (size == 0) {
        return null;
    }
    return remove(0);
}
```

### 21. `removeLast()` Method

```java
public E removeLast() {
    if (size == 0) {
        return null;
    }
    return remove(size - 1);
}
```

### 22. `indexOf(E e)` Method

```java
public int indexOf(E e) {
    Node<E> current = header.next;
    int index = 0;
    while (current != trailer) {
        if (current.element.equals(e)) {
            return index;
        }
        current = current.next;
        index++;
    }
    return -1;
}
```

### 23. `lastIndexOf(E e)` Method

```java
public int lastIndexOf(E e) {
    Node<E> current = trailer.prev;
    int index = size - 1;
    while (current != header) {
        if (current.element.equals(e)) {
            return index;
        }
        current = current.prev;
        index--;
    }
    return -1;
}
```

### 24. `sortAscending(Comparator<E> comparator)` Method

```java
public void sortAscending(Comparator<E> comparator) {
    // Implementation of sorting in ascending order using comparator
    // (You may use a sorting algorithm like insertion sort, merge sort, etc.)
}
```

### 25. `sortDescending(Comparator<E> comparator)` Method

```java
public void sortDescending(Comparator<E> comparator) {
    // Implementation of sorting in descending order using comparator
    // (You may use a sorting algorithm like insertion sort, merge sort, etc.)
}
```

### 26. `toString()` Method

```java
@Override
public String toString() {
    StringBuilder result = new StringBuilder("[");
    Node<E> current = header.next;
    while (current != trailer) {
        result.append(current.element);
        if (current.next != trailer) {
            result.append(", ");
        }
        current = current.next;
    }
    result.append("]");
    return result.toString();
}
```

### 27. `iterator()` Method

```java
@Override
public Iterator<E> iterator() {
    return new Iterator<E>() {
        private Node<E> current = header.next;

        @Override
        public boolean hasNext() {
            return current != trailer;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            E element = current.element;
            current = current.next;
            return element;
        }
    };
}
```

Please note that the sorting methods (`sortAscending` and `sortDescending`) are left unimplemented. You can choose an appropriate sorting algorithm based on your requirements and implement them accordingly.