# Page Replacement Algorithms

This Java code provides implementations of various page replacement algorithms. These algorithms are used in operating systems to manage page faults and optimize memory usage. The implemented algorithms include:

- FIFO (First-In-First-Out)
- OPT (Optimal)
- LRU (Least Recently Used)
- LRU2 (Modified Least Recently Used)
- RAND (Random)

## Usage

1. Instantiate the `PageReplacementAlgorytms` class with the array of page requests and the number of pages in the memory.
2. Call the desired page replacement algorithm method to calculate the number of page faults.

```java
// Create an instance of PageReplacementAlgorytms
int[] arrayRequests = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
int numberOfPages = 3;
PageReplacementAlgorytms pageReplacement = new PageReplacementAlgorytms(arrayRequests, numberOfPages);

// Use the FIFO algorithm
int fifoFaults = pageReplacement.FIFO();

// Use the OPT algorithm
int optFaults = pageReplacement.OPT();

// Use the LRU algorithm
int lruFaults = pageReplacement.LRU();

// Use the LRU2 algorithm
int lru2Faults = pageReplacement.LRU2();

// Use the RAND algorithm
int randFaults = pageReplacement.RAND();
```

## Description of Algorithms

### FIFO (First-In-First-Out)

The FIFO algorithm replaces the oldest page in memory when a page fault occurs. It uses a fixed-size queue to keep track of the order in which pages were brought into memory. If the memory is full, the page at the front of the queue (the oldest page) is evicted.

```java
int fifoFaults = pageReplacement.FIFO();
```

### OPT (Optimal)

The OPT algorithm replaces the page that will not be used for the longest period of time in the future. It requires knowledge of the future page requests, which is not available in a real operating system. This implementation makes an educated guess by examining the remaining requests and evicting the page that will be referenced last.

```java
int optFaults = pageReplacement.OPT();
```

### LRU (Least Recently Used)

The LRU algorithm replaces the page that has not been referenced for the longest period of time. It keeps track of the most recent references to each page and selects the least recently used page for eviction.

```java
int lruFaults = pageReplacement.LRU();
```

### LRU2 (Modified Least Recently Used)

The LRU2 algorithm is a modified version of LRU that improves its performance by using additional data structures. It maintains a queue and a map. The queue represents the order of page references, and the map stores the presence of each page in memory. When a page fault occurs, it finds the least recently used page by checking the queue and evicts it.

```java
int lru2Faults = pageReplacement.LRU2();
```

### RAND (Random)

The RAND algorithm selects a page to evict randomly from the available pages in memory. It uses a random number generator to choose a page for replacement.

```java
int randFaults = pageReplacement.RAND();
```

## License

This code is licensed under the [MIT License](https://opensource.org/licenses/MIT). Feel free to use and modify it according to your needs.
