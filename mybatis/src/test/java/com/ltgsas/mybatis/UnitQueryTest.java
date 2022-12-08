package com.ltgsas.mybatis;

import com.ltgsas.mybatis.mapper.CasebasicMapper;
import com.ltgsas.mybatis.pojo.Casebasic;
import com.ltgsas.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitQueryTest {
    /**
     * 指定ID进行简单查询其基本信息
     */
    @Test
    public void findByColumnOnID() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CasebasicMapper casebasicMapper = sqlSession.getMapper(CasebasicMapper.class);
        Casebasic byColumnOnID = casebasicMapper.getByColumnOnID(108);
        System.out.println(byColumnOnID);
        sqlSession.close();
    }

    /**
     * 查询多个指定记录 使用 ${param} 与 #{param} 差异
     */
    @Test
    public void findMoreRecords() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CasebasicMapper casebasicMapper = sqlSession.getMapper(CasebasicMapper.class);
        List<Casebasic> records = casebasicMapper.ListMoreRecordsFromCasebasic("3,5,9");
        records.forEach(System.out::println);
        sqlSession.close();
    }

    /**
     * 查询动态表名, 只能使用 ${tableName}, 不能使用 #{tableName} 参数
     */
    @Test
    public void findDynamicTable() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CasebasicMapper casebasicMapper = sqlSession.getMapper(CasebasicMapper.class);
        List<Casebasic> casebasic = casebasicMapper.ListDynamicTable("casebasic");
        casebasic.forEach(System.out::println);
        sqlSession.close();
    }

    /**
     * 指定姓名进行模糊查询其全部信息
     */
    @Test
    public void findByColumnInCname() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CasebasicMapper casebasicMapper = sqlSession.getMapper(CasebasicMapper.class);
        List<Casebasic> listByColumnInCname = casebasicMapper.listByColumnInCname("张");
        listByColumnInCname.forEach(System.out::println);
        sqlSession.close();
    }

    /**
     * 任意"列名"和"模糊值"进行模糊查询其全部信息 (列名要求全匹配)
     */
    @Test
    public void findByColumnAndValue() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CasebasicMapper casebasicMapper = sqlSession.getMapper(CasebasicMapper.class);
        List<Casebasic> casebasicList = casebasicMapper.listByColumnAndValue("cbid", "21486566");
        casebasicList.forEach(System.out::println);
        sqlSession.close();
    }

    /**
     * 用 Map 方法并采用"注解"方式查询数据
     */
    @Test
    public void findByColumnUseMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CasebasicMapper casebasicMapper = sqlSession.getMapper(CasebasicMapper.class);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("cname", "张");
        objectHashMap.put("age", 25);
        List<Casebasic> casebasicList = casebasicMapper.listByColumnUseMap(objectHashMap);
        for (Casebasic casebasic : casebasicList) {
            System.out.println(casebasic);
        }
        sqlSession.close();
    }

    /**
     * 分页查询有限个结果
     */
    @Test
    public void findByLimitForMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CasebasicMapper casebasicMapper = sqlSession.getMapper(CasebasicMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 10);
        map.put("pageSize", 20);
        List<Casebasic> casebasicList = casebasicMapper.listByLimitUseMap(map);
        for (Casebasic casebasic : casebasicList) {
            System.out.println(casebasic);
        }
        sqlSession.close();
    }

    /**
     * 随机查询有限个结果
     */
    @Test
    public void selectByRowBounds() {
        // RowBounds 实现
        RowBounds rowBounds = new RowBounds(1, 5);
        //int start = (int) round(random()*9999);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Casebasic> casebasicList = sqlSession.selectList("com.ltgsas.mybatis.mapper.CasebasicMapper.listUseRowBounds", null, rowBounds);
        casebasicList.forEach(System.out::println);
        System.out.println("Done >>> Testing selectByRowBounds is over!");
        sqlSession.close();
    }

    /**
     * 指定班级进行查询其全部信息
     */
    @Test
    public void findByColumnOnGrade() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CasebasicMapper casebasicMapper = sqlSession.getMapper(CasebasicMapper.class);
        List<Casebasic> casebasicList = casebasicMapper.listByColumnOnGrade("200");
        for (Casebasic casebasic : casebasicList) {
            System.out.println(casebasic);
        }
        sqlSession.close();
    }

    /**
     * 查询单个返回值给到 Map 变量
     */
    @Test
    public void findByIdFromCasebasicToMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CasebasicMapper casebasicMapper = sqlSession.getMapper(CasebasicMapper.class);
        Map<String, Object> casebasicByIdToMap = casebasicMapper.getByIdToMapFromCasebasic(9999);
        System.out.println(casebasicByIdToMap);
        sqlSession.close();
    }

    /**
     * 查询多个返回值给到 Map 变量 示例1
     */
    @Test
    public void findAllFromCasebasicToMapOne() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CasebasicMapper casebasicMapper = sqlSession.getMapper(CasebasicMapper.class);
        List<Map<String, Object>> allToMapFromCasebasic = casebasicMapper.listAllToMapFromCasebasic();
        for (Map<String, Object> stringObjectMap : allToMapFromCasebasic) {
            System.out.println(stringObjectMap);
        }
        sqlSession.close();
    }

    /**
     * 查询多个返回值给到 Map 变量 示例2
     */
    @Test
    public void findAllFromCasebasicToMapTwo() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CasebasicMapper casebasicMapper = sqlSession.getMapper(CasebasicMapper.class);
        Map<String, Object> allToMap = casebasicMapper.getAllToMapFromCasebasic();
        System.out.println(allToMap);
        sqlSession.close();
    }
}
