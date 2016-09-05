import java.util.*;

public class GeneralizedAbrreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> list  = new LinkedList<String>();
        if (word.length() == 0) {
            list.add("");
            return list;
        }
        
        return sub(word, 0);
    }
    
    List<String> sub(String word, int index) {
        List<String> list = new LinkedList<String>();
        
        if (index == word.length()-1) {
            list.add(1 + "");
            list.add(word.charAt(word.length() - 1) + "");
        } else {
            List<String> pre = sub(word, index + 1);
            for (String str : pre) {
                char c = str.charAt(0);
                if (c >= '1' && c <= '9') {
                    int num = 0;
                    int i = 0;
                    while (i < str.length() && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                        i++;
                    }
                    num = Integer.parseInt(str.substring(0, i));
                    num++;
                    list.add(num + str.substring(i));
                } else {
                    list.add(1 + str);
                }
                list.add(word.charAt(index) + str);
            }
        }
        
        return list;
    }
}
