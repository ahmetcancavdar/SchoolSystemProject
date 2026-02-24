package org.example;

// ======================
// Course.java
// ======================
public class Course {

    private class Node {
        Student data;
        Node next;
        Node prev;
        Node(Student s) {
            this.data = s;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public Course() {
        head = null;
        tail = null;
        size = 0;
    }

// 1. INSERTION OPERATIONS

    // Add a student to the beginning of the list
    public void addFirst(Student s) {
    // Fill in the blanks.
        Node newStudent = new Node(s);

        if(head == null) {
            head = newStudent;
            tail = newStudent;
        }else{
            newStudent.next = head;
            head.prev = newStudent;
            head = newStudent;
        }
        size++;
    }

    // Add a student to the end of the list
    public void addLast(Student s) {
    // Fill in the blanks.
        Node newStudent = new Node(s);
        if(tail == null) {
            head = newStudent;
            tail = newStudent;
        }else {
            tail.next = newStudent;
            newStudent.prev = tail;
            tail = newStudent;
        }
        size++;
    }

    // Add a student at a given position in the list
    public void addAt(Student s, int index) {
    // Fill in the blanks.
        Node newStudent = new Node(s);
        Node temp = head;

        if(index < 0 || index>size){
            return;
        }

        if(index == 0) {
            addFirst(s);
            return;
        }else if(index == size){
            addLast(s);
            return;
        }else {
            for(int i = 0; i<index-1; i++){
                temp = temp.next;
            }
            newStudent.prev = temp;
            newStudent.next = temp.next;
            temp.next.prev = newStudent;
            temp.next = newStudent;

            size++;
        }
    }

// 2. DELETION OPERATIONS

    // Delete a student by name
    public void deleteByName(String name) {
    // Fill in the blanks.
        if (head == null) return; // Liste boşsa işlem yapma

        Node current = head;
        while (current != null) {
            if (current.data.getName().equals(name)) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                }
                else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }

                size--;
                return;
            }
            current = current.next;
        }
    }

    // Delete a student by position
    public void deleteByIndex(int index) {
    // Fill in the blanks.
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        }
        else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            Node target = head;
            for (int i = 0; i < index; i++) {
                target = target.next;
            }
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }

        size--;
    }

// 3. SEARCHING

    // Search for student by name and return index
    public int searchByName(String name) {
    // Fill in the blanks.
        Node temp = head;
        int count = 0 ;
        while(temp != null){
            if(temp.data.getName().equals(name)) {
                return count;
            }
            temp = temp.next;
            count++;
        }
        return -1;
    }

    // Search for student by ID and return index
    public int searchByID(int id) {
    // Fill in the blanks.
        Node temp = head;
        int count = 0 ;
        while(temp != null){
            if(temp.data.getID() == id) {
                return count;
            }
            temp = temp.next;
            count++;
        }
        return -1;
    }

// 4. LISTING

    // Print forward (head → tail)
    public void printForward() {
    // Fill in the blanks.
        Node current = head;
        while(current !=null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Print backward (tail → head)
    public void printBackward() {
    // Fill in the blanks.
        Node current = tail;
        while(current !=null){
            System.out.println(current.data);
            current = current.prev;
        }
    }


// 5. COURSE STATISTICS

    public int getSize() {
        return size;
    }

    public Student getFirst() {
        return head != null ? head.data : null;
    }

    public Student getLast() {
        return tail != null ? tail.data : null;
    }

// 6. ADDITIONAL FEATURES

    // Reverse the entire list by swapping next and prev pointers
    public void reverseList() {
    // Fill in the blanks.
        Node current = head;
        Node temp;
        while(current != null) {
            temp = current.next;

            current.next = current.prev;

            current.prev = temp;

            current = current.prev;
        }
        Node tempForHead = head;
        head = tail;
        tail = tempForHead;
    }

    // Sort by student name
    public void sortByName() {
    // Fill in the blanks.
        if (size < 2) return;

        Node current = head.next;

        while (current != null) {
            Node nextNode = current.next;

            if (current.data.getName().compareToIgnoreCase(current.prev.data.getName()) < 0) {

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                current.prev.next = current.next;

                Node search = current.prev;
                while (search != null && current.data.getName().compareToIgnoreCase(search.data.getName()) < 0) {
                    search = search.prev;
                }
                if (search == null) {
                    current.next = head;
                    current.prev = null;
                    head.prev = current;
                    head = current;
                } else {
                    current.next = search.next;
                    current.prev = search;
                    if (search.next != null) {
                        search.next.prev = current;
                    } else {
                        tail = current;
                    }
                    search.next = current;
                }
            }
            current = nextNode;
        }
    }

    // Sort by student ID
    public void sortByID() {
    // Fill in the blanks.
        if (size < 2) return;

        Node current = head.next;
        while (current != null) {
            Node nextNode = current.next;

            if (current.data.getID() < current.prev.data.getID()) {
                if (current.next != null) current.next.prev = current.prev;
                else tail = current.prev;
                current.prev.next = current.next;

                Node search = current.prev;
                while (search != null && current.data.getID() < search.data.getID()) {
                    search = search.prev;
                }

                if (search == null) {
                    current.next = head;
                    current.prev = null;
                    head.prev = current;
                    head = current;
                } else {
                    current.next = search.next;
                    current.prev = search;
                    if (search.next != null) search.next.prev = current;
                    else tail = current;
                    search.next = current;
                }
            }
            current = nextNode;
        }
    }

    // Merge "other" course into the end of this course
    public void mergeCourse(Course other) {
    // Fill in the blanks.
        if (other == null || other.head == null) {
            return;
        }

        if (this.head == null) {
            this.head = other.head;
            this.tail = other.tail;
            this.size = other.size;
            return;
        }
        this.tail.next = other.head;
        other.head.prev = this.tail;
        this.tail = other.tail;

        this.size += other.size;
    }
}