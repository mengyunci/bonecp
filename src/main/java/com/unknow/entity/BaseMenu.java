package com.unknow.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by mac on 16/3/24.
 */
@Entity
@Table(name = "menu")
public class BaseMenu {
    private int id;
    private Date createTime;
    private String createUser;
    private String iconCls;
    private String text;
    private String description;
    private String url;
    private Integer prentId;
    private Integer moduleId;

    private List<BaseMenu> children;

    @Id
    @Column(name = "id")
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "createtime")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "createuser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "iconcls")
    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    @Basic
    @Column(name = "name")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "parentid")
    public Integer getPrentId() {
        return prentId;
    }

    public void setPrentId(Integer prentId) {
        this.prentId = prentId;
    }

    @Basic
    @Column(name = "moduid")
    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    @Transient
    public List<BaseMenu> getChildren() {
        return children;
    }

    public void setChildren(List<BaseMenu> children) {
        this.children = children;
    }
}
