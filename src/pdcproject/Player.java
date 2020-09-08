/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdcproject;

/**
 *
 * @author Gerard Gomez
 */
public class Player {
    
    String playerName = "";
    int winnings = 0;
    
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public void setWinnings(int winnings) {
        this.winnings = winnings;
    }
    public String getPlayerName() {
        return playerName;
    }
    public int getWinnings() {
        return winnings;
    }
    public void Player(String name,int money) {
        this.winnings = money;
        this.playerName = name;
    }
    
}
