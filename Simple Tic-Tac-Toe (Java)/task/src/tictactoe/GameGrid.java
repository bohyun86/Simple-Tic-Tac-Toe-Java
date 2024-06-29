package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class GameGrid {
    private List<List<String>> grid;
    private int size;

    public GameGrid(int size) {
        this.size = size;
        this.grid = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(" ");
            }
            this.grid.add(row);
        }
    }

    public List<List<String>> getGrid() {
        return this.grid;
    }

    public void setCell(int x, int y, String value) {
        this.grid.get(x).set(y, value);
    }

    public String getCell(int x, int y) {
        return this.grid.get(x).get(y);
    }

    public int getSize() {
        return this.size;
    }
}