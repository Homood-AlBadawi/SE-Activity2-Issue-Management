public class BuggyCodeExample {

    // 1. Method to find the maximum number in an array
    public static int findMax(int[] numbers) {
        int max = 0; // BUG: Should initialize with the first element (numbers[0]) to handle negative numbers
        for (int i = 1; i < numbers.length; i++) { // DEFECT: Starts from 1 instead of 0
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    // 2. Method to print the elements of an array
    public static void printArray(int[] arr) {
        for (int i = 0; i <= arr.length; i++) { // BUG: Should use '<' instead of '<=' to prevent ArrayIndexOutOfBoundsException
            System.out.println(arr[i]);
        }
    }

    // 3. Method to calculate the average of an array
    public static double calculateAverage(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum / numbers.length; // DEFECT: Integer division; should cast 'sum' or 'numbers.length' to 'double'
    }

    // 4. Main method to test the above methods
    public static void main(String[] args) {
        int[] numbers = {1, -2, 3, 4, -5};

        // Testing findMax method
        int max = findMax(numbers);
        System.out.println("Max: " + max); // Expected output: 4, but may be incorrect due to bugs

        // Testing printArray method
        printArray(numbers); // Expected output: Array elements, but may throw an exception

        // Testing calculateAverage method
        double average = calculateAverage(numbers);
        System.out.println("Average: " + average); // Expected output: The correct average, but may be incorrect due to integer division
    }
}
