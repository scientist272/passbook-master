### 基于Kafka和Hbase的卡包应用后端
- 项目说明：  
 本项目分为商户和用户两个应用，商户应用为merchants，用户应用为passbook,需要同时启动两个应用进行测试。  

  本项目为后端应用，通过http接口来调用功能，返回json数据。  

  商户信息存储在mysql中，用户信息、评论、优惠券、优惠券模板存储在hbase中，用户应用和商户应用之间通过kafka来实现消息队列功能：即商户应用作为生产者投放优惠券模板到kafka中，用户应用作为消费者消费kafka中的优惠券模板并存入Hbase。

- 需要启动的服务:
    hbase, mysql, kafka, redis
- 启动项目需要修改的内容：
    1. resourses目录下的application.yml,将${yourhost}等修改为你自己服务器的ip地址和端口等
    2. Contants类中的TOKEN_DIR,将其修改为你电脑上想用来保存token数据的目录  

- mysql、hbase建表语句，kafka topic名称：  
    1. mysql建表语句在merchants应用下resourses目录里的merchants.sql  
    2. hbase建表语句在passbook应用下resourses目录里的passbook.hsh
    3. kafka topic名称为merchants-template
    
- 需要清空的数据:
    1. hbase 的四张表
    2. mysql 商户数据
    3. 你存放优惠券token目录下面的优惠券 token 数据
    4. redis 中的数据  
- 测试方法及测试用例分别为merchants应用的resourses目录下的merchantsCode.txt和passbook应用的resourses目录下的passbookCode.txt。这两个文件里也记录了我的测试结果。测试顺序为先测试商户应用，再测试用户应用。
