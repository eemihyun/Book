package org.mega.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=500, nullable=false)
    private String title;
    @Column(columnDefinition="TEXT", nullable=false)
    private String content;
    private String author;
    /*
    * @Builder를 통해 제공되는 빌드 클래스를 사용
    * 생성자나 빌더 생성 역할은 똑같다.
    * */
    @Builder // 디자인패턴중 하나 빌더패턴. 클래스 안에 클래스를 만듬. 보안성을 올리기 위해 사용
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
 }
