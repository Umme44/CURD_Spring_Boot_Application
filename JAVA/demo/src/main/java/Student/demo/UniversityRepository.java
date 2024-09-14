package Student.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer>{

    List<University> findByNameContaining(String name);
    List<University> findByAddressContaining(String address);
    List<University> findByUniversityType(University.UniversityType universityType);
    List<University> findByRatingBetween(Double minRating, Double maxRating);
    List<University> findByCasuallyOpenAtBetween(LocalDateTime form, LocalDateTime to);

}
