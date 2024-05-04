public class TestClass {
    public static void main(String[] args) {
        PhoneBook Sydney = new PhoneBook();
        Sydney.addToNode(0, "James", "Miller", "52 Wallaby Way", "Sydney", "1802434567");
        Sydney.addToNode(1, "Bary", "Windmill", "11 Wallaby Way", "Sydney", "2221234213");
        Sydney.addToNode(0, "Gary", "Gary", "18 Wallaby Way", "Sydney", "1234567890");
        Sydney.addToNode(3, "Elisa", "Granny", "2 Wallaby Way", "Sydney", "2147329413");
        Sydney.addToNode(3, "George", "ZDADA", "2 Wallaby Way", "Sydney", "2147329413");
        Sydney.addToNode(3, "Gregory", "BABA", "2 Wallaby Way", "Sydney", "2147329413");
        Sydney.sortNode();
        //Sydney.sortNode();
        System.out.printf("%n%n%n%n%n");
        Sydney.displayAll();
        System.out.println();
    }
}