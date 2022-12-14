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

        // Call all the sorting methods and print out the data
        // We are multiplying by 0.000001 in order to change to milliseconds
        System.out.println("Testing execution time of different sorting algorithms for sorting 50000 random numbers: ");
        System.out.printf("Collections' Sorting Time: %.2f milliseconds\n", collectionsTimer * 1E-6);
        System.out.printf("My Selection-Sort Time: %.2f milliseconds\n", selectionSort(mainArr) * 1E-6);
        System.out.printf("My Bubble-Sort Time: %.2f milliseconds\n", bubbleSort(mainArr) * 1E-6);
        System.out.printf("My Insertion-Sort Time: %.2f milliseconds\n", insertionSort(backupArr) * 1E-6);
        System.out.printf("My Merge-Sort Time: %.2f milliseconds\n", mergeSort(mainArr, mainArr.length)  * 1E-6);
        System.out.printf("My Quick-Sort Time: %.2f milliseconds\n", quickSort(mainArr, 0, mainArr.length - 1) * 1E-6);

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

    // Sort Array using Selection-Sort and return execution time
    public static <T extends Comparable <? super T>>long selectionSort (T [] a) {
        // Start timer
        long startTimer = System.nanoTime();

        // Code for Selection Sort which was derived from algorithm provided by professor
        for (int i = 0; i < a.length; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[index].compareTo(a[j]) > 0){
                    index = j;
                }
            }
            T smallerNumber = a[index];
            a[index] = a[i];
            a[i] = smallerNumber;
        }

        // End timer
        long endTimer = System.nanoTime();
        // Calculate timer
        long selectionTimer = endTimer - startTimer;

        // Return calculated time
        return selectionTimer;
    }

    // Sort Array using Bubble-Sort and return execution time
    public static < T extends Comparable <? super T >> long bubbleSort(T[] a) {
        // Start timer
        long startTimer = System.nanoTime();

        // Code for Bubble Sort which was derived from algorithm provided by professor
        for (int i = 1; i < a.length; i++) {
            for(int j = 0; j < a.length - 1; j++) {
                if(a[j].compareTo(a[j + 1]) > 0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        // End timer
        long endTimer = System.nanoTime();
        // Calculate timer
        long bubbleTimer = endTimer - startTimer;

        // Return calculated time
        return bubbleTimer;
    }

    // Sort Array using Insertion-Sort and return execution time
    public static < T extends Comparable <? super T >> long insertionSort(T[] a) {
        // Start timer
        long startTimer = System.nanoTime();

        // Code for Insertion Sort which was derived from algorithm provided by professor
        T temp;
        T key;
        for(int i = 1 ; i < a.length; i++){
            key = a[i];
            int j = i - 1;
            while(j >= 0 && key.compareTo(a[j]) < 0) {
                temp = a[j + 1];
                a[j+1] = a[j];
                a[j] = temp;
                j--;
            }
        }

        // End timer
        long endTimer = System.nanoTime();
        // Calculate timer
        long insertionTimer = endTimer - startTimer;

        // Return calculated timer
        return insertionTimer;
    }

    // Sort Array using Merge-Sort and return execution time
    public static <T extends Comparable<? super T>> long mergeSort(T[] s, int n) {
        // Start timer
        long startTimer = System.nanoTime();

        // Code for Merge Sort which was derived from algorithm provided by professor

        // Array already sorted
        if (n < 2) {
            // End timer
            long endTimer = System.nanoTime();
            long quickSortTimer = endTimer - startTimer;

            // Return calculated time
            return quickSortTimer;
        }
        int mid = n / 2;
        // Copies the specified range of the specified array into a new array
        T[] l = Arrays.copyOfRange(s, 0, mid);
        T[] r = Arrays.copyOfRange(s, mid, n);

        // Recursive calls
        mergeSort(l, l.length);
        mergeSort(r, r.length);

        // Merge sorted halves back into original
        int i = 0, j = 0;
        while (i + j < s.length) {
            if (j == r.length || (i < l.length && l[i].compareTo(r[j]) < 0)) {
                s[i + j] = l[i++];
            }
            else {
                s[i + j] = r[j++];
            }
        }

        // End timer and return calculated time
        return System.nanoTime() - startTimer;
    }

    // Sort Array using Quick-Sort and return execution time
    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b) {
        // Start timer
        long startTimer = System.nanoTime();

        // Array already sorted
        if (a >= b){
            return (System.nanoTime() - startTimer);//how long it took
        }

        // Declaring pivot and pointers that will surround it
        int leftPointer = a;
        int rightPointer = b;
        T pivot = s[(a + b)/2];
        T temp;

        // Scan until leftPointer is smaller than or equal to rightPointer
        while (leftPointer <= rightPointer) {
            while(s[leftPointer].compareTo(pivot) < 0) {
                leftPointer++;
            }
            while(s[rightPointer].compareTo(pivot) > 0) {
                rightPointer--;
            }
            // If pointer do not intersect, swap elements and shrink the pointer range
            if (leftPointer <= rightPointer){
                if (leftPointer != rightPointer) {
                    // Swapping elements
                    temp = s[leftPointer];
                    s[leftPointer] = s[rightPointer];
                    s[rightPointer] = temp;
                }
                // Shrink range
                leftPointer++;
                rightPointer--;
            }
        }
        //sort the segments recursively, until the whole array is sorted:
        if(a < rightPointer){
            quickSort(s,a,rightPointer);
        }
        if(leftPointer < b){
            quickSort(s, leftPointer, b);
        }

        return (System.nanoTime() - startTimer);
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