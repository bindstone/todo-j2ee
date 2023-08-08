FROM quay.io/wildfly/wildfly

  # docker run -p 8080:8080 -p 9990:9990 -it quay.io/wildfly/wildfly /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0
EXPOSE 8080
EXPOSE 9990

ADD target/todo.war /opt/jboss/wildfly/standalone/deployments/
RUN wildfly/bin/add-user.sh -u admin -p admin --silent

ENTRYPOINT ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0" ,"-bmanagement", "0.0.0.0"]