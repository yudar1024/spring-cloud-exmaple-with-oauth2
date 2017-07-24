FROM anapsix/alpine-java:jre8
#update system timezone
#RUN set time zone
#timedatectl set-timezone Asia/Shanghai
#RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
ADD maven/Shanghai /etc/localtime
#update application timezone
RUN echo "Asia/Shanghai" >> /etc/timezone
#VOLUME /tmp
ADD maven/zuul-server-with-oauth2-jwt*.jar app.jar
RUN bash -c 'touch /app.jar'
#ENV JAVA_OPTS='-server -Duser.timezone=GMT+8'
#EXPOSE 9000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=GMT+8","-jar","/app.jar"]