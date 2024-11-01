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
            for (int i = 1; i <= a.size(); ++i) {
                (a.get(i - 1)).setId(i);
            }
            return a;
    }

    public Leaderboard getRecordByName(String name) {
        return this.repo.check(name);
    }

    public boolean checkLogin(String name) {
        return this.repo.check(name) != null;
    }

    public void addUser(String name) {
        String f = name.substring(0, 1).toUpperCase();
        name = f + name.substring(1).toLowerCase();
        if (!this.checkLogin(name)) {
            Leaderboard u = new Leaderboard();
            u.setName(name);
            if(this.repo.findLast() != null) u.setId(this.repo.findLast().getId() + 1);
            else u.setId(1);
            this.repo.save(u);
        }

    }

    public void updateRow(String name, int score) {
        Leaderboard l = this.repo.check(name);
        l.setScore(score);
        this.repo.save(l);
    }
}
