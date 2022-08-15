package com.jfeesoft.fr.model.domain;

import io.jenetics.jpx.GPX;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@SequenceGenerator(name = "seq_activity_entry", sequenceName = "seq_activity_entry", allocationSize = 1)
public class ActivityEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private BigDecimal kilometers;
    private Long duration;
    @Column(name = "average_pace")
    private Long averagePace;
    @Column(name = "calories_burned")
    private Long caloriesBurned;
    @Column(name = "total_climb")
    private Long totalClimb;
    @Column(name = "ref_gpx_file")
    private String refGpxFile;

    //TODO: elevation 2.0 - check how long the user was running up/down

    //TODO: user data

    //TODO: audit data - move to separate class (base class)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar updateDate;

    private GPX gpx; //TODO: how to store in the DB?
    //TODO: Map ? - should we store the GPX data here?
    //TODO: Charts ? - should we store the GPX data here?

    @PrePersist
    public void prePersist() {
        updateDate = Calendar.getInstance();
    }

}
