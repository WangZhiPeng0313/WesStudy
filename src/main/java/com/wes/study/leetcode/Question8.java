package com.wes.study.leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question8 {

    public static void main(String[] args) {
        int res = solution("   -42");
        System.out.println(res);
    }

    public static int solution(String str) {
        Automaton automaton = new Automaton();
        for(char c : str.toCharArray()){
            automaton.getChar(c);
        }

        return (int) (automaton.sign * automaton.result);

    }

    public static HashMap<String, String[]> STATES = new HashMap();

    // 四种状态: 开始(空格)，标记符号(+/-)，数字(0-9)，结束(其他字符)
    // 因此就有16中状态分布
    //
    static {
        // 处于开始状态，遇到四种字符的状态变化
        STATES.put("start", new String[]{"start", "signed", "in_number", "end"});
        // 处于标记状态，遇到四种字符的状态变化
        STATES.put("signed", new String[]{"end", "end", "in_number", "end"});
        // 处于数字状态，遇到四种字符的状态变化
        STATES.put("in_number", new String[]{"end", "end", "in_number", "end"});
        // 处于结束状态，遇到四种字符的变化状态
        STATES.put("end", new String[]{"end", "end" ,"end", "end"});
    }

    public static class Automaton {
        // 自动机
        public String state = "start";
        public int sign = 1;
        public long result = 0 ;

        public void getChar(char c){
            // 根据当前状态计算该字符的下一个状态
            state = STATES.get(state)[getStateCol(c)];
            if(state.equals("signed")) {
                if(c == '-') sign = -1; else sign = 1;
            }
            else if(state.equals("in_number")) {
                result = result * 10 + (c - '0');
                result = sign == 1 ? Math.min(Integer.MAX_VALUE, result) : Math.min((long)Integer.MIN_VALUE * -1, result);
            }
        }

        public int getStateCol(char c){
            if(c == ' ') return 0;
            else if(c == '+' || c == '-') return 1;
            else if(Character.isDigit(c)) return 2;
            else return 3;
        }
    }


}
