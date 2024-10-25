//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.all.snakeserver;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    Repo repo;

    public Service() {
    }

    public ArrayList<Leaderboard> getLeaderboard() {
        ArrayList<Leaderboard> a = this.repo.getAll();

        for(int i = 1; i <= a.size(); ++i) {
            (a.get(i - 1)).setId(i);
        }

        return a;
    }

    public Leaderboard getRecordByName(String name) {
        return this.repo.findByName(name);
    }

    public boolean checkLogin(String name) {
        return this.repo.check(name) != null;
    }

    public void addUser(String name) {
        String var10000 = name.substring(0, 1).toUpperCase();
        name = var10000 + name.substring(1, name.length()).toLowerCase();
        if (!this.checkLogin(name)) {
            Leaderboard u = new Leaderboard();
            u.setName(name);
            u.setId(this.repo.findLast().getId() + 1);
            this.repo.save(u);
        }

    }

    public void updateRow(String name, int score) {
        Leaderboard l = this.repo.check(name);
        l.setScore(score);
        this.repo.save(l);
    }
}
