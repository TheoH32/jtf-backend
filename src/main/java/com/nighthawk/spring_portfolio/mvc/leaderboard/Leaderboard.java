package com.nighthawk.spring_portfolio.mvc.leaderboard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.data.repository.CrudRepository;

import jakarta.persistence.*;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@NoArgsConstructor
@AllArgsConstructor
@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
public class Leaderboard {
    public interface LeaderboardRepository extends CrudRepository<Leaderboard, Long> {
}
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String sortName;

    private int terms;
    
    private double time;

public Leaderboard(String sortName, int terms, double time) {
        this.sortName = sortName;
        this.terms = terms;
        this.time = time;
    }


     // Autowire the repository
    @Autowired
    private static LeaderboardRepository leaderboardRepository;

    public static Leaderboard[] init(LeaderboardRepository leaderboardRepository) {

        Leaderboard sort1 = new Leaderboard("bubble", 1000000, 1200);

        leaderboardRepository.save(sort1);
        Leaderboard leaderboard[] = {sort1};
        return(leaderboard);

    };
    public static void main(String[] args) {
        // obtain Person from initializer
        Leaderboard leaderboard[] = init(leaderboardRepository);

        // iterate using "enhanced for loop"
        
        System.out.println(leaderboard);  // print object
    }
    
    // public static String[] Leaderboard() {
    //      Leaderboard leaderboardlist[] = {
    //         sort1
    //     };
    //     return(leaderboardlist);
    // }
}


