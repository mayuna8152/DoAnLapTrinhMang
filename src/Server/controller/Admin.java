/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.controller;

import java.io.IOException;
import server.RunServer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.db.layers.BUS.GameMatchBUS;
import server.db.layers.BUS.PlayerBUS;
import server.db.layers.DTO.GameMatch;
import server.db.layers.DTO.Player;

/**
 *
 */
public class Admin implements Runnable {

    GameMatchBUS gameMatchBus;
    PlayerBUS playerBus;

    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        String inp;

        while (!RunServer.isShutDown) {
            System.out.print("<Administrator> ");
            inp = s.nextLine();
            try {
                if (inp.equalsIgnoreCase("user-count")) {
                    System.out.println("> " + RunServer.clientManager.getSize());
                } else if (inp.equalsIgnoreCase("best-user")) {
                    showBestPlayerInfo(getBestUser());
                } else if (inp.equalsIgnoreCase("shortest-match")) {
                    showShortestMatch(getShortestMatch());
                } else if (inp.indexOf("block") == 0) {
                    System.out.println(blockUser(inp.split(" ")[1]));
                } else if (inp.indexOf("unblock") == 0) {
                    System.out.println(unblockUser(inp.split(" ")[1]));   
                } else if (inp.indexOf("log") == 0) {
                    showGameMatchDetails(inp.split(" ")[1]);
                } else if (inp.equalsIgnoreCase("room-count")) {
                    System.out.println("> " + RunServer.roomManager.getSize());
                } else if (inp.equalsIgnoreCase("shutdown")) {
                    System.out.println("shuting down...");
                    RunServer.isShutDown = true;

                    try {
                        RunServer.ss.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Thieu tham so !!!");
            }

            if (inp.equalsIgnoreCase("help")) {
                System.out.println("======================[List commands]======================\n"
                        + "user-count:            so player dang online\n"
                        + "best-user:             thong tin user dat top1\n"
                        + "shortest-match:        thong tin tran dau ngan nhat\n"
                        + "block <user-username>: block user co username là <user-username> khoi he thong\n"
                        + "unblock <user-username>: unblock user co username là <user-username> trong he thong\n"
                        + "log <match-id>:        xem thong tin tran dau co id la <match-id>\n"
                        + "room-count:            so phong dang mo\n"
                        + "shutdown:              ngung server\n"
                        + "=====================================================================");
            }
        }
    }

    // Get player with the most win count
    private Player getBestUser() {
        Player bestPlayer = null;
        playerBus = new PlayerBUS();
        int max = 0;
        for (Player p : playerBus.getList()) {
            if (p.getWinCount() > max) {
                max = p.getWinCount();
                bestPlayer = new Player(p);
            }
        }
        return bestPlayer;
    }

    private void showBestPlayerInfo(Player p) {
        System.out.println("Player with the most win count: "
                + p.getName() + " - " + p.getUserName());
        System.out.println("Win count: " + p.getWinCount());
    }

    // Get the match with the shortest play time
    public GameMatch getShortestMatch() {
        gameMatchBus = new GameMatchBUS();
        GameMatch shortestMatch = null;
        int min = gameMatchBus.getList().get(0).getTotalMove();
        for (GameMatch m : gameMatchBus.getList()) {
            if (m.getPlayTime() < min) {
                min = m.getPlayTime();
                shortestMatch = new GameMatch(m);
            }
        }
        return shortestMatch;
    }

    private void showShortestMatch(GameMatch m) {
        playerBus = new PlayerBUS();
        Player p1 = new Player(playerBus.getById(m.getPlayerID1()));
        Player p2 = new Player(playerBus.getById(m.getPlayerID2()));
        System.out.println("Match id: " + m.getId());
        System.out.println("    + Player 1: " + playerBus.getById(m.getPlayerID1()).getName());
        System.out.println("    + Player 2: " + playerBus.getById(m.getPlayerID2()).getName());
        System.out.println("    + Winner: " + playerBus.getById(m.getWinnerID()).getName());
        System.out.println("    + Play time in second: " + m.getPlayTime());
        System.out.println("    + Total move: " + m.getTotalMove());
    }

    // Block user with provided UserName
    private String blockUser(String username) {
        playerBus = new PlayerBUS();
        for (Player p : playerBus.getList()) {
            if (p.getUserName().equalsIgnoreCase(username)) {
                p.setBlocked(true);
                return playerBus.update(p) ? "Success" : "Fail";
            }
        }
        return "Cant find user with provided username!";
    }

    private String unblockUser(String username) {
        playerBus = new PlayerBUS();
        for (Player p : playerBus.getList()) {
            if (p.getUserName().equalsIgnoreCase(username)) {
                p.setBlocked(false);
                return playerBus.update(p) ? "Success" : "Fail";
            }
        }
        return "Cannot find user with the provided username!";
    }

    // Get Game match with provide id
    private void showGameMatchDetails(String id) {
        gameMatchBus = new GameMatchBUS();
        playerBus = new PlayerBUS();
        GameMatch m = gameMatchBus.getById(Integer.parseInt(id));
        System.out.println("Match id: " + m.getId());
        System.out.println("    + Player 1: " + playerBus.getById(m.getPlayerID1()).getName());
        System.out.println("    + Player 2: " + playerBus.getById(m.getPlayerID2()).getName());
        System.out.println("    + Winner: " + playerBus.getById(m.getWinnerID()).getName());
        System.out.println("    + Play time in second: " + m.getPlayTime());
        System.out.println("    + Total move: " + m.getTotalMove());
    }

    public static void main(String[] args) {
        Admin ad = new Admin();
        ad.run();
    }
}
