package AlgoPattern.SlidingWindow;

public class SubSequence {
    public static String subSequence(String str1, String str2){
        int str1Len = str1.length(), str2Len = str2.length();

        float len = Float.POSITIVE_INFINITY;

        int indx1 = 0, indx2 = 0, flag = 0, start = 0, end = 0;
        String minSubSequence = "";
        while(indx1 < str1Len){
            if(indx2 == -1){
                flag = indx2;
                indx2 = str2Len - 1;
            }
            if(str1.charAt(indx1) == str2.charAt(indx2)){
                if(flag < 0){
                    indx2 = flag;
                    flag = 0;
                }
                indx2 += 1;
                if(indx2 == str2Len){
                    start = indx1;
                    end = indx1 + 1;

                    indx2 -= 1;

                    while(indx2 >= 0){
                        if(str1.charAt(start) == str2.charAt(indx2))
                            indx2 -= 1;
                        start -= 1;
                    }
                    start += 1;
                    if(end - start < len) {
                        len = end - start;
                        minSubSequence = "";
                        for(int i = start; i < end; i++){
                            minSubSequence += String.valueOf(str1.charAt(i));
                        }
                    }
                    indx1 = start;
                    indx2 = 0;

                }
            }
            indx1 += 1;
        }
        return minSubSequence;
    }
}
