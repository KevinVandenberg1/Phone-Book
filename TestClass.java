// Name: Kevin Vandenberg
// Class: CS 145
// Assignment: Lab 5 - Linked Lists
// Purpose: Create a phonebook with a linked list of various elements
// Notice: ChatGPT has been used to help debug, and optimize the merge sort
//         I initially got it working for a doubly linked list but used chatGPT to help optimize it
//         for a singly linked list, I used chatGPT to help debug and optimize

// For extra credit:
// In the class PhoneBook.java, I have created three different sorting algorithims.
// This takes place from lines 96-228. The one that I ended up with in the end is on lines 180-223
// I've also turned my Linked List into a doubly linked list instead of a singly linked list.
// You can see this in the PhoneNode file on line 9, where I have a connection to the previous node in the linked list

public class TestClass {
    public static void main(String[] args) {
        PhoneBook Sydney = new PhoneBook();
        Sydney.addToNode(0, "James", "Miller", "52 Wallaby Way", "Sydney", "1802434567");
        Sydney.addToNode(1, "Bary", "Windmill", "11 Wallaby Way", "Sydney", "2221234213");
        Sydney.addToNode(0, "Gary", "Gary", "18 Wallaby Way", "Sydney", "1234567890");
        Sydney.addToNode("Elisa", "Granny", "2 Wallaby Way", "Sydney", "2147329413");
        Sydney.addToNode("George", "ZDADA", "2 Wallaby Way", "Sydney", "2147329413");
        Sydney.addToNode("Gregory", "BABA", "2 Wallaby Way", "Sydney", "2147329413");
        //Sydney.removeNode("George", "ZDADA");
        //Sydney.editValue("Gary", "Gary", "69 Wallaby Way", "address");
        Sydney.mergeSingly();
        //Sydney.sortNode();
            System.out.printf("%n%n%n%n%n");
        Sydney.displayAll();
        System.out.println();
    }
}