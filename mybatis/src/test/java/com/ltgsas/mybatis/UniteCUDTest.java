package com.ltgsas.mybatis;

import com.ltgsas.mybatis.mapper.TdbassistanMapper;
import com.ltgsas.mybatis.pojo.Tdbassistan;
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
        TdbassistanMapper tdbassistanMapper = sqlSession.getMapper(TdbassistanMapper.class);
        /** 写法一: 对象属性变量先分别赋值1
         Tdbassistan tdbassistan = new Tdbassistan();
         tdbassistan.setSname("abc");
         tdbassistan.setEmail("abc@ab.cc");
         tdbassistan.setNumber(17);
         tdbassistan.setScore((float) 68);*/
        /** 写法二: 对象属性变量先分别赋值2
         Tdbassistan tdbassistan;
         Map<String, Object> params = new HashMap<>();
         params.put("sname","cvb");
         params.put("email","cvb@aa.cc");
         params.put("number",15);
         params.put("score",(float) 52);*/
        int result = tdbassistanMapper.insertRowOfTdbassistanForSelfIncrease(new Tdbassistan("awd", "awd@aa.cc", (short) 11, (float) 66));
        System.out.println("Affects the number of rows:" + result);
        sqlSession.close();
    }

    /**
     * 修改:
     */
    @Test
    public void updateRowTdbassistan() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TdbassistanMapper tdbassistanMapper = sqlSession.getMapper(TdbassistanMapper.class);
        int result = tdbassistanMapper.updateRowOfTdbassistanForAnnotation(new Tdbassistan(6, "ggg", "ggg@qq.com", (short) 22, (float) 22));
        System.out.println("Affects the number of rows:" + result);
        sqlSession.close();
    }

    /**
     * 删除:
     */
    @Test
    public void deleteRowTdbassistan() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TdbassistanMapper tdbassistanMapper = sqlSession.getMapper(TdbassistanMapper.class);
        int result = tdbassistanMapper.deleteRowOfTdbassistan(12);
        System.out.println("Affects the number of rows:" + result);
        sqlSession.close();
    }
}
