package olcp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 题目
 */
@Entity
@Table(name="question")
public class question implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 题目Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    /**
     * 题目内容
     */
    @Column
    private String content;
    /**
     * 题目选项
     */
    @Column
    private String option;
    /**
     * 题目图片地址
     */
    @Column
    private String imgurl;
    /**
     * 题目类型
     */
    @Column
    private Integer type;
    /**
     * 难度
     */
    @Column
    private Integer difficulty;
    /**
     * 题目创建时间
     */
    @Column
    private Date creation_time;
    /**
     * 题目方向
     */
    @Column
    private String direction;
    /**
     * 题目热度
     */
    @Column
    private Integer hot;

    @Column
    @Transient
    private question question;

    public question getQuestion() {
        return question;
    }

    public void setQuestion(question question) {
        this.question = question;
    }
    public question(){

    }

    public question(String content, String option, String imgurl, Integer type, Integer difficulty, Date
            creation_time, String direction, Integer hot) {
        this.content = content;
        this.option = option;
        this.imgurl = imgurl;
        this.type = type;
        this.difficulty = difficulty;
        this.creation_time = creation_time;
        this.direction = direction;
        this.hot = hot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }
}
