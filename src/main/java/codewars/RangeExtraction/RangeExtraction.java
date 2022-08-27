package codewars.RangeExtraction;

import static org.junit.Assert.assertEquals;

public class RangeExtraction {
    public static void main(String[] args) {
        assertEquals("-6,-3-1,3-5,7-11,14,16-20", RangeExtraction.rangeExtraction(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,14,14,16,17,18,19,20}));
        assertEquals("-6,-3-1,3-5,7-11,14,16,18,19", RangeExtraction.rangeExtraction(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,14,14,16,18,18,19}));
        assertEquals("-3--1,2,10,15,16,18-20", RangeExtraction.rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20}));

    }

    public static String rangeExtraction(int[] arr) {
        int previous = arr[0];
        StringBuilder sb = new StringBuilder(Integer.toString(previous));
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != previous+1) {
                if (count > 1) {
                    sb.append("-").append(arr[i-1]);
                } else if (count == 1) {
                    sb.append(",").append(arr[i-1]);
                }
                if (arr[i] != previous) {
                    sb.append(",").append(arr[i]);
                }
                count = 0;
            } else {
                count = count + 1;
                if (i+1 == arr.length) {
                    if (count > 1) {
                        sb.append("-");
                    } else if (count == 1) {
                        sb.append(",");
                        if (arr[i] == previous) {
                            sb.append(arr[i - 1]).append(",");
                        }
                    } else {
                        sb.append(",");
                    }
                    sb.append(arr[i]);
                }
            }
            previous = arr[i];
        }
        return sb.toString();
    }
}
