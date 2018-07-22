package J20_NumericStrings;

/**
 * 面试题20：表示数值的字符串
 * <p>题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 * 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
 * “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是
 * OJ：https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&tqId=11206&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class NumericStrings {
    public static void main(String[] args) {
        new NumericStrings().isNumeric("123.45e+6".toCharArray());
    }

    public boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }
        int[] i = {0};
        boolean result = scanInteger(str, i);
        if(i[0] < str.length && str[i[0]] == '.') {
            i[0]++;
            // 采用||是因为："1.1"、"1."、".1"都是可以的
            // 此处||的顺序必须得是先扫描再加上前面的结果，反之则因为前面是真的原因，导致小数不会被扫描
            result = scanUnsignedInteger(str, i) || result;
        }
        if(i[0] < str.length && (str[i[0]] == 'e' || str[i[0]] == 'E')) {
            i[0]++;
            // E后面必须是无符号整数
            result = result && scanInteger(str, i);
        }
        return result && i[0] == str.length;
    }

    public boolean scanUnsignedInteger(char[] str, int[] i) {
        int head = i[0];
        while (i[0] < str.length && str[i[0]] >= '0' && str[i[0]] <= '9') {
            i[0]++;
        }
        if (i[0] > head) {
            return true;
        } else {
            return false;
        }
    }

    public boolean scanInteger(char[] str, int[] i) {
        int head = i[0];
        // 注意此处的||的两个条件要用括号包含起来，形成一个整体
        if (i[0] < str.length && (str[i[0]] == '+' || str[i[0]] == '-')) {
            i[0]++;
        }
        return scanUnsignedInteger(str, i);
    }
}
