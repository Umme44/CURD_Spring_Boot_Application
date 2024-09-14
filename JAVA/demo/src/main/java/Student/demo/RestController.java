package Student.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;


@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private UniversityService universityService;

    @PostMapping("/createUniversity")
    public ResponseEntity<University> createUniversity(@RequestParam("file") MultipartFile multipartFile, University university) throws IOException {
        String file_path = "D:/JAVA/images" + multipartFile.getOriginalFilename();
        Files.copy(multipartFile.getInputStream(), Paths.get(file_path), StandardCopyOption.REPLACE_EXISTING);
        return ResponseEntity.ok(universityService.createOrUpdateUniversity(university));
    }


    /*@PostMapping("/createUniversity")
    public ResponseEntity<University> createUniversity(University university)  {
        return ResponseEntity.ok(universityService.createOrUpdateUniversity(university));
    }*/


    @GetMapping("/universities")
        public ResponseEntity<List<University>> searchUniversities(
                @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String name,
                @RequestParam(required = false) String address,
                @RequestParam(required = false) University.UniversityType universityType,
                @RequestParam(required = false) Double minRating,
                @RequestParam(required = false) Double maxRating,
                @RequestParam(required = false) LocalDateTime fromDateTime,
                @RequestParam(required = false) LocalDateTime toDateTime) {
            return ResponseEntity.ok(universityService.searchUniversities(name, address, universityType, minRating, maxRating, fromDateTime, toDateTime));
        }
    }












