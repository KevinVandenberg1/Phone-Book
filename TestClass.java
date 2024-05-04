// Name: Kevin Vandenberg
// Class: CS 145
// Assignment: Lab 5 - Linked Lists
// Purpose: Create a phonebook with a linked list of various elements
// Notice: ChatGPT has been used to help debug, and optimize the merge sort
//         I initially got it working for a doubly linked list but used chatGPT to help optimize it
//         for a singly linked list, I used chatGPT to help debug and optimize


public class TestClass {
    public static void main(String[] args) {
        PhoneBook Sydney = new PhoneBook();
        Sydney.addToNode(0, "James", "Miller", "52 Wallaby Way", "Sydney", "1802434567");
        Sydney.addToNode(1, "Bary", "Windmill", "11 Wallaby Way", "Sydney", "2221234213");
        Sydney.addToNode(0, "Gary", "Gary", "18 Wallaby Way", "Sydney", "1234567890");
        Sydney.addToNode(3, "Elisa", "Granny", "2 Wallaby Way", "Sydney", "2147329413");
        Sydney.addToNode(3, "George", "ZDADA", "2 Wallaby Way", "Sydney", "2147329413");
        Sydney.addToNode(3, "Gregory", "BABA", "2 Wallaby Way", "Sydney", "2147329413");
        //Sydney.removeNode("George", "ZDADA");
        //Sydney.editValue("Gary", "Gary", "69 Wallaby Way", "address");
        Sydney.mergeSort();
        //Sydney.sortNode();
        System.out.printf("%n%n%n%n%n");
        Sydney.displayAll();
        System.out.println();
    }
}