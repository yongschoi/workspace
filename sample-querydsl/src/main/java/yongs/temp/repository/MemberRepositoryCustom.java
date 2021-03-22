package yongs.temp.repository;

import yongs.temp.entity.Member;

import java.util.List;

/**
 * Created by yogschoi@gmail.com on 2020-11-23
 * Github : http://github.com/yogschoi
 */
public interface MemberRepositoryCustom {
    public List<Member> findByName(String name);
}
