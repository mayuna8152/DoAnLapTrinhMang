/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.db.layers.DTO;

/**
 *
 */
public class Player {

    int id;
    String username;
    String password;
    String avatar;
    String name;
    String gender;
    int yearOfBirth;
    int score = 0; // gia tri mac dinh
    int matchCount = 0;
    int winCount = 0;
    int loseCount = 0;
    int currentStreak = 0; // số âm là chuỗi thua, dương là chuỗi thắng
    boolean blocked = false;

    public Player() {

    }

    public void addScore(int toAdd) {
        this.score += toAdd;
    }

    public Player(int id, String username, String password, String avatar, String name, String gender, int yearOfBirth, int score, int matchCount, int winCount, int loseCount, int currentStreak, boolean blocked) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.name = name;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.score = score;
        this.matchCount = matchCount;
        this.winCount = winCount;
        this.loseCount = loseCount;
        this.currentStreak = currentStreak;
        this.blocked = blocked;
    }

    public Player(String username, String password, String avatar, String name, String gender, int yearOfBirth) {
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.name = name;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
    }

    public Player(Player p) {
        this.id = p.id;
        this.username = p.username;
        this.password = p.password;
        this.avatar = p.avatar;
        this.name = p.name;
        this.gender = p.gender;
        this.yearOfBirth = p.yearOfBirth;
        this.score = p.score;
        this.matchCount = p.matchCount;
        this.winCount = p.winCount;
        this.loseCount = p.loseCount;
        this.currentStreak = p.currentStreak;
        this.blocked = p.blocked;
    }

    public int calculateTieCount() {
        return matchCount - winCount - loseCount;
    }

    public float calculateWinRate() {
        if (this.matchCount == 0) {
            return 0;
        }

        return (float) (100.0 * winCount / matchCount);
    }

    public String getNameId() {
        return name + " #" + id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public void setLoseCount(int loseCount) {
        this.loseCount = loseCount;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

}
