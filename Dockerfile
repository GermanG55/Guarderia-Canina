FROM centos:centos7.9.2009

RUN yum install httpd -y

WORKDIR /var/www/html

COPY guarderia-canina .

CMD apachectl -D FOREGROUND
