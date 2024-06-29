package tictactoe;

import java.util.Scanner;

public class Game {
    private GameGrid gameGrid;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public Game() {
        this.gameGrid = new GameGrid(3);
        this.playerX = new Player("X");
        this.playerO = new Player("O");
        this.currentPlayer = this.playerX;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printGameGrid();
            System.out.println("Player " + currentPlayer.getSymbol() + ", enter your move (row and column):");
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            if (x < 0 || x >= gameGrid.getSize() || y < 0 || y >= gameGrid.getSize() || !gameGrid.getCell(x, y).equals(" ")) {
                System.out.println("Invalid move. Try again.");
                continue;
            }
            gameGrid.setCell(x, y, currentPlayer.getSymbol());
            if (checkWin()) {
                printGameGrid();
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                break;
            } else if (checkDraw()) {
                printGameGrid();
                System.out.println("It's a draw!");
                break;
            }
            switchPlayer();
        }
    }

    private void printGameGrid() {
        for (int i = 0; i < gameGrid.getSize(); i++) {
            for (int j = 0; j < gameGrid.getSize(); j++) {
                System.out.print(gameGrid.getCell(i, j) + " ");
            }
            System.out.println();
        }
    }

    private boolean checkWin() {
        // Check for horizontal wins
        for (int i = 0; i < gameGrid.getSize(); i++) {
            if (gameGrid.getCell(i, 0).equals(currentPlayer.getSymbol()) && gameGrid.getCell(i, 1).equals(currentPlayer.getSymbol()) && gameGrid.getCell(i, 2).equals(currentPlayer.getSymbol())) {
                return true;
            }
        }

        // Check for vertical wins
        for (int i = 0; i < gameGrid.getSize(); i++) {
            if (gameGrid.getCell(0, i).equals(currentPlayer.getSymbol()) && gameGrid.getCell(1, i).equals(currentPlayer.getSymbol()) && gameGrid.getCell(2, i).equals(currentPlayer.getSymbol())) {
                return true;
            }
        }

        // Check for diagonal wins
        if (gameGrid.getCell(0, 0).equals(currentPlayer.getSymbol()) && gameGrid.getCell(1, 1).equals(currentPlayer.getSymbol()) && gameGrid.getCell(2, 2).equals(currentPlayer.getSymbol())) {
            return true;
        }
        if (gameGrid.getCell(0, 2).equals(currentPlayer.getSymbol()) && gameGrid.getCell(1, 1).equals(currentPlayer.getSymbol()) && gameGrid.getCell(2, 0).equals(currentPlayer.getSymbol())) {
            return true;
        }

        return false;

    }

    private boolean checkDraw() {
        // Check if all cells are filled and no one has won
        for (int i = 0; i < gameGrid.getSize(); i++) {
            for (int j = 0; j < gameGrid.getSize(); j++) {
                if (gameGrid.getCell(i, j).equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer == playerX ? playerO : playerX;
    }

}