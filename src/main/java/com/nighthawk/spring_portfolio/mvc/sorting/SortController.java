package com.nighthawk.spring_portfolio.mvc.sorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nighthawk.spring_portfolio.mvc.leaderboard.Leaderboard;
import com.nighthawk.spring_portfolio.mvc.leaderboard.LeaderboardjpaRepository;
import com.nighthawk.spring_portfolio.mvc.person.PersonDetailsService;

import java.text.SimpleDateFormat;
import java.util.List;
//import java.util.Optional;

public class SortController {
    //Theo pls work on this stuff
    @Autowired
    private SortJPA repository;

    @GetMapping("/")
    public ResponseEntity<List<Sort>> getLeaderboard() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

}
