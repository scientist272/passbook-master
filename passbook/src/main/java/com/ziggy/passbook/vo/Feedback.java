package com.ziggy.passbook.vo;


import com.google.common.base.Enums;
import com.ziggy.passbook.constant.FeedbackType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//用户评论
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    //用户id
    private Long userId;

    //评论类型
    private String type;

    //PassTemplate RowKey,如果是app类型的评论，则美哦与
    private String templateId;

    //评论内容
    private String comment;

    /**
    * @Description: 校验方法
    * @Param:
    * @return: boolean
    * @Author: Mr.Wang
    * @Date: 2019/3/10
    */
    public boolean validate(){
        FeedbackType feedbackType = Enums.getIfPresent(
                FeedbackType.class,this.type.toUpperCase()
        ).orNull();
        return !(null == feedbackType || null ==comment);
    }
}
