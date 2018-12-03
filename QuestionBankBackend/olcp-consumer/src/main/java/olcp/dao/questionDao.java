package olcp.dao;

import olcp.entity.question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface questionDao extends JpaRepository<question, Integer>{
    //分页查询对应方向的所有题目
    Page<question> findByDirection(@Param("direction") String direction, Pageable pageable);
    question findById(int id);
    //获取对应方向的题目总数
    int countByDirection(String direction);

}
