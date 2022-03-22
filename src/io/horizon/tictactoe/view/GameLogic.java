package io.horizon.tictactoe.view;


public class GameLogic {
    private final int[][] gameBoard;
    private final int[] players = {0, 1};
    public int winner;
    public boolean checkDraw = false;
    private int player = 1;
    private int[] winType = {-1, -1, -1};

    GameLogic() {
        gameBoard = new int[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                gameBoard[r][c] = 0;
            }
        }
    }

    public boolean updateGameBoard(int row, int col) {
        if (gameBoard[row - 1][col - 1] == 0) {
            gameBoard[row - 1][col - 1] = player;

            return true;
        } else {
            return false;
        }
    }

    public boolean winnerCheck() {

        boolean isWinner = false;
        for (int r = 0; r < 3; r++) {
            if (gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2] && gameBoard[r][0] != 0) {
                winType = new int[]{r, 0, 1};
                isWinner = true;
            }
        }
        for (int c = 0; c < 3; c++) {
            if (gameBoard[0][c] == gameBoard[1][c] && gameBoard[2][c] == gameBoard[0][c] && gameBoard[0][c] != 0) {
                winType = new int[]{0, c, 2};
                isWinner = true;
            }
        }

        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] && gameBoard[0][0] != 0) {
            winType = new int[]{0, 2, 3};
            isWinner = true;
        }

        if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2] && gameBoard[0][2] != 0) {
            winType = new int[]{2, 2, 4};
            isWinner = true;
        }
        int boardFilled = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (gameBoard[r][c] != 0) {
                    boardFilled += 1;
                }
            }
        }

        if (isWinner) {
            winner = players[player - 1];
            return true;
        } else if (boardFilled == 9) {
            checkDraw = true;
            gameDraw();
            return false;
        } else {
            return false;
        }
    }

    public void resetGame() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                gameBoard[r][c] = 0;
            }
        }
        checkDraw = false;
        player = 1;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public boolean gameDraw() {
        return checkDraw;

    }

    public int[] getWinType() {
        return winType;
    }

    public int getWinner() {
        return winner;
    }
}
