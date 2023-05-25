FROM centos:centos7.9.2009

RUN yum install httpd -y

WORKDIR /var/www/html

COPY Guarderia-Canina .

CMD apachectl -D FOREGROUND
