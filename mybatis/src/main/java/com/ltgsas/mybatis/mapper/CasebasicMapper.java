package com.ltgsas.mybatis.mapper;

import com.ltgsas.mybatis.pojo.Casebasic;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CasebasicMapper {
    /**
     * 进行简单查询其基本信息
     * @return all casebasic records
     */
    List<Casebasic> getAllFromCasebasic();

    /**
     * 指定ID进行简单查询其基本信息
     * @param id
     * @return casebasic
     */
    Casebasic getByColumnOnID(int id);

    /**
     * 查询多个指定记录 使用 ${param} 与 #{param} 差异
     *
     * @param scope
     * @return
     */
    List<Casebasic> ListMoreRecordsFromCasebasic(@Param("scope") String scope);

    /**
     * 动态使用表名 只能使用 ${tableName} 不能使用 #{tableName}
     * @param tableName
     */
    List<Casebasic> ListDynamicTable(@Param("tableName") String tableName);

    /**
     * 指定姓名进行模糊查询其全部信息
     *
     * @param name
     * @return List<Casebasic>
     */
    List<Casebasic> listByColumnInCname(@Param("name") String name);

    /**
     * 任意"列名"和"模糊值"进行模糊查询其全部信息 (列名要求全匹配)
     * @param columnValue
     * @param columnName
     * @return List<Casebasic>
     * 采用注解写法(以下三条注解语句任一句等效),可绕过相应的 .xml 文件, 本质是采用 Ｍap 传递参数．
     * @Select("select * from casebasic where #{columnName} = #{columnValue}")
     * @Select("select * from casebasic where #{argv0} = #{argv1}")
     * @Select("select * from casebasic where #{param1} = #{param2}")
     */
    List<Casebasic> listByColumnAndValue(@Param("columnName") String columnName, @Param("columnValue") String columnValue);

    /**
     * 采用 Map 方式注解查询数据
     * @param map
     * @return List<Casebasic>
     */
    @Select("select * from casebasic where cname like concat('%', #{cname}, '%') and age = #{age}")
    @Results(id = "getCasebaseData", value = {
            @Result(id = true, column = "id", property = "ID"),
            @Result(column = "cbid", property = "CBID"),
            @Result(column = "cname", property = "cName"),
            @Result(column = "alias_name", property = "aliasName"),
            @Result(column = "grade", property = "grade"),
            @Result(column = "age", property = "age"),
            @Result(column = "email", property = "eMail"),
            @Result(column = "identity_card", property = "IDNumber"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "member", property = "member"),
            @Result(column = "mobile", property = "mobile"),
            @Result(column = "address", property = "address"),
            @Result(column = "join_date", property = "joinDate"),
            //@Result(column = "cbid", property = "casescore", many = @Many(select = "select * from casescore where cbid = #{cbid}", fetchType = FetchType.LAZY))
    })
    List<Casebasic> listByColumnUseMap(HashMap map);

    /**
     * 分页查询示例1
     * @param Map
     * @return List<Casebasic>
     */
    List<Casebasic> listByLimitUseMap(HashMap Map);

    /**
     * 分页查询示例2: RowBounds -- 不推荐使用,
     * 默认情况下的 RowBounds 无法获取查询总数
     */
    List<Casebasic> listUseRowBounds();

    /**
     * 多对一查询示例
     * @param gradeNumber
     * @return List<Casebasic>
     */
    List<Casebasic> listByColumnOnGrade(String gradeNumber);

    /**
     * 查询单条记录值返回给 Map
     * @param id
     * @return
     */
    @Select("select * from casebasic where id = #{id}")
    Map<String,Object> getByIdToMapFromCasebasic(@Param("id") Integer id);

    /**
     * 查询一组值返回给 Map 示例1
     * @param id
     * @return
     */
    @Select("select * from casebasic limit 800,5")
    List<Map<String,Object>> listAllToMapFromCasebasic();

    /**
     * 查询一组值返回给 Map 示例2
     * @return
     */
    @MapKey("id")
    Map<String,Object> getAllToMapFromCasebasic();
}
