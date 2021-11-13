package demoregex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class regex {
    public static void main(String[] args) {
        //邮箱的格式可分为三部分：邮箱账号 + @标识符 + 邮箱域名。关于邮箱账号可用字母、数字、减号、点、下划线命名
        //xx@126.com  sina.com@mydomain.net user@host.domainnames
        String reg = "[\\w.-]{2,20}@[a-zA-Z0-9]{2,15}[.][a-z0-9A-Z]{2,15}";
        String line1 = "xx@126.com";
        String line2 = "xx126.com";
        String line3 = "-_..344cDFG@qq.com";
        String line4 = "()*&3fa@qq.com";
        String line5 = "sina.com@mydomain.net";
        String line6 = "user@host.domainnamedawdwadaws";
        check(line1,reg);
        check(line2,reg);
        check(line3,reg);
        check(line4,reg);
        check(line5,reg);
        check(line6,reg);
    }
    public static void check(String line,String reg) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(line);
        String a = "";
        while(matcher.find()) {
            a = matcher.group();
        }
        //若输入的所有字符都被正则捕获则格式正确
        if ((a.length() == line.length())) {
            System.out.println(line+"的格式正确");
        }else{
            System.out.println(line+"的格式错误");
        }
    }
}
