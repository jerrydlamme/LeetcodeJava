
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) search(rooms, i, j);
            }
        }
    }
    
    void search(int[][] rooms, int i, int j) {
        
        if (i+1 < rooms.length && rooms[i+1][j] > rooms[i][j]+1) {
            rooms[i+1][j] = rooms[i][j]+1;
            search(rooms, i+1, j);
        } 
        
        if (i-1 >= 0 && rooms[i-1][j] > rooms[i][j]+1) {
            rooms[i-1][j] = rooms[i][j]+1;
            search(rooms, i-1, j);
        } 
        
        if (j+1 < rooms[0].length && rooms[i][j+1] > rooms[i][j]+1) {
            rooms[i][j+1] = rooms[i][j]+1;
            search(rooms, i, j+1);
        } 
        
        if (j-1 >= 0 && rooms[i][j-1] > rooms[i][j]+1) {
            rooms[i][j-1] = rooms[i][j]+1;
            search(rooms, i, j-1);
        } 
    }
}
