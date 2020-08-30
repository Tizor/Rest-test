package app.repo;

import app.entity.Notes;
import app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface NotesRepo extends JpaRepository<Notes, Long> {

//    @Query("select child from Notes child where child.userWithNote.customerNumber = :number")
//    Collection<Notes> getChildNotes(@Param("number") Long number);
}


//    select child from MyTable child
//        left join fetch child.parent
//        where child.testId = 1
//
//    "select pc " +
//            "from PostComment pc " +
//            "where pc.post.id = :postId",