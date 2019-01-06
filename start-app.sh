# start-app.sh
# 镜像单容器启动
services=("search-service" "sso-service" "order-service" "manager-service" "content-service" "cart-service")
apps=("manager-web" "portal-web" "search-web" "item-web" "sso-web" "cart-web" "order-web")

function start(){
    if [ $(docker ps -a | grep -c "$1") -gt 0 ]; then
        if [ $(docker ps | grep -c "$1") -lt 1 ]; then
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
for service in ${services[@]};
do
    start "mymall-$service" "docker run --name mymall-$service -d jahentao/mymall-$service:1"
done

echo "待启动Web应用个数为: ${#apps[*]}"
for i in ${!apps[@]};
do
    let index=$i+1
    start "mymall-app-${apps[$i]}" "docker run --name mymall-app-${apps[$i]} -p 808$index:808$index -d jahentao/mymall-${apps[$i]}:1"
done

echo "setup all"
