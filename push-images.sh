#@IgnoreInspection BashAddShebang
# push-images.sh
services=("manager-service" "content-service" "search-service" "sso-service" "cart-service" "order-service")
apps=("dubbo-admin" "manager-web" "portal-web" "search-web" "item-web" "sso-web" "cart-web" "order-web")
tag=1

for i in ${!services[@]};
do
    service=${services[$i]}
    echo "pushing... jahentao/mymall-$service:$tag"
    docker push "jahentao/mymall-$service:$tag"
done

for i in ${!apps[@]};
do
    echo "pushing... jahentao/mymall-${apps[$i]}:$tag"
    docker push "jahentao/mymall-${apps[$i]}:$tag"
done
