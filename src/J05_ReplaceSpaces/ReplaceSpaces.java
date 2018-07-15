package J05_ReplaceSpaces;

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
