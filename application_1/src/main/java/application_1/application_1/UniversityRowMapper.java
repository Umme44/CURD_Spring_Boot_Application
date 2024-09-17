package application_1.application_1;

import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UniversityRowMapper implements RowMapper {
    @Override

    public University mapRow(ResultSet rs, int rowNum) throws SQLException {
        University university = new University();
        university.setId(rs.getInt("id")); // Assuming there's an 'id' column in the table
        university.setName(rs.getString("name"));
        university.setAddress(rs.getString("address"));
        university.setUniversityType(UniversityType.valueOf(rs.getString("university_type")));
        university.setRating(rs.getFloat("rating"));
        university.setDescription(rs.getString("description"));
        university.setImage(rs.getString("image"));
        university.setStartingDate(rs.getDate("starting_date").toLocalDate());
        university.setCasuallyOpensAt(rs.getTimestamp("casually_opens_at").toLocalDateTime());
        university.setOtherInformation(rs.getString("other_information"));  // Assuming it's a String or JSON data

        return university;
    }
}
