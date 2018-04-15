
本集群的测试步骤：
1、打包eureka-ha-server及eureka-ha-client
    在各自对应的目录中分别执行：mvn clean package -Dmaven.test.skip=true
    说明：使用参数-Dmaven.test.skip=true以跳过测试

2、在jar包对应的目录下分别执行以下三个命令，以启动三个eureka-ha-server实例
    java -jar eureka-ha-server-1-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
    java -jar eureka-ha-server-1-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
    java -jar eureka-ha-server-1-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer3
    说明：通过--spring.profiles.active=peer3以指定使用哪个profile启动

3、启动eureka-ha-client

4、分别访问http://peer1:8761,http://peer1:8762,http://peer1:8763来查看