
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null) return "";
        
        int[] template = new int[10];
        
        int bulls = 0;
        int cows = 0;
        
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            
            if (s == g) {
                bulls++;
            } else {
                if (template[s] < 0)  cows++;
                template[s]++;
                
                if (template[g] > 0) cows++;
                template[g]--;
            }
        }
        
        return (bulls + "A" + cows + "B");
    }
}
