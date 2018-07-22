package J20_NumericStrings;

/**
 * 面试题20：表示数值的字符串
 * <p>题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 * 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
 * “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是
 * RE：https://github.com/CyC2018/Interview-Notebook/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md#20-%E8%A1%A8%E7%A4%BA%E6%95%B0%E5%80%BC%E7%9A%84%E5%AD%97%E7%AC%A6%E4%B8%B2
 * OJ：https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&tqId=11206&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class NumericStringsII {
    public boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }
        // 使用正则表达式进行匹配
        //[]  ： 字符集合
        //()  ： 分组，在这里是为了让表达式更清晰
        //?   ： 重复 0 ~ 1
        //+   ： 重复 1 ~ n
        //*   ： 重复 0 ~ n
        //.   ： 任意字符
        //\\. ： 转义后的.
        //\\d ： 任意数字
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
