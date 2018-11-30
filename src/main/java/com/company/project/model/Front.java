package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class Front {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "object_id")
    private Integer objectId;
    private Integer type;

    private String title;

    private String description;

    private String content;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "create_date")
    private Date createDate;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getType(){return type;}
    public void  setType(Integer type){this.type=type;}

    /**
     * @return object_id
     */
    public Integer getObjectId() {
        return objectId;
    }

    /**
     * @param objectId
     */
    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return img_url
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}