package yongs.temp.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import yongs.temp.entity.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yogschoi@gmail.com on 2020-11-23
 * Github : http://github.com/yogschoi
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberTest {
    @Autowired
    MemberRepository repo;

    @Autowired
    MemberRepositorySupport repoSupport;

    @Autowired
    MemberQueryRepository repoQuery;

    @AfterEach
    public void tearDown() throws Exception {
        repo.deleteAllInBatch();
    }

    @Test
    public void Member_기본기능_확인() {
        String userid1 = "hong";
        String name1 = "홍길동";
        String userid2 = "kim";
        String name2 = "김길동";

        repo.save(new Member(userid1, name1));
        repo.save(new Member(userid2, name2));

        List<Member> list = repo.findAll();
        assertThat(list).hasSize(2);
        assertThat(list.get(0).getName()).isEqualTo("홍길동");
        assertThat(list.get(1).getName()).isEqualTo("김길동");
    }

    @Test
    public void QUERYDSL_기본기능_확인() {
        String userid = "kang";
        String name = "강길동";

        repo.save(new Member(userid, name));

        List<Member> list = repoSupport.findByName(name);
        assertThat(list.get(0).getName()).isEqualTo(name);
    }

    @Test
    public void QUERYDSL_CUSTOM_기본기능_확인() {
        String userid = "kang";
        String name = "강길동";

        repo.save(new Member(userid, name));

        List<Member> list = repo.findByName(name);
        assertThat(list.get(0).getName()).isEqualTo(name);
    }

    @Test
    public void QUERYDSL_단독_기본기능_확인() {
        String userid = "kang";
        String name = "강길동";

        repo.save(new Member(userid, name));

        List<Member> list = repoQuery.findByName(name);
        assertThat(list.get(0).getName()).isEqualTo(name);
    }
}
