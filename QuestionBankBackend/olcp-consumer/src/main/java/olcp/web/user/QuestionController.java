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

}
