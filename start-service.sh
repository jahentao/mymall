#@IgnoreInspection BashAddShebang
# start-service.sh
# 镜像单容器启动
services=("manager-service" "content-service" "search-service" "sso-service" "cart-service" "order-service")

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

echo "待启动应用服务个数为: ${#services[*]}"
for i in ${!services[@]};
do
    service=${services[$i]}
    start "mymall-$service" "docker run --name mymall-$service -p 2088$i:2088$i -d jahentao/mymall-$service:1"
done

echo "setup all services"

