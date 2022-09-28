import java.text.SimpleDateFormat;
import java.util.*;

public class TestingSortingMethods {
    public static void main(String[] args) {
        // Call header method
        printHeader();

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