package app.entity;

import app.repo.NotesRepo;
import app.repo.UserRepo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "customer")
public class User implements Serializable {
//
//    @Autowired
//    public NotesRepo notesRepo;

    @Id
    @Column(name = "customer_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "city")
    private String city;

    /**
     * 1 вариант однонаправленной связи OneToMany. На стороне дочерней сущности ничего нет.
     * customer_id - это название столбца_FK в дочерней таблице. На стороне дочерней сущности ничего нет.
     * Отображение: Родительская сущность с коллекцией ее дочерних сущностей.
     * На стороне дочерних сущностей ничего нет.
     * FetchType.EAGER для полной прогрузки данных - отображается список дочерних сущностей.
     * FetchType.LAZY без полной прогрузки данных - список дочерних сущностей -> null.
     */
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JoinColumn(name = "customer_id")
//    private Collection<Notes> notes = notesRepo.getChildNotes();

    /**
     * 1 вариант ДВУНАПРАВЛЕНОЙ связи oneToMany. На стороне дочерней сущности появляется поле userWithNote, тип которого равен
     * классу родительской сущности. Чтобы не уйти в зацикливание, на стороне с коллекцией делается Lazy связь. Или можно использовать
     * JsonManagedReference на стороне коллекции и   JsonBackReference на стороне другой сущности.
     */
//    @OneToMany(mappedBy = "userWithNote")
//    private Collection<Notes> notes = new ArrayList<>();

/**
 * Коллекция для однонаправленной связи ManyToOne. Для отображения дочерних сущностей в родительской сущности нужно написать доп запрос типа
 *  @Query("select child from Notes child where child.userWithNote.customerNumber = :number") и сеттить в эту коллекцию результат этого запроса для
 *  каждой родительской сущности по ее Id
 */
@ElementCollection
    private Collection<Notes> notes = new ArrayList<>();
}
