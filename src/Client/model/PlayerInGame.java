/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

/**
 *
 */
public class PlayerInGame {

    String username;
    String nameId;
    String avatar;

    public PlayerInGame(String username, String nameId, String avatar) {
        this.username = username;
        this.nameId = nameId;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return nameId;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
