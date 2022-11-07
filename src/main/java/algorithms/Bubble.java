package algorithms;

public class Bubble {

    public static void main(String[] args) {
        int[] sortArr = {12, 6, 4, 1, 15, 10};
        bubbleSort(sortArr);
        for(int i = 0; i < sortArr.length; i++){
            System.out.print(sortArr[i] + "\n");
        }
    }

    public static void bubbleSort(int[] sortArr){
        for (int i = 0; i < sortArr.length - 1; i++) {
            System.out.println("_____________________________");
            System.out.println("Iteration i = " + i);
            for(int j = 0; j < sortArr.length - i - 1; j++) {
                System.out.println("Iteration j = " + j);
                System.out.println(sortArr[j]);
                System.out.println(sortArr[j + 1]);
                if(sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
    }
}
