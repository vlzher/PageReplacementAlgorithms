import java.util.*;
import java.util.stream.IntStream;

public class PageReplacementAlgorytms {
    private int[] arrayRequests;
    private int numberOfPages;

    public PageReplacementAlgorytms(int[] arrayRequests, int numberOfPages) {
        this.arrayRequests = arrayRequests;
        this.numberOfPages = numberOfPages;
    }
    private static int contains(int[] arr, int number){
        for(int i = 0 ; i<arr.length; i++){
            if(arr[i]==number){
                return i;
            }
        }
        return -1;
    }

    public int FIFO(){
        int numberOfFaults = 0;
        int[] pages = new int[numberOfPages];
        int posPage = 0;
        boolean full = false;
        int index = 0;
        i1: for(int i = 0; i< arrayRequests.length; i++){
            full = true;
            for(int j = 0; j< pages.length; j++){
                if(pages[j] == 0){
                    full = false;
                    index = j;
                    break;
                }
            }
            if(!full){
                pages[index]=arrayRequests[i];
                numberOfFaults++;
            }
            else if(contains(pages,arrayRequests[i]) != -1){

            }
            else{
                pages[posPage] = arrayRequests[i];
                posPage++;
                if(posPage>=pages.length){
                    posPage =0;
                }
                numberOfFaults++;
            }

        }
        return numberOfFaults;



    }
    private static int findIndexForOPT(int[] arrayRequests,int[] arrPages, int index){
        HashMap<Integer,Integer> map = new HashMap<>();

        int max = 0;
        int key1 = 0;
        for(int i = arrayRequests.length-1; i>index; i--){
            if(contains(arrPages,arrayRequests[i]) != -1){
                map.put(arrayRequests[i],i);
                max=i;
                key1 = arrayRequests[i];
            }
        }
        for (int i = 0; i < arrPages.length; i++) {
            if(!map.containsKey(arrPages[i])){
                map.put(arrayRequests[i], 99999999);
            }
        }
        for(int key: map.keySet()){
            if(map.get(key)>max && contains(arrPages,key)!=-1){
                max = map.get(key);
                key1 = key;
            }
        }
        int index1 = 0;
        if(max == 99999999){
            for (int i = 0; i < arrPages.length; i++) {
                if(map.containsKey(arrPages[i]) && map.get(arrPages[i]) == 99999999){
                    key1 = arrPages[i];
                    break;
                }
            }
        }

        for(int i = 0; i<arrPages.length; i++){
            if(arrPages[i] == key1){
                index1 = i;
            }
        }
        return index1;
    }
    private static int findIndexForOPT1(int[] arrayRequests,int[] arrPages, int index){
        int i = 0;
        if (index+arrPages.length<arrayRequests.length-1){
            i = index+arrPages.length;
        }
        else{
            return -1;
        }
        for(; i>index; i--){
            if(contains(arrPages,arrayRequests[i]) != -1){
                return contains(arrPages,arrayRequests[i]);
            }
        }
        return -1;
    }
    private static int findIndexForLRU(int[] arrayRequests,int[] arrPages, int index){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<index; i++){
            map.put(arrayRequests[i],i);
        }
        int min = map.get(arrayRequests[0]);
        int key1 = 0;
        for(int key : map.keySet()){
            if(map.get(key)<min && contains(arrPages,key)!=-1){
                min = map.get(key);
                key1 = key;
            }
        }
        int index1 = 0;
        for(int i = 0; i<arrPages.length; i++){
            if(arrPages[i] == key1){
                index1 = i;
            }
        }
        return index1;
    }

    public int OPT(){
        int numberOfFaults = 0;
        int[] pages = new int[numberOfPages];
        int posPage = 0;
        boolean full = false;
        int index = 0;
        i1: for(int i = 0; i< arrayRequests.length; i++){
            full = true;
            for(int j = 0; j< pages.length; j++){
                if(pages[j] == 0){
                    full = false;
                    index = j;
                    break;
                }
            }
            if(!full){
                pages[index]=arrayRequests[i];
                numberOfFaults++;
            }
            else if(contains(pages,arrayRequests[i]) != -1){

            }
            else{
                index = findIndexForOPT(arrayRequests,pages,i);
                if(index == -1){
                    pages[0] = arrayRequests[i];
                }
                else {
                    pages[index] = arrayRequests[i];
                }
                numberOfFaults++;
            }

        }
        return numberOfFaults;
    }
    public int LRU(){
        int numberOfFaults = 0;
        int[] pages = new int[numberOfPages];
        int posPage = 0;
        boolean full = false;
        int index = 0;
        i1: for(int i = 0; i< arrayRequests.length; i++){
            full = true;
            for(int j = 0; j< pages.length; j++){
                if(pages[j] == 0){
                    full = false;
                    index = j;
                    break;
                }
            }
            if(!full){
                pages[index]=arrayRequests[i];
                numberOfFaults++;
            }
            else if(contains(pages,arrayRequests[i]) != -1){

            }
            else{
                index = findIndexForLRU(arrayRequests,pages,i);
                if(index == -1){
                    pages[0] = arrayRequests[i];
                }
                else {
                    pages[index] = arrayRequests[i];
                }
                numberOfFaults++;
            }

        }
        return numberOfFaults;
    }

    public int LRU2(){
        int numberOfFaults = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] pages = new int[numberOfPages];
        int posPage = 0;
        boolean full = false;
        int index = 0;
        i1: for(int i = 0; i< arrayRequests.length; i++){
            full = true;
            for(int j = 0; j< pages.length; j++){
                if(pages[j] == 0){
                    full = false;
                    index = j;
                    break;
                }
            }
            if(!full){
                pages[index]=arrayRequests[i];
                queue.add(arrayRequests[i]);
                map.put(arrayRequests[i],1);
                numberOfFaults++;
            }
            else if(contains(pages,arrayRequests[i]) != -1){
                map.put(queue.peek(),1);
            }
            else{
                while(map.get(queue.peek()) != 0){
                    int elem = queue.poll();
                    map.put(elem,0);
                    queue.add(elem);

                }
                int key1 = queue.poll();
                queue.add(arrayRequests[i]);
                map.put(arrayRequests[i],1);
                int index1 = 0;
                for(int j = 0; j<pages.length; j++){
                    if(pages[j] == key1){
                        index1 = j;
                    }
                }
                pages[index1] = arrayRequests[i];

                numberOfFaults++;
            }

        }
        return numberOfFaults;
    }

    public void setArrayRequests(int[] arrayRequests) {
        this.arrayRequests = arrayRequests;
    }
    public int RAND(){
        int numberOfFaults = 0;
        int[] pages = new int[numberOfPages];
        Random random = new Random();
        for(int i = 0; i<arrayRequests.length; i++){
            int rand = random.nextInt(numberOfPages);
            if(pages[rand] != arrayRequests[i])
            {
                pages[rand] = arrayRequests[i];
                numberOfFaults++;
            }

        }


        return numberOfFaults;



    }

}
