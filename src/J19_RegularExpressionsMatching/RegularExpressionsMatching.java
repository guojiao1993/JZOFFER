package J19_RegularExpressionsMatching;

/**
 * 面试题19：正则表达式匹配
 * <p>题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'
 * 表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题
 * 中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"
 * 和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
 * <p>OJ：https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c?tpId=13&tqId=11205&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class RegularExpressionsMatching {
    public boolean match(char[] str, char[] pattern) {
        if(str == null || pattern == null) {
            return false;
        }
        return matchRecusion(str, pattern, 0, 0);
    }

    public boolean matchRecusion(char[] str, char[] pattern, int i, int j) {
        int lengthI = str.length;
        int lengthJ = pattern.length;
        // 如果都是""，返回真
        if(i == lengthI && j == lengthJ) {
            return true;
        }
        // 如果字符串不为""而模式为""，返回假
        if(i != lengthI && j == lengthJ) {
            return false;
        }
        // 剩下的情况：模式不为""+(字符串为""、字符串不为"")
        // 模式为c*，c表示字符
        if(j + 1 < lengthJ && pattern[j + 1] == '*') {
            // 字符串不为""
            if(i < lengthI) {
                // 第一个字符匹配
                if(str[i] == pattern[j] || pattern[j] == '.') {
                    // 本题关键在此！！！
                    // 对于模式是诸如a*a、.*a的情况，要对*进行所有情况的考虑：
                    // 只匹配0个，只匹配1个，本次匹配1个，本次匹配0个（相当于无操作，将导致死循环，故不写）
                    // 只匹配是指a*或.*将"牺牲"，而本次匹配是指a*或.*将重复利用
                    // 不再手动去判断复杂的情况，而是交给逐个单字符的递归去判断
                    // 只匹配0个
                    return matchRecusion(str, pattern, i, j + 2)
                            // 只匹配1个
                            || matchRecusion(str, pattern, i + 1, j + 2)
                            // 本次匹配1个
                            || matchRecusion(str, pattern, i + 1, j);
                } else {
                    // 跳过模式中的c*
                    return matchRecusion(str, pattern, i, j + 2);
                }
            } else {
                // 跳过模式中的c*
                return matchRecusion(str, pattern, i, j + 2);
            }
        // 模式不为c*
        } else {
            // 字符串不为""
            if(i < lengthI) {
                if(str[i] == pattern[j] || pattern[j] == '.') {
                    return matchRecusion(str, pattern, i + 1, j + 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
