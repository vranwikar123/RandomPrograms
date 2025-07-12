package Airbnb;

public class Test {
    public static int makeHash(String key, int MAX_SIZE) {
        long hashValue = 1; // Start with 1 for multiplication

        // Iterate through each character in the string
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);       // Get the character
            int asciiValue = (int) ch;     // Convert to ASCII value
            hashValue *= Math.pow(asciiValue, i + 1); // Raise to power and multiply
        }

        // Apply modulo operation with MAX_SIZE
        return (int) (hashValue % MAX_SIZE);
    }

    public static void main(String[] args) {
        String key = "hello";
        int MAX_SIZE = 20; // Example hash table size

        int hashIndex = makeHash(key, MAX_SIZE);
        System.out.println("Hash index:" + hashIndex);
    }
}