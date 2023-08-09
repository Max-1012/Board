package hello.hellospring.domain;
import jakarta.persistence.*;

@Entity // JPA 가 관리하는 Entity가 된다는 뜻!
public class Member {
    @Id // 얘는 PK임!!
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에 값을 넣으면 id를 자동 생성해줌, DB가 알아서 생성해주는 identity 전략
    private Long id;
    // @Column(name="username")    // DB에 column 명이 username이면 이렇게 Mapping 해줄 수 있음
    private String name;




    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
