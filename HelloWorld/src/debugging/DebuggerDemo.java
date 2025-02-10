package debugging;

public class DebuggerDemo {
    public static void main(String[] args) {
        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
        while (sb.length()< 10){
            utils.addChar(sb, 'a');
        }
        System.out.println(sb);
        String str = "abcdefg";
        String result = utils.upperANdPreFix(utils.addSuffix(str));

    }
}
