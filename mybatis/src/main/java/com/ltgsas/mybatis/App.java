package com.ltgsas.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ltgsas.mybatis.mapper.CasebaseMapper;
import com.ltgsas.mybatis.pojo.Casebase;
import com.ltgsas.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class App {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CasebaseMapper casebaseMapper = sqlSession.getMapper(CasebaseMapper.class);
        /**
         *  查询之前开启分页功能 page{
         * count=true, pageNum=11, pageSize=8, startRow=80, endRow=88, total=10000, pages=1250, reasonable=false, pageSizeZero=false}
         */
        Page<Object> page = PageHelper.startPage(11, 8);
        List<Casebase> listallFromCasebase = casebaseMapper.getAllFromCasebase();
        listallFromCasebase.forEach(System.out::println);
        System.out.println("查询结果记录数: Total = " + page.getTotal());
        /**
         * 查询之后获取分页参数: pageInfo{
         * pageNum=11, pageSize=8, size=8, startRow=81, endRow=88, total=10000, pages=1250,
         * list=Page{count=true, pageNum=11, pageSize=8, startRow=80, endRow=88, total=10000, pages=1250, reasonable=false, pageSizeZero=false}
         * prePage=10, nextPage=12, isFirstPage=false, isLastPage=false,
         * hasPreviousPage=true, hasNextPage=true, navigatePages=5, navigateFirstPage=9, navigateLastPage=13, navigatepageNums=[9, 10, 11, 12, 13]}
         */
        PageInfo<Casebase> pageInfo = new PageInfo<>(listallFromCasebase,5);
        System.out.println(page);
        System.out.println(pageInfo);
        sqlSession.close();
    }
}
