FROM nginx:1.14
COPY nginx.conf /etc/nginx/nginx.conf
ADD access.log /etc/nginx/logs/access.log
ADD mymall-static.tar.gz /mymall-static
ADD mymall-upload.tar.gz /mymall-upload
EXPOSE 80
