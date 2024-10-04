package parallelstreams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    public static void main(String[] args) {
        System.out.println(sumSequential());
        System.out.println(sumParallel());
        System.out.println("Total available threads = " + Runtime.getRuntime().availableProcessors());

        System.out.println("Sequential processing duration: " + checkPerformance(ParallelStreamExample::sumSequential));
        System.out.println("Parallel processing duration: " + checkPerformance(ParallelStreamExample::sumParallel));
    }

    private static long checkPerformance(Supplier<Integer> method) {
        final long startTime = System.currentTimeMillis();
        for (int i = 0; i < 200; ++i) {
            method.get();
        }
        final long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    private static int sumSequential() {
        return IntStream.rangeClosed(1, 1000)
                .sum();
    }

    private static int sumParallel() {
        return IntStream.rangeClosed(1, 1000)
                .parallel()
                .sum();
    }

}
