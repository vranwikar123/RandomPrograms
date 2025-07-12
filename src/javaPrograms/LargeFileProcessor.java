package javaPrograms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LargeFileProcessor {

    public static void main(String[] args) {
        String filePath = "path/to/your/large/logfile.txt";
        double threshold = 10000.0;

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            double sum = lines
                    .map(line -> parseTransactionAmount(line)) // Extract transaction amount
                    .filter(amount -> amount > threshold)     // Filter by threshold
                    .mapToDouble(Double::doubleValue)         // Convert to double for summation
                    .sum();                                   // Calculate the sum

            System.out.println("Total sum of transactions greater than 10,000: " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Double parseTransactionAmount(String line) {
        // Assuming the line format is: "transactionId,accountId,amount"
        try {
            String[] parts = line.split(",");
            return Double.parseDouble(parts[2]);
        } catch (Exception e) {
            return 0.0; // Handle malformed lines gracefully
        }
    }
}
