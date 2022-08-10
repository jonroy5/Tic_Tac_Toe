import java.util.*;

class Game {

    /*
     * Complete the 'groupSort' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void main(String[] args) {
        char[] arr = {'x', 'o'};
        solution(arr);
    }
    public static boolean winCheck(char[][] board) {
        if ((board[0][0] != '-') && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
            System.out.print(board[0][0] +  " wins");
            return true;
        }
        if ((board[0][0] != '-') && board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
            System.out.print(board[0][0] +  " wins");
            return true;
        }
        if ((board[0][0] != '-') && board[0][0] == board[1][1] && board[0][1] == board[2][2]) {
            System.out.print(board[0][0] +  " wins");
            return true;
        }
        if ((board[0][1] != '-') && board[0][1] == board[1][1] && board[0][1] == board[2][1]) {
            System.out.print(board[0][1] +  " wins");
            return true;
        }
        if ((board[0][2] != '-') && board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
            System.out.print(board[0][2] +  " wins");
            return true;
        }
        if ((board[2][0] != '-') && board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
            System.out.print(board[2][0] +  " wins");
            return true;
        }
        if ((board[0][2] != '-') && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            System.out.print(board[0][2] +  " wins");
            return true;
        }
        if ((board[1][0] != '-') && board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
            System.out.print(board[1][0] +  " wins");
            return true;
        }


        return false;
    }

    public static void solution(char[] arr) {
        char[][] board = new char[3][3];
        Set<String> set = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], '-');
        }
        boolean flag = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = random.nextInt(3);
                int column = random.nextInt(3);
                if(set.contains("i" + row + "j" + column)) {
                    while(set.contains("i" + row + "j" + column)) {
                        row = random.nextInt(3);
                        column = random.nextInt(3);
                    }
                }
                while (!set.contains("i" + row + "j" + column)) {

                    if (flag) {
                        board[row][column] = arr[0];
                        flag = false;
                    } else {
                        board[row][column] = arr[1];
                        flag = true;
                    }
                    set.add("i" + row + "j" + column);
                } if(winCheck(board)) {
                    System.out.println(" ");
                    for (int k = 0; k < 3; k++) {
                        System.out.println(Arrays.toString(board[k]));
                    }

                    return;
                }
            }
        }
        System.out.println("DRAW");
    }
}





