package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean result = false;
        int coincidenceDiagonal = 0;
        int coincidenceDiagonal2 = 0;
        for (int indexX = 0; indexX != this.table.length; indexX++) {
            int coincidenceHorizon = 0;
            int coincidenceVertical = 0;
            for (int indexY = 0; indexY != this.table.length; indexY++) {
                if (this.table[indexX][indexY].hasMarkX()) {
                    coincidenceHorizon++;
                }
                if (this.table[indexY][indexX].hasMarkX()) {
                    coincidenceVertical++;
                }
            }
            if (this.table[indexX][this.table.length - 1 - indexX].hasMarkX()) {
                coincidenceDiagonal2++;
            }
            if (this.table[indexX][indexX].hasMarkX()) {
                    coincidenceDiagonal++;
            }
            if (coincidenceHorizon == 3 || coincidenceVertical == 3 || coincidenceDiagonal == 3 || coincidenceDiagonal2 == 3) {
                result = true;
            }
        }
        return result;
    }

    public boolean isWinnerO() {
        boolean result = false;
        int coincidenceDiagonal = 0;
        int coincidenceDiagonal2 = 0;
        for (int indexX = 0; indexX != this.table.length; indexX++) {
            int coincidenceHorizon = 0;
            int coincidenceVertical = 0;
            for (int indexY = 0; indexY != this.table.length; indexY++) {
                if (this.table[indexX][indexY].hasMarkO()) {
                    coincidenceHorizon++;
                }
                if (this.table[indexY][indexX].hasMarkO()) {
                    coincidenceVertical++;
                }
            }
            if (this.table[indexX][this.table.length - 1 - indexX].hasMarkO()) {
                coincidenceDiagonal2++;
            }
            if (this.table[indexX][indexX].hasMarkO()) {
                coincidenceDiagonal++;
            }
            if (coincidenceHorizon == 3 || coincidenceVertical == 3 || coincidenceDiagonal == 3 || coincidenceDiagonal2 == 3) {
                result = true;
            }
        }
        return result;
    }

    public boolean hasGap() {
        boolean result = false;
        for (int indexX = 0; indexX != this.table.length; indexX++) {
            for (int indexY = 0; indexY != this.table.length; indexY++) {
                if (!this.table[indexX][indexY].hasMarkO() && !this.table[indexX][indexY].hasMarkX()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

//
}