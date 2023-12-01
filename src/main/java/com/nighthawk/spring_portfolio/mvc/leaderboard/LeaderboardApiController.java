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

    @GetMapping("/timefetch/{sortName}")
    public double getTime(@PathVariable String sortName) {
        // Find the leaderboard by sortName
        Leaderboard existingLeaderboard = repository.findBySortName(sortName);
        double sortTime = existingLeaderboard.getTime();
        return(sortTime);
    }

    @PostMapping("/create")
    public ResponseEntity<Leaderboard> createleaderboard(@RequestBody Leaderboard leaderboard) {
        Leaderboard savedLeaderboard = repository.save(leaderboard);
        return new ResponseEntity<>(savedLeaderboard, HttpStatus.CREATED);
    }
    @PostMapping("/updatetime/{sortName}")
    public ResponseEntity<Leaderboard> updatetime(@PathVariable String sortName, @RequestBody Leaderboard leaderboard) {
        // Find the leaderboard by sortName
        Leaderboard existingLeaderboard = repository.findBySortName(sortName);

        // Check if the leaderboard with the given sortName exists
        if (existingLeaderboard == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 Not Found if not exists
        }
        double newTime = leaderboard.getTime();
        // Update the time of the existing leaderboard
        existingLeaderboard.setTime(newTime);
        // Save the updated leaderboard
        Leaderboard savedLeaderboard = repository.save(existingLeaderboard);

        return new ResponseEntity<>(savedLeaderboard, HttpStatus.OK);
    }

    @PostMapping("/updateterms/{sortName}")
    public ResponseEntity<Leaderboard> updateterms(@PathVariable String sortName, @RequestBody Leaderboard leaderboard) {
        // Find the leaderboard by sortName
        Leaderboard existingLeaderboard = repository.findBySortName(sortName);

        // Check if the leaderboard with the given sortName exists
        if (existingLeaderboard == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 Not Found if not exists
        }
        int newTerms = leaderboard.getTerms();
        // Update the time of the existing leaderboard
        existingLeaderboard.setTerms(newTerms);
        // Save the updated leaderboard
        Leaderboard savedLeaderboard = repository.save(existingLeaderboard);

        return new ResponseEntity<>(savedLeaderboard, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{sortName}")
    public ResponseEntity<Void> deleteLeaderboard(@PathVariable String sortName) {
        Leaderboard existingLeaderboard = repository.findBySortName(sortName);
        repository.delete(existingLeaderboard); 
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
 
