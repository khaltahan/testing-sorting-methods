import java.text.SimpleDateFormat;
import java.util.*;

public class TestingSortingMethods {
    public static void main(String[] args) {
        // Call header method
        printHeader();

        int size = 50000;

        // Initialize main array with size 50000
        Integer[] mainArr = new Integer[size];

        // Fill array with random integers ranging from 0 to 50000
        for (int i = 0; i < mainArr.length; i++) {
            mainArr[i] = (int) (Math.random() * size);
        }

        // Backup array initialized with same size as main array
        Integer[] backupArr = new Integer[mainArr.length];

        // Copy the main array to the backup array
        System.arraycopy(mainArr, 0, backupArr, 0, size);

        // Convert main array to ArrayList
        ArrayList<Integer> newArrList = new ArrayList<Integer>(Arrays.asList(mainArr));

        // Start timer
        long startTimer = System.nanoTime();
        // Sort ArrayList
        Collections.sort(newArrList);
        // End timer
        long endTimer = System.nanoTime();
        // Calculate time
        long collectionsTimer = endTimer - startTimer;

        // Copy backup array back to main array to make sure we're sorting the same unsorted array every time
        System.arraycopy(backupArr, 0, mainArr, 0, size);

        // Call header method
        printFooter();

    }

    // Print header
    public static void printHeader() {
        System.out.println("*******************************************************");
        System.out.println("Name : Khalid Altahan," + "\nStudent Number: 251152329");
        System.out.println("Goal of this project: Implement sorting methods and \ncomparing their execution time");
        System.out.println("*******************************************************\n");
    }

    // Print footer
    public static void printFooter() {
        // Format the date output
        String datePattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        String date = simpleDateFormat.format(new Date());

        // Format the time output
        String timePattern = "HH:mm:ss";
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat(timePattern);
        String time = simpleTimeFormat.format(new Date());

        System.out.println("\n*******************************************************");
        System.out.println("This is " + time + " on " + date);
        System.out.println("Completion of Lab Assignment 2 is successful ");
        System.out.println("Goodbye! Khalid Altahan");
        System.out.println("*******************************************************");
    }
}