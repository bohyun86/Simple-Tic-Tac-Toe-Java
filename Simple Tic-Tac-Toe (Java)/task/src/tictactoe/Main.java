package tictactoe;


public class Main {
    public static void main(String[] args) {
        GameGrid gameGrid = new GameGrid(3);
        Game game = new Game();
        game.start();
    }
}
