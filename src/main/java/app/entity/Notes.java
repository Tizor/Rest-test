package app.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


//@Data
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@Table(name = "notes")
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
//        property = "notesId")
public class Notes implements Serializable {

    @Id
    @Column(name = "notes_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notesId;

    @Column(name = "note")
    private String note;

    /**
     * 2 вариант однонаправленной связи ManyToOne. На стороне родительской сущности ничего нет.
     * customer_id - это название столбца_FK в дочерней таблице.
     * Отображение: Дочерняя сущность с коллекцией ее родительских сущностей.
     * На стороне родительских сущностей ничего нет.
     * FetchType.EAGER для полной прогрузки данных - отображается список дочерних сущностей.
     * FetchType.LAZY без полной прогрузки данных - список дочерних сущностей -> null.
     */
//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "customer_id")
//    private User userWithNote;

    /**
     * 1 вариант ДВУНАПРАВЛЕНОЙ связи ManyToOne. На стороне родительской сущности есть
     * коллекция дочерних сущностей, а так же аннотация
     * @OneToMany(mappedBy = "userWithNote")
     */
//   @ManyToOne
//   @JoinColumn(name = "customer_id")
//    private User userWithNote;

    /**
     * Для     @ElementCollection
     *     private Collection<Notes> notes = new ArrayList<>();
     */
//   @ManyToOne(fetch = FetchType.LAZY)
//   @JoinColumn(name = "customer_id")
//    private User userWithNote;


    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private User userWithNote;

}
