import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        PageReplacementAlgorytms pra = new PageReplacementAlgorytms(arr,4);
        System.out.println("Test for arr "+ Arrays.toString(arr));
        System.out.println("FIFO");
        System.out.println(pra.FIFO());
        System.out.println("OPT");
        System.out.println(pra.OPT());
        System.out.println("LRU");
        System.out.println(pra.LRU());
        System.out.println("LRUA");
        System.out.println(pra.LRU2());
        System.out.println("RAND");
        System.out.println(pra.RAND());
        Random rand = new Random();

        int n = 10000;
        int n2 = 100;
        int[] arr1 = new int[n];
        for(int i =0; i<n; i++){
            arr1[i] = rand.nextInt(5)+1;
        }
        PageReplacementAlgorytms pra1 = new PageReplacementAlgorytms(arr1,n2);
        System.out.println("Test for arr "+ Arrays.toString(arr1));
        System.out.println("FIFO");
        System.out.println(pra1.FIFO());
        System.out.println("OPT");
        System.out.println(pra1.OPT());
        System.out.println("LRU");
        System.out.println(pra1.LRU());
        System.out.println("LRUA");
        System.out.println(pra1.LRU2());
        System.out.println("RAND");
        System.out.println(pra1.RAND());


        n = 10000;
        n2 = 100;
        int[] arr2 = new int[n];
        for(int i =0; i<n; i++){
            arr2[i] = rand.nextInt(999999999)+1;
        }
        PageReplacementAlgorytms pra2 = new PageReplacementAlgorytms(arr2,n2);
        System.out.println("Test for arr 3");
        System.out.println("FIFO");
        System.out.println(pra2.FIFO());
        System.out.println("OPT");
        System.out.println(pra2.OPT());
        System.out.println("LRU");
        System.out.println(pra2.LRU());
        System.out.println("LRUA");
        System.out.println(pra2.LRU2());
        System.out.println("RAND");
        System.out.println(pra2.RAND());


        n = 1000;
        n2 = 10;
        int[] arr3 = new int[n];
        for(int i =0; i<n; i++){
            arr3[i] = rand.nextInt(50)+1;
        }
        PageReplacementAlgorytms pra3 = new PageReplacementAlgorytms(arr3,n2);
        System.out.println("Test for arr "+ Arrays.toString(arr3));
        System.out.println("FIFO");
        System.out.println(pra3.FIFO());
        System.out.println("OPT");
        System.out.println(pra3.OPT());
        System.out.println("LRU");
        System.out.println(pra3.LRU());
        System.out.println("LRUA");
        System.out.println(pra3.LRU2());
        System.out.println("RAND");
        System.out.println(pra3.RAND());


    }
}
