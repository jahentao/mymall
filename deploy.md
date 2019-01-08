# 部署

将应用打包成镜像，发布到镜像仓库。当前的镜像是在Linux环境下打包和测试的。

## 通过镜像单机部署

注意仅适用于单机本地虚拟机部署，虚拟机需要分配足够多的资源。

需要先配置好依赖的所有环境，参考[README](Readme.md)。然后启动项目容器。

以在虚拟机`192.168.237.201`中部署项目为例，注意修改`docker-compose.yaml`。

1. **修改hosts**
需要在宿主机上修改hosts，参考[hosts](configure/vm/hosts)。

```bash
sed -i 's/192.168.237.100/192.168.237.201/g' /root/workspace/vm/hosts
cat /root/workspace/vm/hosts >> /etc/hosts
```

2. **修改nginx**
同样在虚拟机中启动一个nginx反向代理服务器，参考[配置](configure/vm/nginx.conf)，以下以放置在`/root/workspace/vm/nginx.conf`为例。
其中配置了`mymall-static`和`mymall-upload`两个静态资源服务器，资源文件分别放在了`/root/workspace/mymall-static`和`/root/workspace/mymall-upload`下。

- 在启动之前需要修改`/root/workspace/vm/nginx.conf`中的IP地址，如将`192.168.237.100`修改为`192.168.237.201`

```bash
sed -i 's/192.168.237.100/192.168.237.201/g' /root/workspace/vm/nginx.conf
```

- 解压mymall-static 静态资源至`/root/workspace/mymall-static`

```bash
mkdir /root/workspace/mymall-static -p
unrar x mymall-static.rar ./mymall-static
```

- 解压mymall-upload 静态资源至/root/workspace/mymall-upload

```bash
mkdir /root/workspace/mymall-upload -p
unrar x mymall-static.rar ./mymall-upload
```





```bash
docker pull nginx:1.14 
#1. 在启动之前需要修改nginx.conf中的IP地址
docker run \
  --name mymall-nginx \
  -d -p 80:80 \
  -v /root/workspace/vm/nginx.conf:/etc/nginx/nginx.conf \
  -v /root/workspace/mymall-static:/mymall-static \
  -v /root/workspace/mymall-upload:/mymall-upload \
  nginx:1.14
```


```bash
# 安装Docker Compose
sudo curl -L "https://github.com/docker/compose/releases/download/1.23.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
# 在启动docker-compose up之前，使用环境变量来配置compose
export MY_HOST=192.168.237.201
# 可以使用`docker-compose config`命令来打印出来
docker-compose config
```

### 启动项目

启动项目前，除了依赖的环境，需要本地构建好的镜像，参考[构建镜像](#构建镜像)，或[拉取镜像](#拉取镜像)。

```bash
./start-app.sh # 默认间隔1m

# 或者将应用服务和Web应用分开启动
#./start-service.sh
# 中间请间隔一段时间
#./start-web.sh
```

### 停止项目

```bash
./stop-app.sh
```


## 构建镜像
```bash
yum install -y maven git
git clone https://github.com/jahentao/mymall.git
cd mymall

# 构建Docker镜像
./build.sh
```
## 拉取镜像

