package olcp.mapper;

import olcp.entity.question;;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Select("SELECT * FROM question WHERE DIRECTION = #{direction}")
    List<question> findByDirection(@Param("direction") String direction);

    @Insert("INSERT INTO question(DIRECTION) VALUES(#{direction})")
    int insert(@Param("direction") String direction);

}
