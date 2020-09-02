package app.repo;

import app.entity.Notes;
import app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface NotesRepo extends JpaRepository<Notes, Long> {

    @Query("select child from Notes child where child.userWithNote.customerNumber = :number")
    Collection<Notes> getChildNotes(@Param("number") Long number);

//    @Query("select DISTINCT u from Notes u join fetch u.userWithNote")
//    Collection<Notes> getNotesByFetch();
}

