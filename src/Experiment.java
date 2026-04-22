import java.util.Arrays;
public class Experiment {
    private Sorter sorter;
    private Searcher searcher;
    private int[] sizes = {10, 100, 1000};
    public Experiment() {
        sorter = new Sorter();
        searcher = new Searcher();
    }
    public long measureSortTime(int[] originalArr, String type) {
        int[] copy = Arrays.copyOf(originalArr, originalArr.length);
        long start = System.nanoTime();
        if (type.equals("basic")) sorter.basicSort(copy);
        else sorter.advancedSort(copy);
        return System.nanoTime() - start;
    }
    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        return System.nanoTime() - start;
    }
    public void runAllExperiments() {
        System.out.println("=== Sorting & Searching Performance ===");
        System.out.println("Algorithms: Bubble Sort, Quick Sort, Linear Search\n");
        System.out.printf("%-8s %-10s %-12s %-12s %-12s%n", "Size", "Type", "Bubble (ns)", "Quick (ns)", "Linear Search");
        System.out.println("-------------------------------------------------------------");
        for (int size : sizes) {
            int[] randomArr = sorter.generateRandomArray(size);
            long bubbleRandom = measureSortTime(randomArr, "basic");
            long quickRandom = measureSortTime(randomArr, "advanced");
            long searchRandom = measureSearchTime(randomArr, 5000);
            System.out.printf("%-8d %-10s %-12d %-12d %-12d%n", size, "Random", bubbleRandom, quickRandom, searchRandom);

            int[] sortedArr = Arrays.copyOf(randomArr, randomArr.length);
            sorter.advancedSort(sortedArr);

            long bubbleSorted = measureSortTime(sortedArr, "basic");
            long quickSorted = measureSortTime(sortedArr, "advanced");
            long searchSorted = measureSearchTime(sortedArr, 5000);

            System.out.printf("%-8d %-10s %-12d %-12d %-12d%n", size, "Sorted", bubbleSorted, quickSorted, searchSorted);
            System.out.println("-------------------------------------------------------------");
        }

        System.out.println("\nNote: Linear Search works on any array (no sorting needed).");
    }
}
