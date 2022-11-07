//package Yandex;
//
//public class Range {
//
//
//
//    public String getRange(int[] ints) {
//
//        //check size
//        if (ints.length == 0) return "";
//        if (ints.length == 1) return "" + ints[0];
//
//        //sorting // [1, 2, 4]
//
//        quickSort(ints);
//
//        StringBuilder sb = new StringBuilder();
//        int left = [0];
//        int right = [0];
//
//        String comma = ",";
//
//        for (int cur = 1; cur < ints.length; cur++) {
//
//            if (ints[cur] > right + 1){
//                if (left == right) {
//                    sb.add("" + left);
//                } else {
//                    sb.add(left + "-" + right);
//                }
//                sb.add(comma);
//
//                left = ints[cur];
//                right = ints[cur];
//
//                if (cur == ints.length-1) {
//                    sb.add("" + ints[cur]);
//                }
//
//            } else {
//                right = ints[cur];
//                if (cur == ints.length-1) {
//                    sb.add(left + "-" + right);
//                }
//            }
//        }
//
//        return sb.toString();
//
//    }
//}
