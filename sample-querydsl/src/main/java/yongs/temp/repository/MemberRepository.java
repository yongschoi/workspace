package yongs.temp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yongs.temp.entity.Member;

/**
 * Created by yogschoi@gmail.com on 2020-11-23
 * Github : http://github.com/yogschoi
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
