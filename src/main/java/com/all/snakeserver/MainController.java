//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.all.snakeserver;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/snake"})
public class MainController {
    @Autowired
    Service service;

    public MainController() {
    }

    @GetMapping
    @ResponseBody
    public ArrayList<Leaderboard> getLeaderboard() {
        return this.service.getLeaderboard();
    }

    @GetMapping({"/{name}"})
    @ResponseBody
    public Leaderboard getRecordByName(@PathVariable("name") String name) {
        return this.service.getRecordByName(name);
    }

    @PostMapping({"/check"})
    @ResponseBody
    public boolean checkLogin(@RequestBody Leaderboard l) {
        return this.service.checkLogin(l.getName());
    }

    @PostMapping
    public void addUser(@RequestBody Leaderboard l) {
        this.service.addUser(l.getName());
    }

    @PutMapping
    public void updateRecord(@RequestBody Leaderboard l) {
        this.service.updateRow(l.getName(), l.getScore());
    }
}
