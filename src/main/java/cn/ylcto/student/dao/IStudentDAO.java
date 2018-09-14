package cn.ylcto.student.dao;

import cn.ylcto.student.vo.Student;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO extends IDAO<String,Student> {
    /**
     * 实现数据分页操作
     * @param currentPage 表示当前页
     * @param lineSize 表示每页显示记录数
     * @return 成功返回满足条件的数据，失败返回null
     * @throws SQLException
     */
    public List<Student> findAllBySplit( Integer currentPage, Integer  lineSize)throws SQLException;

    /**
     * 实现数据量统计操作
     * @return 成功返回数据量，失败返回 0
     * @throws SQLException
     */
    public Integer getAllCount()throws SQLException;

    /**
     * 实现数据批量删除操作
     * @param ids 表示要执行删除操作的集合数据
     * @return
     * @throws SQLException
     */
    public boolean doRemoverBatch(List<String> ids)throws SQLException;
}
