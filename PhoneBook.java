public class PhoneBook {
    private PhoneNode node;

    public void addToNode(int index, String firstName, String lastName, String address, String city, String phoneNumber) {
        PhoneNode tempNode = node;
        if (this.node == null) {
            this.node = new PhoneNode(firstName, lastName, address, city, phoneNumber);
        } else if (index == 0) {
            tempNode = new PhoneNode(firstName, lastName, address, city, phoneNumber);
            tempNode.next = this.node; this.node.prev = tempNode;
            this.node = tempNode;
        } else {
            int counter = 1;
            while (counter < index && tempNode.next != null) {
                tempNode = tempNode.next;
                counter++;
            }
            if (counter < index) {
                PhoneNode newNode = new PhoneNode(firstName, lastName, address, city, phoneNumber);
                tempNode.next = newNode;
                newNode.prev = tempNode;
            } else {
                PhoneNode newNode = new PhoneNode(firstName, lastName, address, city, phoneNumber, tempNode.next);
                tempNode.next = newNode;
                newNode.prev = tempNode;
            }
        }



    }

    public void displayAll() {
        PhoneNode tempNode = this.node;
        while (tempNode != null) {
            System.out.println(tempNode);
            tempNode = tempNode.next;
        }
    }


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

    // Not that efficient of a sorting algorithim. 

    public void sortNode() {
        PhoneNode current = this.node.next;
        //PhoneNode mostRecentNode = current;
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
                }
                
                // Case 2: Node 1 doesn't exist (Start of the list)
                else if (current.next != null && prevNode.prev == null) {
                    current.prev = null; // Sets node 3's connection to node 2 to null
                    current.next.prev = prevNode; // Sets node 4's connection to node 3 to 2
                    prevNode.prev = current; // Sets node 2's null connection to node 3
                    prevNode.next = current.next; // Sets node 2's next connection to 4
                    current.next = prevNode; // Sets node 3's connection from 4 to 3

                    this.node = current;
                }  
                
                // Case 3: Node 4 doesn't exist, (End of the list)
                else if (current.next == null && prevNode.prev != null) {
                    prevNode.next = null; // Set's the next connection for node 2 to null
                    current.next = prevNode; // Sets the next connection for node 3 to 2
                    current.prev = prevNode.prev; // Sets the previous connection for node 3 to node 1
                    prevNode.prev.next = current; // Sets the next connection for node 1 to node 3
                    prevNode.prev = current; // Sets the previous connection for node 2 to node 3

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
                current = current.next;
            }
        }
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