package Student.demo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "University")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name" )
    private  String name;

    @Column(name = "Address" )
    private String address;

    @Column(name = "Rating")
    private Double rating;

    @Column(name = "Description")
    private String description;

    @Column(name = "Image_path")
    private String imagePath;

    @Column(name = "StartDate",updatable = false)
    private LocalDate startDate;

    @Column(name = "CasuallyOpenAt",updatable = false)
    private LocalDateTime casuallyOpenAt;

    //University Type
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UniversityType universityType;


    public enum UniversityType{
        PUBLIC,
        PRIVATE
    }

    //Other Information Datatype jsonB
    @Column(columnDefinition = "jsonb")
    private String metadata;



}
