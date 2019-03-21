## dubbo-paren 

dubbo demo 工程
### 参考地址
https://www.cnblogs.com/LUA123/p/10287129.html

### 负载均衡（启动多个service）
如果要启动多个service，需要修改服务端口和dubbo端口
<br>`server.port=9999`
<br>`dubbo.protocol.port = 20880`

### 注意
1.安装zookeeper
  
  这里使用的本机，所以地址都是127.0.0.1，会占用8080端口
  
2.启动dubbo-admin
<br>由于dubbo-admin-2.6.6,使用前后端分离，所以需要单独启动。
<br>后端默认端口是8080，因为zk也会启动8080端口，所以我这里改成8082；
<br>前端默认端口是8081，但是后端端口是8080，所以需要改成8082
