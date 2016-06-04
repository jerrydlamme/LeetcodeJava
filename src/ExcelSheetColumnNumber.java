
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        char root = 'A' - 1;
        int base = 1;
        int num = 0;
        
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i > -1; i--) {
            num += base * (arr[i] - root);
            base *= 26;
        }
        
        return num;
    }
}
