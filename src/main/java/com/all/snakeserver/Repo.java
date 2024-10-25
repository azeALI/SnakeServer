//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.all.snakeserver;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Repo extends JpaRepository<Leaderboard, Integer> {
    @Query(
            value = "select * from Leaderboard order by score desc",
            nativeQuery = true
    )
    ArrayList<Leaderboard> getAll();

    @Query(
            value = "select * from Leaderboard where name = :name",
            nativeQuery = true
    )
    Leaderboard check(@Param("name") String name);

    @Query(
            value = "SELECT * FROM Leaderboard ORDER BY ID DESC LIMIT 1",
            nativeQuery = true
    )
    Leaderboard findLast();

    @Query(
            value = "select * from Leaderboard  where name = :name",
            nativeQuery = true
    )
    Leaderboard findByName(@Param("name") String name);
}
