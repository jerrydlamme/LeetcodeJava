
public class DecodingString {
    public String decodeString(String s) {
        int[] start = new int[1];
        String ss = "1[" + s + "]";
        char[] str = ss.toCharArray();
        
        return decode(str, start);
    }
    
    String decode(char[] str, int[] start) {
        StringBuffer buffer = new StringBuffer();
        int k = 0;
        while (str[start[0]] != '[') {
            k *= 10;
            k += Integer.valueOf(str[start[0]++] + "");
        }
        start[0]++;
        
        while (str[start[0]] != ']') {
            if ('1' <= str[start[0]] && str[start[0]] <= '9') {
                buffer.append(decode(str, start));
            } else {
                buffer.append(str[start[0]++]);   
            }
        }
        start[0]++;
        
        StringBuffer ret = new StringBuffer();
        String s = buffer.toString();
        for (int i = 0; i < k; i++) {
            ret.append(s);
        }
        
        return ret.toString();
    }
}
