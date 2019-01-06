# 1. mymall-dubbo-admin
cd mymall-dubbo-admin
mvn package -Dmaven.test.skip=true
docker build -t jahentao/mymall-dubbo-admin:1 -f Dockerfile .
# docker run --name mymall-test-dubbo-admin -p 7001:7001 -d jahentao/mymall-dubbo-admin:1
# docker rm -f mymall-test-dubbo-admin
# docker image rm jahentao/mymall-dubbo-admin:1
cd ..

# 2. mymall-cart
cd mymall-cart/mymall-cart-service
mvn package -Dmaven.test.skip=true
docker build -t jahentao/mymall-cart-service:1 -f Dockerfile .
cd ../..

# 3. mymall-content
cd mymall-content/mymall-content-service
mvn package -Dmaven.test.skip=true
docker build -t jahentao/mymall-content-service:1 -f Dockerfile .
cd ../..

# 4. mymall-manager
cd mymall-manager/mymall-manager-service
mvn package -Dmaven.test.skip=true
docker build -t jahentao/mymall-manager-service:1 -f Dockerfile .
cd ../..

# 5. mymall-order
cd mymall-order/mymall-order-service
mvn package -Dmaven.test.skip=true
docker build -t jahentao/mymall-order-service:1 -f Dockerfile .
cd ../..

# 6. mymall-sso
cd mymall-sso/mymall-sso-service
mvn package -Dmaven.test.skip=true
docker build -t jahentao/mymall-sso-service:1 -f Dockerfile .
cd ../..

# 7. mymall-search
cd mymall-search/mymall-search-service
mvn package -Dmaven.test.skip=true
docker build -t jahentao/mymall-search-service:1 -f Dockerfile .
cd ../..

#--------------------------
# 1. mymall-cart-web
cd mymall-cart-web
mvn package -Dmaven.test.skip=true
docker build -t jahentao/mymall-cart-web:1 -f Dockerfile .
cd ..

# 2. mymall-item-web
cd mymall-item-web
mvn package -Dmaven.test.skip=true
docker build -t jahentao/mymall-item-web:1 -f Dockerfile .
cd ..

# 3. mymall-order-web
cd mymall-order-web
mvn package -Dmaven.test.skip=true
docker build -t jahentao/mymall-order-web:1 -f Dockerfile .
cd ..

# 4. mymall-portal-web
cd mymall-portal-web
mvn package -Dmaven.test.skip=true
docker build -t jahentao/mymall-portal-web:1 -f Dockerfile .
cd ..

# 5. mymall-search-web
cd mymall-search-web
mvn package -Dmaven.test.skip=true
docker build -t jahentao/mymall-search-web:1 -f Dockerfile .
cd ..

# 6. mymall-sso-web
cd mymall-sso-web
mvn package -Dmaven.test.skip=true
docker build -t jahentao/mymall-sso-web:1 -f Dockerfile .
cd ..

# 7. mymall-manager-web
cd mymall-manager/mymall-manager-web
mvn package -Dmaven.test.skip=true
docker build -t jahentao/mymall-manager-web:1 -f Dockerfile .
cd ../..