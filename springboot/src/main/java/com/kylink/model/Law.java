package com.kylink.model;

import java.util.Date;

public class Law {
    public String index;
    public String id;
    public String title; //标题
    public Date reDate;//发布日期
    public Date acDate;//生效日期
    public Date failDate;//失效日期
    public String reNumber;//发布文号
    public String reAuthority;//发布机构
    public String level;//级别
    public String area;//区域
    public String trade;//行业
    public String antistop;//关键词
    public String describe;//描述
    public String fulltext;//全文

    public Date reFromTime;
    public Date reToTime;
    public Date acFromTime;
    public Date acToTime;
    public Date faFromTime;
    public Date faToTime;


    public Date getReFromTime() {
        return reFromTime;
    }

    public void setReFromTime(Date reFromTime) {
        this.reFromTime = reFromTime;
    }

    public Date getReToTime() {
        return reToTime;
    }

    public void setReToTime(Date reToTime) {
        this.reToTime = reToTime;
    }

    public Date getAcFromTime() {
        return acFromTime;
    }

    public void setAcFromTime(Date acFromTime) {
        this.acFromTime = acFromTime;
    }

    public Date getAcToTime() {
        return acToTime;
    }

    public void setAcToTime(Date acToTime) {
        this.acToTime = acToTime;
    }

    public Date getFaFromTime() {
        return faFromTime;
    }

    public void setFaFromTime(Date faFromTime) {
        this.faFromTime = faFromTime;
    }

    public Date getFaToTime() {
        return faToTime;
    }

    public void setFaToTime(Date faToTime) {
        this.faToTime = faToTime;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReDate() {
        return reDate;
    }

    public void setReDate(Date reDate) {
        this.reDate = reDate;
    }

    public Date getAcDate() {
        return acDate;
    }

    public void setAcDate(Date acDate) {
        this.acDate = acDate;
    }

    public Date getFailDate() {
        return failDate;
    }

    public void setFailDate(Date failDate) {
        this.failDate = failDate;
    }

    public String getReNumber() {
        return reNumber;
    }

    public void setReNumber(String reNumber) {
        this.reNumber = reNumber;
    }

    public String getReAuthority() {
        return reAuthority;
    }

    public void setReAuthority(String reAuthority) {
        this.reAuthority = reAuthority;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getAntistop() {
        return antistop;
    }

    public void setAntistop(String antistop) {
        this.antistop = antistop;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }
}
