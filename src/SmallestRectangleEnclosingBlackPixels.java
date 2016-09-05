
public class SmallestRectangleEnclosingBlackPixels {
    
    int left, right, top, bot;
    
    public int minArea(char[][] image, int x, int y) {
        if (image.length == 0) return 0;
        
        top = x;
        bot = x;
        left = y;
        right = y;
        
        rec(image, x, y);
        
        return (bot - top + 1) * (right - left + 1);
    }
    
    void rec(char[][] image, int x, int y) {
        image[x][y] = '2';
        
        if (x-1 >= 0 && image[x-1][y] == '1') {
            top = Math.min(top, x-1);
            System.out.println("top: " + top);
            rec(image, x-1, y);
        }
        
        if (x+1 < image.length && image[x+1][y] == '1') {
            bot = Math.max(bot, x+1);
            System.out.println("bot: " + bot);
            rec(image, x+1, y);
        }
        
        if (y-1 >= 0 && image[x][y-1] == '1') {
            left = Math.min(y-1, left);
            System.out.println("left: " + left);
            rec(image, x, y-1);
        }
        
        if (y+1 < image[0].length && image[x][y+1] == '1') {
            right = Math.max(y+1, right);
            System.out.println("right: " + right);
            rec(image, x, y+1);
        }
    }
    
    public static void main(String[] args) {
    }
}
