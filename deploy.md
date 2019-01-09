# 部署

将应用打包成镜像，发布到镜像仓库。当前的镜像是在Linux环境下打包和测试的。

## 通过容器部署

注意仅适用于单机本地虚拟机部署，虚拟机需要分配足够多的资源，当前启动应用以单容器部署，需要4~5G内存。

需要先配置好依赖的所有环境，参考[README](Readme.md)。然后启动项目容器。

以在虚拟机`192.168.237.201`中部署项目为例。

1. **修改hosts**
需要在宿主机上修改hosts，参考[hosts](configure/vm/hosts)。

2. **安装Docker Compose**

```bash
sudo curl -L "https://github.com/docker/compose/releases/download/1.23.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
# 在启动docker-compose up之前，使用环境变量来配置compose
export MYHOST=192.168.237.201
# 可以使用`docker-compose config`命令来打印出来
docker-compose config
```

3. **先启动应用服务**

不要直接运行`docker-compose up`，先启动应用服务
```bash
docker-compose start manager-service content-service search-service sso-service cart-service order-service
```
确定服务启动再启动，以`docker logs mymall-manager-service`为例，要看到`is await...`
```bash
INFO 6 --- [pool-1-thread-1] .d.c.e.AwaitingNonWebApplicationListener :  [Dubbo] Current Spring Boot Application is await...
```

4. **再启动Web应用**

```bash
docker-compose start manager-web portal-web search-web item-web sso-web cart-web order-web
```
确定服务启动再启动，以`docker logs mymall-manager-service`为例，要看到`is await...`

确定服务启动再启动，以`docker logs mymall-app-manager-web`为例，要看到`JVM running for`
```bash
INFO 6 --- [           main] z.c.s.m.ManagerServiceApplicationStarter : Started ManagerServiceApplicationStarter in 198.686 seconds (JVM running for 221.44)
```
