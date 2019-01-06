# stop-app.sh
docker rm -f mymall-app-dubbo-admin \
             mymall-search-service  \
             mymall-sso-service     \
             mymall-order-service   \
             mymall-manager-service \
             mymall-content-service \
             mymall-cart-service    \
             mymall-app-manager-web \
             mymall-app-portal-web  \
             mymall-app-search-web  \
             mymall-app-item-web    \
             mymall-app-sso-web     \
             mymall-app-cart-web    \
             mymall-app-order-web   
