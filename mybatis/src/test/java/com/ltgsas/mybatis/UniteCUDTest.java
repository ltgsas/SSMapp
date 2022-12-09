package com.ltgsas.mybatis;

import com.ltgsas.mybatis.mapper.DbassistMapper;
import com.ltgsas.mybatis.pojo.Dbassist;
import com.ltgsas.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UniteCUDTest {
    /**
     * 插入:
     */
    @Test
    public void insertRowTdbassistan() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DbassistMapper dbassistMapper = sqlSession.getMapper(DbassistMapper.class);
        /** 写法一: 对象属性变量先分别赋值1
         Dbassist tdbassistan = new Dbassist();
         tdbassistan.setSname("abc");
         tdbassistan.setEmail("abc@ab.cc");
         tdbassistan.setNumber(17);
         tdbassistan.setScore((float) 68);*/
        /** 写法二: 对象属性变量先分别赋值2
         Dbassist tdbassistan;
         Map<String, Object> params = new HashMap<>();
         params.put("sname","cvb");
         params.put("email","cvb@aa.cc");
         params.put("number",15);
         params.put("score",(float) 52);*/
        int result = dbassistMapper.insertRowOfDbassistForSelfIncrease(new Dbassist("awd", "awd@aa.cc", (short) 11, (float) 66));
        System.out.println("Affects the number of rows:" + result);
        sqlSession.close();
    }

    /**
     * 修改:
     */
    @Test
    public void updateRowTdbassistan() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DbassistMapper dbassistMapper = sqlSession.getMapper(DbassistMapper.class);
        int result = dbassistMapper.updateRowOfDbassistForAnnotation(new Dbassist(6, "ggg", "ggg@qq.com", (short) 22, (float) 22));
        System.out.println("Affects the number of rows:" + result);
        sqlSession.close();
    }

    /**
     * 删除:
     */
    @Test
    public void deleteRowTdbassistan() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DbassistMapper dbassistMapper = sqlSession.getMapper(DbassistMapper.class);
        int result = dbassistMapper.deleteRowOfDbassist(15);
        System.out.println("Affects the number of rows:" + result);
        sqlSession.close();
    }
}
