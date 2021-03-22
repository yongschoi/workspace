package yongs.temp.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yongs.temp.entity.Member;

import java.util.List;

import static yongs.temp.entity.QMember.member;

/**
 * Created by yogschoi@gmail.com on 2020-11-23
 * Github : http://github.com/yogschoi
 */
@RequiredArgsConstructor
@Repository
public class MemberQueryRepository {
    private final JPAQueryFactory queryFactory;

    public List<Member> findByName(String name) {
        return queryFactory.selectFrom(member)
                .where(member.name.eq(name))
                .fetch();
    }
}
