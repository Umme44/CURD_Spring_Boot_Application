package Student.demo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional

public class UniversityService {

    @Autowired
    public UniversityRepository universityRepository;

    public List<University> searchUniversities(String name, String address, University.UniversityType type, Double minRating, Double maxRating, LocalDateTime fromDateTime, LocalDateTime toDateTime) {

        if (name != null) {
            return universityRepository.findByNameContaining(name);
        }

        if (address != null) {
            return universityRepository.findByAddressContaining(address);
        }
        if (type != null) {
            return universityRepository.findByUniversityType(type);
        }

        if (minRating != null && maxRating != null) {
            return universityRepository.findByRatingBetween(minRating, maxRating);
        }

        if (fromDateTime != null && toDateTime != null) {
            return universityRepository.findByCasuallyOpenAtBetween(fromDateTime, toDateTime);
        }

        return universityRepository.findAll();
    }

        // Create or Update University
        public University createOrUpdateUniversity(University university){
            return universityRepository.save(university);
        }

        //Delete University
        public void deleteUniversity(Integer id){
             universityRepository.deleteById(id);
        }


    }




