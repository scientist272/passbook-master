### ����Kafka��Hbase�Ŀ���Ӧ�ú��
- ��Ŀ˵����  
 ����Ŀ��Ϊ�̻����û�����Ӧ�ã��̻�Ӧ��Ϊmerchants���û�Ӧ��Ϊpassbook,��Ҫͬʱ��������Ӧ�ý��в��ԡ�  

  ����ĿΪ���Ӧ�ã�ͨ��http�ӿ������ù��ܣ�����json���ݡ�  

  �̻���Ϣ�洢��mysql�У��û���Ϣ�����ۡ��Ż�ȯ���Ż�ȯģ��洢��hbase�У��û�Ӧ�ú��̻�Ӧ��֮��ͨ��kafka��ʵ����Ϣ���й��ܣ����̻�Ӧ����Ϊ������Ͷ���Ż�ȯģ�嵽kafka�У��û�Ӧ����Ϊ����������kafka�е��Ż�ȯģ�岢����Hbase��

- ��Ҫ�����ķ���:
    hbase, mysql, kafka, redis
- ������Ŀ��Ҫ�޸ĵ����ݣ�
    1. resoursesĿ¼�µ�application.yml,��${yourhost}���޸�Ϊ���Լ���������ip��ַ�Ͷ˿ڵ�
    2. Contants���е�TOKEN_DIR,�����޸�Ϊ�����������������token���ݵ�Ŀ¼  

- mysql��hbase������䣬kafka topic���ƣ�  
    1. mysql���������merchantsӦ����resoursesĿ¼���merchants.sql  
    2. hbase���������passbookӦ����resoursesĿ¼���passbook.hsh
    3. kafka topic����Ϊmerchants-template
    
- ��Ҫ��յ�����:
    1. hbase �����ű�
    2. mysql �̻�����
    3. �����Ż�ȯtokenĿ¼������Ż�ȯ token ����
    4. redis �е�����  
- ���Է��������������ֱ�ΪmerchantsӦ�õ�resoursesĿ¼�µ�merchantsCode.txt��passbookӦ�õ�resoursesĿ¼�µ�passbookCode.txt���������ļ���Ҳ��¼���ҵĲ��Խ��������˳��Ϊ�Ȳ����̻�Ӧ�ã��ٲ����û�Ӧ�á�
