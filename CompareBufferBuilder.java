public class CompareBufferBuilder {
    public static void comparePerformance(int iterations) {
        String text = "Hello";

        // Measure time for StringBuffer
        StringBuffer buffer = new StringBuffer();
        long startTimeBuffer = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            buffer.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long bufferTime = endTimeBuffer - startTimeBuffer;
        System.out.println("Time taken by StringBuffer: " + bufferTime / 1_000_000 + " ms");

        // Measure time for StringBuilder
        StringBuilder builder = new StringBuilder();
        long startTimeBuilder = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            builder.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long builderTime = endTimeBuilder - startTimeBuilder;
        System.out.println("Time taken by StringBuilder: " + builderTime / 1_000_000 + " ms");

        // Compare the results
        if (bufferTime > builderTime) {
            System.out.println("StringBuilder is faster by " + (bufferTime - builderTime) / 1_000_000 + " ms.");
        } else {
            System.out.println("StringBuffer is faster by " + (builderTime - bufferTime) / 1_000_000 + " ms.");
        }
    }

    public static void main(String[] args) {
        int iterations = 1_000_000; // 1 million iterations
        comparePerformance(iterations);
    }
}
