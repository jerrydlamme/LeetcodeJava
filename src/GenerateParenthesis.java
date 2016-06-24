import java.util.*;

public class GenerateParenthesis {
	
	public static void main(String[] args) {
		GenerateParenthesis gp = new GenerateParenthesis();
	
		System.out.println(gp.generateParenthesis(3));
	}
	
    public List<String> generateParenthesis(int n) {
        char[] roll = new char[2 * n];
        List<String> list = new LinkedList<String>();
        generate(list, roll, 0, 0, 0, n);
        return list;
    }
    
    public void generate(List<String> list, char[] roll, int index, int left, int right, int n) {
        if (index == 2 * n) {
            list.add(new String(roll));
            return;
        }
        
        if (left < n) {
            roll[index] = '(';
            generate(list, roll, index+1, left+1, right, n);
        }
        
        if (right < left) {
            roll[index] = ')';
            generate(list, roll, index+1, left, right+1, n);
        }
        
        return;
    }
}
