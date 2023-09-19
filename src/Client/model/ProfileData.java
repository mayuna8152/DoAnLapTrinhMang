/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

/**
 *
 */
public class ProfileData {

    int id;
    String username = "#"; // cài giá trị mặc định
    String name = "#";
    String avatar = "icons8_circled_user_male_skin_type_7_96px.png";
    String gender = "Nam";
    int yearOfBirth = 1999;

    int score = 0;
    int matchCount = 0;
    int winCount = 0;
    int tieCount = 0;
    int loseCount = 0;
    int currentStreak = 0;
    float winRate = 0;

    public ProfileData() {
    }

    public ProfileData(int id, String username, String name, String avatar, String gender, int yearOfBirth, int score, int matchCount, int winCount, int tieCount, int loseCount, int currentStreak, float winRate) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.avatar = avatar;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.score = score;
        this.matchCount = matchCount;
        this.winCount = winCount;
        this.tieCount = tieCount;
        this.loseCount = loseCount;
        this.currentStreak = currentStreak;
        this.winRate = winRate;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public int getTieCount() {
        return tieCount;
    }

    public void setTieCount(int tieCount) {
        this.tieCount = tieCount;
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

    public float getWinRate() {
        return winRate;
    }

    public void setWinRate(float winRate) {
        this.winRate = winRate;
    }

}
