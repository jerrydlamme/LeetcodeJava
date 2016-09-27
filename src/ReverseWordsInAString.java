
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String str = s;
        s = s.trim();
        if (s.length() == 0) return s;
        String[] words = s.split(" +");
        int i = 0, j = words.length-1;
        while (i < j) {
            String tmp = words[i];
            words[i] = words[j];
            words[j] = tmp;
            i++;
            j--;
        }
        
        StringBuffer buffer = new StringBuffer();
        buffer.append(words[0]);
        for (int k = 1; k < words.length; k++) {
            buffer.append(" " + words[k]);
        }
        
        return buffer.toString();
    }
}
