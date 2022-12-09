package com.ltgsas.mybatis.mapper;

import com.ltgsas.mybatis.pojo.Dbassist;

import java.util.HashMap;
public interface DbassistMapper {
    //    int insertRowOfTdbassistan(@Param("id") int id,@Param("sname") String name, @Param("email") String email, @Param("number") int num, @Param("score") float score);
    int insertRowOfDbassistForSelfIncrease(Dbassist dbassist);

    int updateRowOfDbassistForMap(HashMap<String, Object> params);

    //    int updateRowOfTestdbForAnnotation(@Param("id") int id, @Param("sname") String name, @Param("email") String email, @Param("number") int num, @Param("score") float score);
    //@Update("update dbassist set sname = #{dbassist.sname}, email = #{email}, number = #{number}, score = #{score} where id = #{id} ")
    int updateRowOfDbassistForAnnotation(Dbassist dbassist);

    int deleteRowOfDbassist(int row);
}
