public class PhoneBook {
    private PhoneNode node;
    private int length;

    // Adds a new element to the linked list but at the end
    public void addToNode(String firstName, String lastName, String address, String city, String phoneNumber) {
        PhoneNode tempNode = this.node;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        PhoneNode dummy = new PhoneNode(firstName, lastName, address, city, phoneNumber);
        this.length++;
        dummy.prev = tempNode;
        tempNode.next = dummy;
    }

    // Adds a new element to the linked list
    public void addToNode(int index, String firstName, String lastName, String address, String city, String phoneNumber) {
        PhoneNode tempNode = this.node;
        if (this.node == null) {
            this.node = new PhoneNode(firstName, lastName, address, city, phoneNumber);
        } else if (index == 0) {
            tempNode = new PhoneNode(firstName, lastName, address, city, phoneNumber);
            tempNode.next = this.node; 
            this.node.prev = tempNode;
            this.node = tempNode;
        } else {
            int counter = 1;
            while (counter < index && tempNode.next != null) {
                tempNode = tempNode.next;
                counter++;
            }
            if (counter < index) { // if counter is still less than index
                PhoneNode newNode = new PhoneNode(firstName, lastName, address, city, phoneNumber);
                tempNode.next = newNode;
                newNode.prev = tempNode;
                tempNode.next.prev = tempNode;
            } else { // If counter is already greater than index or equal to the index
                PhoneNode newNode = new PhoneNode(firstName, lastName, address, city, phoneNumber, tempNode.next);
                tempNode.next = newNode;
                newNode.prev = tempNode;
                if (newNode.next != null) newNode.next.prev = newNode;
            }
        }
        this.length += 1;



    }

    // Displays all elements in the linked list
    public void displayAll() {
        PhoneNode tempNode = this.node;
        while (tempNode != null) {
            System.out.println(tempNode);
            tempNode = tempNode.next;
        }
    }

    // Edits a field of a specific person to a new value
    public void editValue(String firstname, String lastName, String changedValue, String field) {
        PhoneNode current = this.node;
        while (current != null) {
            if (current.getLastName().equals(lastName) && current.getFirstName().equals(firstname)) {
                switch (field) {
                    case "firstName": { current.setFirstName(changedValue); break; }
                    case "lastName": { current.setLastName(changedValue); break;}
                    case "address": { current.setAddress(changedValue); break;}
                    case "phoneNumber": { current.setPhoneNumber(changedValue); break;}
                    default: { throw new ArithmeticException("Field not found for editValue");}
                }
                break;
            }
            current = current.next;
        }
    }

    // Removes an element from the linked list
    public void removeNode(String firstName, String lastName) {
        PhoneNode tempNode = this.node;
        while (tempNode != null) {
            if (tempNode.next.getFirstName().equals(firstName) && tempNode.next.getLastName().equals(lastName)) {
                if (tempNode.next.next == null) {
                    tempNode.next = null;
                } else {
                    tempNode.next.next.prev = tempNode;
                    tempNode.next = tempNode.next.next;  
                }
                break;
            }
            tempNode = tempNode.next;
        }
    }

    // Not that efficient of a sorting algorithim, but it works. Designed for doubly linked lists
    public void sortNode() {
        PhoneNode current = this.node.next;
        PhoneNode mostRecentNode = current;
        while (current != null) {
            if (current.prev == null) {
                current = current.next;
                continue;
            }
            PhoneNode prevNode = current.prev;
            String name1a = current.getLastName(), name2a = prevNode.getLastName();
            String name1b = current.getFirstName(), name2b = prevNode.getFirstName();
            int comparedResult =compareStrings(name1a, name2a), comparedResult2 = compareStrings(name1b, name2b);

            if (comparedResult == 1 || (comparedResult == 2 && comparedResult2 == 1)) {
                // Four nodes need to be changed
                // Node names:
                // Node after current node: 4
                // Current node: 3
                // Previous node: 2
                // Node before previous node: 1
                
                // Not even going to bother to optimize this, four different cases
                // Case 1: None are null
                if (current.next != null && prevNode.prev != null) {
                // 6 total links need to be changed
                    prevNode.prev.next = current; // Changes node 1's link from node 2 to node 3
                    current.next.prev = prevNode; // Changes node 4's link from node 3 to node 2
                    current.prev = prevNode.prev; // Changes node 3's link from node 2 to node 1
                    prevNode.prev = current; // Changes node 2's link from node 1 to node 3
                    prevNode.next = current.next; // Changes node 2's link from node 3 to node 4
                    current.next = prevNode; // changes Node 3's link from node 4 to node 2
                    
                    if (current == mostRecentNode) {mostRecentNode = prevNode;}
                }
                
                // Case 2: Node 1 doesn't exist (Start of the list)
                else if (current.next != null && prevNode.prev == null) {
                    current.prev = null; // Sets node 3's connection to node 2 to null
                    current.next.prev = prevNode; // Sets node 4's connection to node 3 to 2
                    prevNode.prev = current; // Sets node 2's null connection to node 3
                    prevNode.next = current.next; // Sets node 2's next connection to 4
                    current.next = prevNode; // Sets node 3's connection from 4 to 3

                    if (current == mostRecentNode) {mostRecentNode = prevNode;}
                    this.node = current;
                }  
                
                // Case 3: Node 4 doesn't exist, (End of the list)
                else if (current.next == null && prevNode.prev != null) {
                    prevNode.next = null; // Set's the next connection for node 2 to null
                    current.next = prevNode; // Sets the next connection for node 3 to 2
                    current.prev = prevNode.prev; // Sets the previous connection for node 3 to node 1
                    prevNode.prev.next = current; // Sets the next connection for node 1 to node 3
                    prevNode.prev = current; // Sets the previous connection for node 2 to node 3

                    if (current == mostRecentNode) {mostRecentNode = prevNode;}
                }  
                
                // Case 4: Node 1 and 4 doesn't exist, (The list is 2 nodes long)
                else if (current.next == null && prevNode.prev == null) {
                    prevNode.next = null; 
                    prevNode.prev = current;
                    current.prev = null;
                    current.next = prevNode;

                    this.node = current;
                    
                }
            } else {
                mostRecentNode = mostRecentNode.next;
                current = mostRecentNode;
            }
        }
    }

    // Calls the actual merge sort method when it is called
    public void mergeSortDoubly() {  
        this.node = mergeSortHelper(this.node, this.length);
    }
    public void mergeSingly() {
        this.node = mergeSortSingly(this.node, this.length);
    }

    // Does merge sort without using doubly linked lists
    private PhoneNode mergeSortSingly(PhoneNode front, int length) {
        if (length <= 1) {
            return front;
        }

        int midpoint = length / 2;
        PhoneNode mid = front;
        for (int i = 0; i < midpoint -1; i++) {
            mid = mid.next;
        }

        PhoneNode half = mid.next;
        mid.next = null;

        PhoneNode nodeA = mergeSortSingly(front, midpoint);
        PhoneNode nodeB = mergeSortSingly(half, length-midpoint);

        return merge(nodeA, nodeB);
    }
    
    // Helper method to the merge sort for singly linked lists
    private PhoneNode merge(PhoneNode nodeA, PhoneNode nodeB) { 
        PhoneNode merger = new PhoneNode();
        PhoneNode navigation = merger;
        
        while (nodeA != null && nodeB != null) {
            int compareA = compareStrings(nodeA.getLastName(), nodeB.getLastName());
            int compareB = compareStrings(nodeA.getFirstName(), nodeB.getFirstName());

            if (compareA == 1 || (compareA == 2 && compareB == 1) || (compareA == 2 && compareB == 2)) {
                navigation.next = nodeA;
                nodeA = nodeA.next;
            } else {
                navigation.next = nodeB;
                nodeB = nodeB.next;
            }

            navigation = navigation.next;
        }
        if (nodeB != null) {navigation.next = nodeB;}
        else if (nodeA != null) {navigation.next = nodeA;}
        return merger.next;
    }



    //  Merge sort for doubly linked lists
    // This method is very long, but its the first time I've messed with implementing a mergeSort algorithim
    private PhoneNode mergeSortHelper(PhoneNode a, int length) {

        // Checks if the length of the node is 1, if it is then it just returns itself
        // This is because its already fully sorted
        if (length <= 1) {return a;}

        PhoneNode tempNode = a;
        int length1 = length/2;
        int length2 = length - length1;

        // Cycles through the phonenode to find the midpoint
        for (int i = 0; i < length1 - 1 && tempNode != null; i++) {
            tempNode = tempNode.next;
        }
        PhoneNode second = tempNode.next; // Creates a reference point at the second half of the linked list
        tempNode.next = null;

        // These methods call the method itself, and then sorts each part
        PhoneNode nodeC = mergeSortHelper(second, length2);
        PhoneNode nodeD = mergeSortHelper(a, length1);

        // ______________________________________________________________________ BELOW MERGES THE LIST


        PhoneNode mergedNode = new PhoneNode(); // Creates the node that is to be returned at the end
        PhoneNode navigationNode = mergedNode; // Navigation reference point to navigate the merger node

        // If either of these are null, then we can skip this and add the other chain
        while (nodeC != null && nodeD != null) {
            // Gets the values to compare the first and last names of each node
            int comparedA = compareStrings(nodeC.getLastName(), nodeD.getLastName());
            int comparedB = compareStrings(nodeC.getFirstName(), nodeD.getFirstName());

            // If A comes first, then it does this
            if (comparedA == 1 || (comparedA == 2 && comparedB == 1) || (comparedA == 2 && comparedB == 2)) {

                navigationNode.next = nodeC; // Sets the next reference in the merged list to the reference of NodeC
                nodeC.prev = navigationNode;  // Connects it back to the working part of the merged list
                nodeC = nodeC.next; // Moves the nodeC list to the next value
                
                // else if B comes first then it does this. Not exactly sure why its an else if, but I don't want to break it
            } else if (comparedA == 0 || (comparedA == 2 && comparedB == 0)) {
                navigationNode.next = nodeD; // Sets the next reference in the merged list to the reference of NodeD
                nodeD.prev = navigationNode; // Connects it back to the working part of the merged list
                nodeD = nodeD.next; // Moves the nodeC list to the next value
            }

            navigationNode = navigationNode.next; // Moves the navigation node to the next
        }


        // Adds the first chain to the list if it's not completely empty
        if (nodeC != null) {
            navigationNode.next = nodeC; // Attaches the navigation node to the first node list
            nodeC.prev = navigationNode; // Attaches the first node list to the navigation node
        } 
        else if (nodeD != null) { // Adds the second chain to the list
            navigationNode.next = nodeD; // Same thing but for the second node list
            nodeD.prev = navigationNode;
        }


        return mergedNode.next;
    }
    
    // Returns 1 if string a comes before in the alphabet. Returns 2 if they are equal. 
    // Returns 0 if b comes before in the alphabet
    private int compareStrings(String a, String b) {
        a = a.toLowerCase(); b = b.toLowerCase();
        while (true) {
            if (a.equals(b)) {
                return 2;
            }
            int hexaDecStringA = a.codePointAt(0);
            int hexaDecStringB = b.codePointAt(0);
            if (hexaDecStringA > hexaDecStringB) {
                return 0;
            } else if (hexaDecStringA < hexaDecStringB) {
                return 1;
            } 
            a = a.substring(1);
            b = b.substring(1);
        }
    }

}
