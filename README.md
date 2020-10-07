# sms-service
阿里云和activeMQ实现短信的验证功能

application.properties中修改：

server.port=9003
spring.activemq.broker-url=tcp://localhost:61616
accessKeyId=xxxx
accessKeySecret=xxxx

accessKeyId/accessKeySecret均为阿里云服务器中-管理accessKey页面中的两个参数
