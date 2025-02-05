// vars/deployStage.groovy

def call(String build_number) {
            sh 'curl ifconfig.me'
            sh 'curl -L -u "${ARTIFACTORY_CREDENTIALS_USR}:${ARTIFACTORY_CREDENTIALS_PSW}" -O "http://65.2.172.21:8082/artifactory/jenkins-hello-world-libs-release/com/efsavage/hello-world-war/${build_number}/hello-world-war-${build_number}.war"'
            sh 'ls'
            sh 'sudo cp hello-world-war-${build_number}.war /opt/tomcat/apache-tomcat-10.1.34/webapps/'
            sh 'sudo bash /opt/tomcat/apache-tomcat-10.1.34/bin/shutdown.sh'
            sh 'sudo bash /opt/tomcat/apache-tomcat-10.1.34/bin/startup.sh'
}

