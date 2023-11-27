package com.nighthawk.spring_portfolio.mvc.leaderboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nighthawk.spring_portfolio.mvc.person.PersonDetailsService;

import java.text.SimpleDateFormat;
import java.util.List;
//import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/leaderboard")  // all requests in file begin with this URI
public class LeaderboardApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily for Database CRUD operations
    @Autowired
    private LeaderboardjpaRepository repository;
    

    /* GET 
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<Leaderboard>> getLeaderboard() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    // @PostMapping( "/post")
    // public ResponseEntity<Object> postPerson(@RequestParam("sortName") String sort_name,
    //                                          @RequestParam("terms") String terms,
    //                                          @RequestParam("time") String time) {
    //     Leaderboard leaderboard = new leaderboard(sort_name, terms, time);
    //     leaderboardDetailsService.save(leaderboard);
    //     return new ResponseEntity<>("created successfully", HttpStatus.CREATED);
    // }


    @PostMapping("/create")
    public ResponseEntity<Leaderboard> createleaderboard(@RequestBody Leaderboard leaderboard) {
        Leaderboard savedLeaderboard = repository.save(leaderboard);
        return new ResponseEntity<>(savedLeaderboard, HttpStatus.CREATED);
    }
 }
