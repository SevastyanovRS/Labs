package algorithms;

import java.util.Arrays;

/**
 * Быстрая сортировка, также известная как Quick Sort или сортировка Хоара, является одним их самых эффективных алгоритмов. Она включает в себя три этапа:
 * Из массива выбирается опорный элемент, чаще всего посередине массива.
 * Другие элементы массива распределяются таким образом, чтобы меньшие размещались до него, а большие — после.
 * Далее первые шаги рекурсивно применяются к подмассивам, которые разделились опорным элементом на две части — слева и справа от него.
 */
public class Quick {

    public static void main(String[] args) {
        int[] sortArr = {12, 6, 4, 1, 15, 10};
        quickSort(sortArr, 0, sortArr.length - 1);

        System.out.println(Arrays.toString(sortArr));
        for(int i = 0; i < sortArr.length; i++){
            System.out.print(sortArr[i] + "\n");
        }
    }
    public static void quickSort(int[] sortArr, int low, int high) {
        //завершить,если массив пуст или уже нечего делить
        if (sortArr.length == 0 || low >= high) return;

        //выбираем опорный элемент
        int middle = low + (high - low) / 2;
        int border = sortArr[middle];

        System.out.println(middle);
        System.out.println(border);
        System.out.println(Arrays.toString(sortArr));


        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            while (sortArr[i] < border) i++;
            while (sortArr[j] > border) j--;
            if (i <= j) {
                int swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }

        System.out.println(Arrays.toString(sortArr));

        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(sortArr, low, j);
        if (high > i) quickSort(sortArr, i, high);
    }
}
