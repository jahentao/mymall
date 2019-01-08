#@IgnoreInspection BashAddShebang
# start-app.sh
# 镜像单容器启动
services=("manager-service" "content-service" "search-service" "sso-service" "cart-service" "order-service")
apps=("manager-web" "portal-web" "search-web" "item-web" "sso-web" "cart-web" "order-web")

function start() {
    if [[ $(docker ps -a | grep -c "$1") -gt 0 ]]; then
        if [[ $(docker ps | grep -c "$1") -lt 1 ]]; then
           echo "$1 starting..."
           docker start $1
        fi
    else
        echo "$1 setup..."
        $2
    fi
}

# 单独启动dubbo-admin
start "mymall-app-dubbo-admin" "docker run --name mymall-app-dubbo-admin -p 7001:7001 -d jahentao/mymall-dubbo-admin:1"

echo "待启动应用服务个数为: ${#services[*]}"
for i in ${!services[@]};
do
    service=${services[$i]}
    start "mymall-$service" "docker run --name mymall-$service -p 2088$i:2088$i -d jahentao/mymall-$service:1"
done

# 等待服务都启动完成，否则Web应用启动无法提供服务
echo "休息1分钟，等待服务启动完毕..."
sleep 1m

echo "待启动Web应用个数为: ${#apps[*]}"
for i in ${!apps[@]};
do
    let index=$i+1
    start "mymall-app-${apps[$i]}" "docker run --name mymall-app-${apps[$i]} -p 808$index:808$index -d jahentao/mymall-${apps[$i]}:1"
done

echo "setup all"
echo "请耐心等待大约2分钟，Web应用启动完毕后访问..."
sleep 2m
