// vars/deploy_stage.groovy

def call(String build_number, String artifactory_ip) {
        sh '''
        curl -L -u "${ARTIFACTORY_CREDENTIALS_USR}:${ARTIFACTORY_CREDENTIALS_PSW}" -O "http://${artifactory_ip}/artifactory/helloworldwar-cicd-libs-release/com/efsavage/hello-world-war/${build_number}/hello-world-war-${build_number}.war"
        '''
        sh 'ls'
        sh 'sudo cp hello-world-war-${build_number}.war /opt/tomcat/apache-tomcat-10.1.34/webapps/'
        sh 'sudo bash /opt/tomcat/apache-tomcat-10.1.34/bin/shutdown.sh'
        sh 'sleep 20'
        sh 'sudo bash /opt/tomcat/apache-tomcat-10.1.34/bin/startup.sh'
}
