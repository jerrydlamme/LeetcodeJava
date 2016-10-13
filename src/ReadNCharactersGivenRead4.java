
public class ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        
        int base = n / 4;
        int rem = n % 4;
        int num = 0;
        char[] tmp = new char[4];
        int k = 0;
        
        for (int i = 0; i < base; i++) {
            k = read4(tmp);
            for (int j = 0; j < k; j++) {
                buf[num++] = tmp[j];   
            }
            if (k < 4) return num;
        }
        
        if (rem == 0) return num;
        k = read4(tmp);
        
        for (int j = 0; j < Math.min(k, rem); j++) {
            buf[num++] = tmp[j];
        }
        
        return num;
    }
        
        
        
        
    
    int read4(char[] buf) {
    	return 0;
    }
}
