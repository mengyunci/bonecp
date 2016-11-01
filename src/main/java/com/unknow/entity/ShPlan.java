package com.unknow.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mac on 16/3/2.
 */
@Entity
@Table(name = "sh_plan")
public class ShPlan implements Serializable {

    // 计划编号
    private Long planCode;
    // 计划名称
    private String planName;
    // 计划开始时间
    private Date startTime;
    // 计划完成时间
    private Date finishTime;
    // 实际开始时间
    private Date actualStartTime;
    // 实际完成时间
    private Date actualFinishTime;
    // 计划产量
    private Integer planCount;
    // 完成量
    private Integer completeCount;
    // 下达人
    private String planPerson;
    // 下达时间
    private Date planDate;
    // 计划状态(0:下达 1:进行中 2：完成)
    private Integer status;
    // 不合格数量
    private int unqualify;


    @Id
    @GeneratedValue
    @Column(name = "plancode")
    public Long getPlanCode() {
        return planCode;
    }

    public void setPlanCode(Long planCode) {
        this.planCode = planCode;
    }

    @Column(name = "planname")
    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    @Column(name = "starttime")
    @Temporal(TemporalType.DATE)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Column(name = "finishtime")
    @Temporal(TemporalType.DATE)
    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    @Column(name = "actualstarttime")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getActualStartTime() {
        return actualStartTime;
    }

    public void setActualStartTime(Date actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    @Column(name = "actualfinishtime")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getActualFinishTime() {
        return actualFinishTime;
    }

    public void setActualFinishTime(Date actualFinishTime) {
        this.actualFinishTime = actualFinishTime;
    }

    @Column(name = "plancount")
    public Integer getPlanCount() {
        return planCount;
    }

    public void setPlanCount(Integer planCount) {
        this.planCount = planCount;
    }

    @Column(updatable = false,name = "completecount")
    public Integer getCompleteCount() {
        return completeCount;
    }

    public void setCompleteCount(Integer completeCount) {
        this.completeCount = completeCount;
    }

    @Column(name = "planperson")
    public String getPlanPerson() {
        return planPerson;
    }

    public void setPlanPerson(String planPerson) {
        this.planPerson = planPerson;
    }

    @Column(name = "plandate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(updatable = false,name = "unqualify")
    public int getUnqualify() {
        return unqualify;
    }

    public void setUnqualify(int unqualify) {
        this.unqualify = unqualify;
    }
}
