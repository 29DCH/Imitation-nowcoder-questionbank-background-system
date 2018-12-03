package olcp.service;

import olcp.entity.question;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface questionService {
    /**
     * 根据id查询
     *
     * @param id
     * @return question
     */
    question findById(int id);
    /**
     * 分页查询所有题目
     *
     * @param pageable
     * @return
     */
    Page<question> findAll(Pageable pageable);
    List<question> findAll();
    /**
     * 按条件查询
     *
     * @param example
     * @return
     */
    List<question> findAllExample(Example<question> example);
    /**
     * 更新
     *
     * @param question1
     * @return
     */
    void update(question question1);

    /**
     * 创建
     *
     * @param question1
     * @return
     */
    int create(question question1);
    void save(question question1);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    void delById(int id);

    /**
     * 根据方向查询
     * @param direction
     * @return
     */
    Page<question> findByDirection(String direction,Pageable pageable);
    /**
     * 根据方向查询题目总数
     * @param direction
     * @return
     */
    int countByDirection(String direction);
}
