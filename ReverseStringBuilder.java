public class ReverseStringBuilder {
    public static String reverseString(String input) {
        // Create a StringBuilder object and append the input string
        StringBuilder sb = new StringBuilder(input);

        // Reverse the string
        sb.reverse();

        // Convert back to string and return
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        String reversed = reverseString(input);

        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }
}
