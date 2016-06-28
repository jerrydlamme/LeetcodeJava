
public class VerifyPreorderSerializationOfBinaryTree {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null) return false;
        if (preorder.length() == 0) return true;
        
        String[] arr = preorder.split(",");
        
        int count = 0;
        if (arr.length%2 == 0) return false;
        
        if (arr[0].equals("#")) {
            if (arr.length == 1) return true;
            return false;
        } else {
            count += 2;
        }
        
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals("#")) {
                count++;
            } else {
                count--;
                if (count == 0 && i != arr.length-1) return false; 
            }
        }
        
        if (count != 0) return false;
        return true;
    }
}
