/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.game.caro;

/**
 *
 */
public class History {

    int row;
    int column;
    String playerUserName;

    public History(int row, int column, String playerUserName) {
        this.row = row;
        this.column = column;
        this.playerUserName = playerUserName;
    }

    @Override
    public String toString() {
        return row + ";" + column + ";" + playerUserName;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getPlayerUserName() {
        return playerUserName;
    }

    public void setPlayerUserName(String playerId) {
        this.playerUserName = playerId;
    }
}
