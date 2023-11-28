package com.nighthawk.spring_portfolio.mvc.leaderboard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.boot.SpringApplication;
import org.springframework.data.repository.CrudRepository;

import com.vladmihalcea.hibernate.type.json.JsonType;

import jakarta.persistence.*;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@NoArgsConstructor
//@AllArgsConstructor
@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
@Convert(attributeName ="leaderboard", converter = JsonType.class)
public class Leaderboard {
//     public interface LeaderboardRepository extends CrudRepository<Leaderboard, Long> {
// }
    
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


    public static List<Leaderboard> createIntialData() {
        List<Leaderboard> initialData = new ArrayList<>();
        initialData.add(new Leaderboard("bubble", 1000000, 1200));
        return initialData;
    }

    public static List<Leaderboard> init() {
        return createIntialData();
    }
}


