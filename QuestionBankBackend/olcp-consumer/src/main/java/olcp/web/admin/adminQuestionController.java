package olcp.web.admin;

import olcp.entity.question;
import olcp.service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/question")
public class adminQuestionController {
    @Autowired
    private questionService questionservice;

    /**
     *　根据id删除对应题目
     */
    @RequestMapping("/delete")
    public Boolean delete(int id) {
        questionservice.delById(id);
        return true;
    }
    /**
     *　分页查看对应方向的题目
     */
    @RequestMapping("/allquestions")
    public Page<question> getallquestions(String direction, @RequestParam(defaultValue = "0",required = true) Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, 8,sort);
        Page<question> questions = questionservice.findByDirection(direction,pageable);
        return questions;
    }
    /**
     *　获得对应方向的题目总数
     */
    @RequestMapping("/getTotal")
    public int geTotal(String direction) {
        int total = questionservice.countByDirection(direction);
        return total;
    }
}
