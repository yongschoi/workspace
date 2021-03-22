package yongs.temp.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import yongs.temp.entity.Member;
import static yongs.temp.entity.QMember.member;

import java.util.List;

/**
 * Created by yogschoi@gmail.com on 2020-11-23
 * Github : http://github.com/yogschoi
 */
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public List<Member> findByName(String name) {
        return queryFactory.selectFrom(member)
                .where(member.name.eq(name))
                .fetch();
    }
}
