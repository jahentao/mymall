FROM nginx:latest

COPY index.html /usr/share/nginx/html/index.html
COPY entrypoint.sh /entrypoint.sh
ADD global.conf /etc/nginx/conf.d/
#ADD nginx.conf /etc/nginx/conf.d/
CMD ["/entrypoint.sh"]
