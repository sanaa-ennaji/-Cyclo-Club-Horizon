package org.sanaa.brif6.CCH.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "stage")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "stage_name" , nullable = false)
    private String stageName;

    @Column(nullable = false)
    private double number ;


    @Column(nullable = false)
    private String  startPoint ;


    @Column(nullable = false)
    private String endPoint ;

    @Column(nullable = false)
    private LocalDate startDate ;

    @ManyToOne
    @JoinColumn(name = "competition_id" , nullable = false)
    private Competition competition ;
}
