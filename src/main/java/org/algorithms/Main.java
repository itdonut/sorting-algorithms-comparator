package org.algorithms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author Serhiy Paranchuk
 * @project ${PROJECT_NAME}
 */
public class Main {
    private final static int SIZE = 200_000;
    private final static int MAX_NUM_OR_STR_LEN = 10_000;
    private final static String FILE = "sortLogs.txt";
    private final static Types CURRENT_DATA_TYPE = Types.INTEGER;
    private final static Random random = new Random();

    public static void main(String[] args) {
        long startTime, endTime;
        Sorting<Integer> sorting = new Sorting<>();
        Integer[] arr = new Integer[SIZE];
        fillIntArr(arr);
        Integer[] arr1 = arr.clone(), arr2 = arr.clone(), arr3 = arr.clone(), arr4 = arr.clone(), arr5 = arr.clone(), arr6 = arr.clone();

        System.out.println("Algorithm {" + Algorithms.BUBBLE_SORT + "} is running ...");
        startTime = System.currentTimeMillis();
        sorting.bubbleSort(arr);
        endTime = System.currentTimeMillis();
        System.out.println("Algorithm {" + Algorithms.BUBBLE_SORT + "} is end in " + (endTime - startTime) + "ms");
        writeSortLogsToFile(
                new SortLogs(
                    SIZE,
                    (int)(endTime - startTime),
                    MAX_NUM_OR_STR_LEN,
                    Algorithms.BUBBLE_SORT,
                    CURRENT_DATA_TYPE,
                    LocalDateTime.now()
                ),
                FILE
        );

        System.out.println("Algorithm {" + Algorithms.SELECTION_SORT + "} is running ...");
        startTime = System.currentTimeMillis();
        sorting.selectionSort(arr1);
        endTime = System.currentTimeMillis();
        System.out.println("Algorithm {" + Algorithms.SELECTION_SORT + "} is end in " + (endTime - startTime) + "ms");
        writeSortLogsToFile(
                new SortLogs(
                        SIZE,
                        (int)(endTime - startTime),
                        MAX_NUM_OR_STR_LEN,
                        Algorithms.SELECTION_SORT,
                        CURRENT_DATA_TYPE,
                        LocalDateTime.now()
                ),
                FILE
        );

        System.out.println("Algorithm {" + Algorithms.INSERTION_SORT + "} is running ...");
        startTime = System.currentTimeMillis();
        sorting.insertionSort(arr2);
        endTime = System.currentTimeMillis();
        System.out.println("Algorithm {" + Algorithms.INSERTION_SORT + "} is end in " + (endTime - startTime) + "ms");
        writeSortLogsToFile(
                new SortLogs(
                        SIZE,
                        (int)(endTime - startTime),
                        MAX_NUM_OR_STR_LEN,
                        Algorithms.INSERTION_SORT,
                        CURRENT_DATA_TYPE,
                        LocalDateTime.now()
                ),
                FILE
        );

        System.out.println("Algorithm {" + Algorithms.MERGE_SORT + "} is running ...");
        startTime = System.currentTimeMillis();
        sorting.mergeSort(arr3);
        endTime = System.currentTimeMillis();
        System.out.println("Algorithm {" + Algorithms.MERGE_SORT + "} is end in " + (endTime - startTime) + "ms");
        writeSortLogsToFile(
                new SortLogs(
                        SIZE,
                        (int)(endTime - startTime),
                        MAX_NUM_OR_STR_LEN,
                        Algorithms.MERGE_SORT,
                        CURRENT_DATA_TYPE,
                        LocalDateTime.now()
                ),
                FILE
        );

        System.out.println("Algorithm {" + Algorithms.QUICK_SORT + "} is running ...");
        startTime = System.currentTimeMillis();
        sorting.quickSort(arr4);
        endTime = System.currentTimeMillis();
        System.out.println("Algorithm {" + Algorithms.QUICK_SORT + "} is end in " + (endTime - startTime) + "ms");
        writeSortLogsToFile(
                new SortLogs(
                        SIZE,
                        (int)(endTime - startTime),
                        MAX_NUM_OR_STR_LEN,
                        Algorithms.QUICK_SORT,
                        CURRENT_DATA_TYPE,
                        LocalDateTime.now()
                ),
                FILE
        );

        System.out.println("Algorithm {" + Algorithms.HEAP_SORT + "} is running ...");
        startTime = System.currentTimeMillis();
        sorting.heapSort(arr5);
        endTime = System.currentTimeMillis();
        System.out.println("Algorithm {" + Algorithms.HEAP_SORT + "} is end in " + (endTime - startTime) + "ms");
        writeSortLogsToFile(
                new SortLogs(
                        SIZE,
                        (int)(endTime - startTime),
                        MAX_NUM_OR_STR_LEN,
                        Algorithms.HEAP_SORT,
                        CURRENT_DATA_TYPE,
                        LocalDateTime.now()
                ),
                FILE
        );

        System.out.println("Algorithm {" + Algorithms.SHELL_SORT + "} is running ...");
        startTime = System.currentTimeMillis();
        sorting.shellSort(arr6);
        endTime = System.currentTimeMillis();
        System.out.println("Algorithm {" + Algorithms.SHELL_SORT + "} is end in " + (endTime - startTime) + "ms");
        writeSortLogsToFile(
                new SortLogs(
                        SIZE,
                        (int)(endTime - startTime),
                        MAX_NUM_OR_STR_LEN,
                        Algorithms.SHELL_SORT,
                        CURRENT_DATA_TYPE,
                        LocalDateTime.now()
                ),
                FILE
        );
    }

    public static void writeSortLogsToFile(SortLogs sortLogs, String file) {
        try(FileWriter fileWriter = new FileWriter(file, true)) {
            if (new File(file).length() == 0) {
                fileWriter.write("+--------------------+--------------------+--------------------+----------+--------------------+------------------------------+\n");
                fileWriter.write(String.format("|%20s|%20s|%20s|%10s|%20s|%30s|\n", "ALGORITHM", "ELEM_COUNT", "DATA_TYPE", "MAX_ELEM", "EXEC_TIME", "DATE_TIME"));
                fileWriter.write("+--------------------+--------------------+--------------------+----------+--------------------+------------------------------+\n");
            }
            fileWriter.write(
                    String.format(
                            "|%20s|%20s|%20s|%10s|%20s|%30s|\n",
                            sortLogs.getAlgorithm(),
                            sortLogs.getElemCount(),
                            sortLogs.getDataType(),
                            sortLogs.getMaxElem(),
                            sortLogs.getExecTime() + "ms",
                            sortLogs.getLocalDateTime()
                    )
            );
            fileWriter.write("+--------------------+--------------------+--------------------+----------+--------------------+------------------------------+\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void fillIntArr(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(MAX_NUM_OR_STR_LEN); // [0 ... MAX_NUM - 1]
        }
    }
    static void fillDoubleArr(Double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextDouble(MAX_NUM_OR_STR_LEN); // [0 ... MAX_NUM - 1]
        }
    }

    static void fillFloatArr(Float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextFloat(MAX_NUM_OR_STR_LEN); // [0 ... MAX_NUM - 1]
        }
    }

    static void fillStringArr(String[] arr) {
        byte[] buf = new byte[MAX_NUM_OR_STR_LEN];
        for (int i = 0; i < arr.length; i++) {
            random.nextBytes(buf);
            arr[i] = new String(buf, StandardCharsets.UTF_8);
        }
    }
}