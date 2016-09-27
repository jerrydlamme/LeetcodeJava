
public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        int i = 0, j = s.length-1;
        
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
        
        i = 0; 
        j = 0;
        while (j < s.length) {
            if (j == s.length-1 || s[j+1] == ' ') {
                int k = j;
                while (i < k) {
                    char tmp = s[i];
                    s[i] = s[k];
                    s[k] = tmp;
                    i++;
                    k--;
                }
                i = j+2;
                j = j+2;
            } else {
                j++;
            }
        }
    }
}
