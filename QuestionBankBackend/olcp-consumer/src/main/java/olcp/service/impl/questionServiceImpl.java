package olcp.service.impl;

import olcp.dao.questionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import olcp.entity.question;
import olcp.service.questionService;

import java.util.List;

@Service
public class questionServiceImpl implements questionService {
    @Autowired
    private questionDao questionDao1;

    @Override
    public List<question> findAll() {
        return questionDao1.findAll();
    }

    @Override
    public Page<question> findAll(Pageable pageable) {
        return questionDao1.findAll(pageable);
    }

    @Override
    public List<question> findAllExample(Example<question> example) { return questionDao1.findAll(example);
    }

    @Override
    public question findById(int id){ return questionDao1.getOne(id); }

    @Override
    public void update(question question1){ questionDao1.save(question1); }

    @Override
    public int create(question question1){ return questionDao1.save(question1).getId(); }

    @Override
    public void delById(int id){ questionDao1.delete(id); }

    @Override
    public void save(question question1){ questionDao1.save(question1); }

    @Override
    public Page<question> findByDirection(String direction,Pageable pageable) { return questionDao1.findByDirection(direction,pageable); }

    @Override
    public int countByDirection(String direction)
    {
        return questionDao1.countByDirection(direction);
    }
}
