# 部署

将应用打包成镜像，发布到镜像仓库。当前的镜像是在Linux环境下打包和测试的。

## 通过镜像部署

需要先配置好依赖的所有环境，参考[README](Readme.md)。然后启动项目容器。

在虚拟机如`192.168.237.100`中部署项目容器，需要在宿主机上修改hosts，参考[hosts](配置/vm/hosts)。
同样在虚拟机中启动一个nginx反向代理服务器，参考[配置](配置/vm/nginx.conf)。

```bash
# 安装Docker Compose
sudo curl -L "https://github.com/docker/compose/releases/download/1.23.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose



```

### 启动项目

启动项目前，除了依赖的环境，需要本地构建好的镜像，参考[构建镜像](#构建镜像)，或[拉取镜像](#拉取镜像)。

```bash
./start-app.sh
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

