import java.util.*;

public class EncodeAndDecodeString {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer buf = new StringBuffer();
        for (String str : strs) {
            buf.append(str.length() + " ");
            buf.append(str);
        }
        
        return buf.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new LinkedList<String>();
        int i = 0;
        
        while (i < s.length()) {
            int len = 0;
            int start = i;
            while (s.charAt(i) != ' ') {
                i++;
            }
            len = Integer.valueOf(s.substring(start, i));
            i++;
            list.add(s.substring(i, i+len));
            i += len;
        }
        
        return list;
    }
}
