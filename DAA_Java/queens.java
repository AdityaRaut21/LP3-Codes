public class queens {
    public static int SIZE=8;
    public static int[][] board=new int [SIZE][SIZE];
    public static void placeFirstQueen(int row,int col){
        board[row][col]=1;
    }
    public static boolean isSafe(int row,int col){
        //check right row
        for(int i=0;i<col;i++){
            if(board[row][i]==1){
            return false;
        }
    }
    //check upper diagonal
    for(int i=row,j=col;i>=0  && j>=0;i--,j--){
        if(board[i][j]==1){
            return false;
        }
    }
    //check lower diagonal
    for(int i=row,j=col;i<SIZE && j>=0;i++,j--){
        if(board[i][j]==1){
            return false;
        }
    }
    return true;
}
public static boolean solveQueens(int col){
    if (col >= SIZE)
    return true;
    for(int row=0;row<SIZE;row++){
    if(col==0 && board[row][col]==1){
        continue;
    }
   if( isSafe(row, col)){
        board[row][col]=1;
        if(solveQueens(col+1)){
            return true;
        }
        else{
            board[row][col]=0;
        }
        
    }
    

}
return false;
}
public static void printBoard(){
for(int row=0;row<SIZE;row++){
    for(int col=0;col<SIZE;col++){
        System.out.print(board[row][col]);
        
    }
    System.out.println();
}
}
    public static void main(String[] args) {
        placeFirstQueen(0, 0);
        if(solveQueens(1)){
            printBoard();
        }
        else{
            System.out.println("Solution does not exist");
        }
    }
}
