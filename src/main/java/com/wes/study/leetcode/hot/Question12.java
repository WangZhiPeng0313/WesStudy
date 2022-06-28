package com.wes.study.leetcode.hot;

public class Question12 {


    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static String solution(int num) {
        char[] CHARS = new char[] {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int index = -1;

        String[] strs = new String[(num + "").length()];

        while(num > 0) {
            int rem = num % 10;
            ++index;
            StringBuffer sb = new StringBuffer();
            if (rem <= 3) for (int i = 0; i < rem; i++)
                sb.append(CHARS[2 * index]);
            else if (rem == 4) sb.append(CHARS[2 * index]).append(CHARS[2 * index + 1]);
            else if (rem == 5) sb.append(CHARS[2 * index + 1]);
            else if (rem >= 6 && rem <= 8) {
                sb.append(CHARS[2 * index + 1]);
                for (int i = 6; i <= rem; i++) sb.append(CHARS[2 * index]);
            }
            else if (rem == 9) sb.append(CHARS[2 * index]).append(CHARS[2 * index + 2]);

            strs[index] = sb.toString();

            num = num /10;
        }

        StringBuffer sb = new StringBuffer();
        for(int i = strs.length - 1; i >= 0; i--){
            sb.append(strs[i]);
        }

        return sb.toString();

    }
}
