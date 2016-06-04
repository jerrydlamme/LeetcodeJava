
public class ReverseString {
    public String reverseString(String s) {
        if (s == null || s.length() < 2) return s;
        char tmp;
        
        char[] arr = s.toCharArray();
        
        for(int i=0, j=s.length()-1; i < j; i++, j--) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        
        return new String(arr);
    }
}
