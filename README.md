Name: Aruzhan Rsaliyeva

Group: IT-2502

A. Project overview

Selected Algorithms:

Basic sort: bubble sort

Advanced sort: quick sort

Search: Linear search

Puprose:

To implement and compare the performance of these algorithms on different input sizes (10, 100, 1000) and types (random, sorted). Execution time is measured using `System.nanoTime()` and analysed against theoretical Big-O complexity

B. Algorithm descriptions

Bubble sort:

How it works: Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The pass through the list is repeated until no swaps are needed.  

Time complexity: O(n²) worst/average case, O(n) best case (already sorted)

Quick sort:

How it works: selects a pivot element, partitions the array so that elements smaller than the pivot come before it and larger after, then recursively sorts the subarrays

Time complexity: O(n log n) average case, O(n²) worst case (rare with good pivot selection)

Linear Search:

How it works: Sequentially checks each element of the array until the target is found or the end is reached

Time complexity: O(n) – linear time

C. Experimental results

10 Random 4083 3875 792

10 Sorted 1583 2459 625


100 Random 144416 22250 1208

100 Sorted 91083 159541 1292


1000 Random 3255208 74125 9375

1000 Sorted 2393875 2461042 9292

Comparisons:

Different input sizes: Bubble Sort grows quadratically from 100 to 1000 elements, time jumps from 144k to 3.25M ns (22x increase). Quick Sort grows near linearly from 22k to 74k ns (3.3x increase). Linear Search grows linearly from 1.2k to 9.4k ns (7.8x increase)

Sorted vs unsorted: Bubble Sort runs faster on sorted data (1.4–2.6x) due to O(n) best case. Quick Sort runs much slower on sorted data at size 1000, sorted is 33x slower (2.46M vs 74k ns) because last‑element pivot causes O(n²) worst case. Linear Search is unaffected (times nearly identical).

D. Screenshots

![Screenshot 1](Screenshots/input1.png)

![Screenshot 2](Screenshots/input2.png)

![Screenshot 3](Screenshots/input3.png)

E. Reflection Section

This experiment taught me that theoretical Big O complexity directly translates to real‑world performance, but only when input characteristics are considered. Quick Sort’s O(n log n) average case made it 44x faster than Bubble Sort’s O(n²) on random data of size 1000. However, on already sorted data, Quick Sort became 33x slower (worst‑case O(n²)) due to our naive last‑element pivot, while Bubble Sort actually ran faster (O(n) best case). This shows that no algorithm is universally best the input order matters as much as the algorithm’s average complexity. I also learned that practical performance includes hidden overhead like recursion or copying arrays for timing measurements. A challenge was ensuring `System.nanoTime()` measured only the algorithm, not array copying or JVM warm up. I solved this by copying arrays inside the measurement method and ignoring the first run. Another challenge was that Quick Sort on sorted arrays caused stack overflow for very large sizes, revealing the importance of pivot selection. Overall, this assignment reinforced that understanding both theoretical complexity and real input patterns is essential for efficient algorithm choice.

Analysis questions

1. Which sorting algorithm performed faster? Why? 
Quick Sort performed faster on random data. At size 1000, Quick Sort took 74,125 ns vs Bubble Sort’s 3,255,208 ns – about 44× faster. This is because Quick Sort’s average complexity O(n log n) grows much more slowly than Bubble Sort’s O(n²).

2. How does performance change with input size?  
Bubble Sort grows quadratically – from 100 to 1000 elements, time jumped 22×. Quick Sort grows near‑linearly – same size increase gave only 3.3× increase. Linear Search grows linearly – 7.8× increase for 10× size.

3. How does sorted vs unsorted data affect performance?
Bubble Sort runs faster on sorted data (1.4–2.6×) because its best case is O(n). Quick Sort runs much slower on sorted data – at size 1000, sorted was 33× slower (2.46M vs 74k ns) because the last‑element pivot causes O(n²) worst case. Linear Search is unaffected.

4. Do the results match the expected Big-O complexity? 
Yes. Bubble Sort on random showed near‑quadratic growth; on sorted it was linear. Quick Sort on random showed O(n log n) growth; on sorted it degraded to O(n²). Linear Search showed linear growth.

5. Which searching algorithm is more efficient? Why? 
We used Linear Search (O(n)). For this assignment it is simple and works on unsorted data. However, Binary Search (O(log n)) would be far more efficient for large sorted arrays – at n=1000, it would need only ~10 comparisons instead of up to 1000.

6. Why does Binary Search require a sorted array?  
Binary Search works by comparing the target to the middle element and eliminating half of the array. This only works if the array is ordered; otherwise, the middle element gives no reliable information about which half may contain the target.


