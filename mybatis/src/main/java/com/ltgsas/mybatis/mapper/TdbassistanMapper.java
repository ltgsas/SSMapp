package com.ltgsas.mybatis.mapper;

import com.ltgsas.mybatis.pojo.Tdbassistan;

import java.util.HashMap;
public interface TdbassistanMapper {
    //    int insertRowOfTdbassistan(@Param("id") int id,@Param("sname") String name, @Param("email") String email, @Param("number") int num, @Param("score") float score);
    int insertRowOfTdbassistanForSelfIncrease(Tdbassistan tdbassistan);

    int updateRowOfTdbassistanForMap(HashMap<String, Object> params);

    //    int updateRowOfTestdbForAnnotation(@Param("id") int id, @Param("sname") String name, @Param("email") String email, @Param("number") int num, @Param("score") float score);
    //@Update("update tdbassistan set sname = #{tdbassistan.sname}, email = #{email}, number = #{number}, score = #{score} where id = #{id} ")
    int updateRowOfTdbassistanForAnnotation(Tdbassistan tdbassistan);

    int deleteRowOfTdbassistan(int row);
}
