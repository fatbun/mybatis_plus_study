package com.benjamin.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.util.Date;

public class BaseEntity {

    /**
     * 自动在插入操作时写入
     */
    @TableField(fill = FieldFill.INSERT)
    private Date dateCreated;

    /**
     * 自动在更新操作时更新
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date lastUpdated;

    /**
     * 逻辑删除
     */
    @TableLogic(delval = "now()", value = "null")
    private Date deleted;

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}
