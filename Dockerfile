FROM jboss/wildfly:latest

# Appserver
ENV WILDFLY_USER admin
ENV WILDFLY_PASS password

# Database
ENV DB_NAME todo
ENV DB_USER todo
ENV DB_PASS password
ENV DB_HOST postgres
ENV EE EEww

ENV POSTGRESQL_VERSION 9.4-1201-jdbc41

RUN echo "=> Adding WildFly administrator"
RUN $JBOSS_HOME/bin/add-user.sh -u $WILDFLY_USER -p $WILDFLY_PASS --silent

RUN /bin/sh -c '$JBOSS_HOME/bin/standalone.sh &' && \
  sleep 10 && \
  cd /tmp && \
  curl --location --output postgresql-${POSTGRESQL_VERSION}.jar --url http://search.maven.org/remotecontent?filepath=org/postgresql/postgresql/${POSTGRESQL_VERSION}/postgresql-${POSTGRESQL_VERSION}.jar && \
  $JBOSS_HOME/bin/jboss-cli.sh --connect --command="deploy /tmp/postgresql-${POSTGRESQL_VERSION}.jar" && \
  $JBOSS_HOME/bin/jboss-cli.sh --connect --command="xa-data-source add --name=todoData --jndi-name=java:/jdbc/datasources/todoDS --user-name=${DB_USER} --password=${DB_PASS} --driver-name=postgresql-9.4-1201-jdbc41.jar --xa-datasource-class=org.postgresql.xa.PGXADataSource --xa-datasource-properties=ServerName=${DB_HOST},PortNumber=5432,DatabaseName=${DB_NAME} --valid-connection-checker-class-name=org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLValidConnectionChecker --exception-sorter-class-name=org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLExceptionSorter" && \
  $JBOSS_HOME/bin/jboss-cli.sh --connect --command=:shutdown && \
  rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history/ $JBOSS_HOME/standalone/log/* && \
  rm /tmp/postgresql-9.4*.jar && \
  rm -rf /tmp/postgresql-*.jar

# Expose http and admin ports
EXPOSE 8080 9990

ADD target/todo-app.war /opt/jboss/wildfly/standalone/deployments/
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]