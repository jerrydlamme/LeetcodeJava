
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int ver, hor;
        
        ver = getLen(A, C, E, G);
        hor = getLen(B, D, F, H);
        
        return (C-A)*(D-B) + (G-E)*(H-F) - ver*hor;
    }
    
    int getLen(int a1, int a2, int b1, int b2) {
        if (a2 <= b1 || a1 >= b2) return 0;
        
        if (a1 <= b1 && b1 <= a2) {
            if (b2 >= a2) return a2 - b1;
            return b2 - b1;
        } else {
            if (b2 > a2) return a2 - a1;
            return b2 - a1;
        } 
    }
}
