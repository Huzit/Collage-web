package ac.ks.web.domain;

import com.sun.javafx.beans.IDProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;
import java.time.LocalDateTime;

//Lombok
@Getter
@NoArgsConstructor

//Jpa
@Entity
@Table
public class Board {

    @Id //PK
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String title;

    @Column
    private String subTitle;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING)
    private BoardType boardType; //프리/노티스를 선택하게 하는거

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @Builder
    public Board(String title, String subTitle, String content, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
