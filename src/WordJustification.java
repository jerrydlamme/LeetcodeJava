import java.util.*;

public class WordJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new LinkedList<String>();
        if (maxWidth < 1) {
            for (int i = 0; i < words.length; i++) {
                list.add(words[i]);
            }
            return list;
        }
        
        int i = 0;
        int count = 0;
        while (i < words.length) {
            int start = i;
            int gap = 1;
            int extra = 0;
            int remain = maxWidth - words[start].length();
            while (i < words.length-1 && words[i+1].length()+1 <= remain) {
                i++;
                remain -= words[i].length() + 1;
            }
            int slots = i - start;
            if (slots > 0) {
                gap += remain / slots;
                extra = remain % slots;
            }
            
            StringBuffer buffer = new StringBuffer();
            
            if (i == words.length-1 || slots == 0) {
                while (start < i) {
                    buffer.append(words[start++] + " ");
                }
                buffer.append(words[i]);
                for (int k = 0; k < remain; k++) {
                    buffer.append(" ");
                }
            } else {
                StringBuffer temp = new StringBuffer();
                for (int k = 0; k < gap; k++) {
                    temp.append(" ");
                }
                String pad = temp.toString();
                while (start < i) {
                    buffer.append(words[start++]);
                    buffer.append(pad);
                    if (extra-- > 0) buffer.append(" ");
                }
                buffer.append(words[i]);
            }
            
            i++;
            
            list.add(buffer.toString());
        }
        
        return list;
    }
}
