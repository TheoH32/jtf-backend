package com.nighthawk.spring_portfolio.mvc.sorting;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.vladmihalcea.hibernate.type.json.JsonType;

import jakarta.persistence.*;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@NoArgsConstructor
//@AllArgsConstructor
@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
@Convert(attributeName ="Sort Times", converter = JsonType.class)
public class Sort {
    @Column(unique=true)
    private String sortName;
    private double time;
    public Sort(String sortName, double time) {
        this.sortName = sortName;
        this.time = time;
    }

    public static List<Sort> createIntialData() {
        List<Sort> initialData = new ArrayList<>();
        initialData.add(new Sort("Merge", 0.0));
        initialData.add(new Sort("Bubble", 0.0));
        initialData.add(new Sort("Selection", 0.0));
        initialData.add(new Sort("Insertion", 0.0));
        return initialData;
    }

    public static List<Sort> init() {
        return createIntialData();
    }

    // Put Timing Super Class
    // Child Sort classes
}
