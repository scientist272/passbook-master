package com.ziggy.passbook.constant;


//常量定义
public class Constants {
    //商户优惠券kafka topic
    public static final String TEMPLATE_TOPIC = "merchants-template";

    //token文件存储目录
    public static final String TOKEN_DIR = "D:/tmp/token/";

    //已使用的token文件后缀
    public static final String USED_TOKEN_SUFFIX = "_";

    //用户数的redis key
    public static final String USE_COUNT_REDIS_KEY = "imooc-user-count";

    //user hbase table
    public class UserTable{
        //hbase表名
        public static final String TABLE_NAME = "pb:user";
        //基本信息列组
        public static final String FAMILY_B = "b";
        //用户名
        public static final String NAME = "name";
        //用户年龄
        public static final String AGE = "age";
        //用户性别
        public static final String SEX = "sex";
        //额外信息列组
        public static final String FAMILY_O = "o";
        //电话号码
        public static final String PHONE = "phone";
        //住址
        public static final String ADDRESS = "address";
    }

    //passtemplate hbase table
    public class PassTemplateTable{
        //hbase表名
        public static final String TABLE_NAME = "pb:passtemplate";
        //基本信息列组
        public static final String FAMILY_B = "b";
        //优惠券id
        public static final String ID = "id";
        //优惠券标题
        public static final String TITLE = "title";
        //优惠券摘要
        public static final String SUMMARY = "summary";
        //优惠券详细信息
        public static final String DESC = "desc";
        //优惠券是否有token
        public static final String HAS_TOKEN = "has_token";
        //优惠券背景色
        public static final String BACKGROUND = "background";
        //约束信息列组
        public static final String FAMILY_C = "c";
        //最大个数限制
        public static final String LIMIT = "limit";
        //优惠券开始时间
        public static final String START = "start";
        //优惠券结束时间
        public static final String END = "end";

    }

    //pass hbase table
    public class PassTable{
        public static final String TABLE_NAME = "pb:pass";
        //信息列组
        public static final String FAMILY_I = "i";
        //用户id
        public static final String USER_ID = "user_id";
        //优惠券id
        public static final String TEMPLATE_ID = "template_id";
        //优惠券识别码
        public static final String TOKEN = "token";
        //领取日期
        public static final String ASSIGNED_DATE = "assigned_date";
        //消费日期
        public static final String CON_DATE = "con_date";
    }
    //feedback hbase table
    public class FeedBack{
        public static final String TABLE_NAME = "pb:feedback";
        //信息列族
        public static final String FAMILY_I = "i";
        //用户id
        public static final String USER_ID = "user_id";
       //评论类型
        public static final String TYPE = "type";
        //passtemplate RowKey ,如果是app评论，则是-1
        public static final String TEMPLATE_ID = "template_id";
        //评论内容
        public static final String COMMENT = "comment";
    }
}
