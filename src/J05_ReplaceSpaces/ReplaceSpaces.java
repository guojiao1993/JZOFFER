package J05_ReplaceSpaces;

/**
 * 面试题5：替换空格
 * <p>题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
 * 则输出“We%20are%20happy.”。
 */
public class ReplaceSpaces {

    public static String replaceSpace(StringBuffer str) {
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == ' ') {
                str.deleteCharAt(i);
                str.insert(i, "%20");
                i += 3;
            } else {
                i++;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We are happy");
        System.out.println(replaceSpace(sb));
    }

}
