package app.repo;

import app.entity.Notes;
import app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select DISTINCT u from User u join fetch u.notes")
    Collection<User> getUserByFetch();

    @Query("select u from User u join fetch u.notes where u.customerNumber = :number")
    User getUserFetchByUserId(@Param("number") Long number);

}
