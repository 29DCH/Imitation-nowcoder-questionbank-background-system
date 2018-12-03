package olcp.web.user;

import olcp.service.questionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import olcp.entity.*;

@RestController
@RequestMapping("/user/question")
public class QuestionController {
    @Autowired
    private questionService questionservice;
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
     *　新增题目
     */
    @RequestMapping("/add")
    public Boolean add(@RequestBody question question1) {
        question question2=new question();
        question2.setContent(question1.getContent());
        question2.setOption(question1.getOption());
        question2.setImgurl(question1.getImgurl());
        question2.setType(question1.getType());
        question2.setDifficulty(question1.getDifficulty());
        question2.setCreation_time(question1.getCreation_time());
        question2.setDirection(question1.getDirection());
        question2.setHot(question1.getHot());
        questionservice.save(question2);
        return true;
    }

    /**
     *　修改题目
     */
    @RequestMapping("/update")
    public Boolean update(@RequestBody question question1) {
        question question2=questionservice.findById(question1.getId());
        question2.setContent(question1.getContent());
        question2.setOption(question1.getOption());
        question2.setImgurl(question1.getImgurl());
        question2.setType(question1.getType());
        question2.setDifficulty(question1.getDifficulty());
        question2.setCreation_time(question1.getCreation_time());
        question2.setDirection(question1.getDirection());
        question2.setHot(question1.getHot());
        questionservice.update(question2);
        return true;
    }

    /**
     *　删除题目
     */
    @RequestMapping("/delete")
    public Boolean delete(int id) {
        questionservice.delById(id);
        return true;
    }
}
