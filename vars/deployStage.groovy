// vars/deployStage.groovy

def call(String build_number, String artifactory_ip) {
            echo " ${artifactory_ip}"
            echo "${build_number}"
            sh """
            curl -L -u "${ARTIFACTORY_CREDENTIALS_USR}:${ARTIFACTORY_CREDENTIALS_PSW}" -O "http://${artifactory_ip}:8082/artifactory/jenkins-hello-world-libs-release/com/efsavage/hello-world-war/com/efsavage/hello-world-war/${build_number}/hello-world-war-${build_number}.war"
            """
            sh """
            sudo cp hello-world-war-${build_number}.war /opt/tomcat/apache-tomcat-10.1.34/webapps/
            """
            sh 'sudo cat /opt/tomcat/apache-tomcat-10.1.34/webapps/hello-world-war-${build_number}.war'
            sh 'sudo bash /opt/tomcat/apache-tomcat-10.1.34/bin/shutdown.sh'
            sh 'sudo bash /opt/tomcat/apache-tomcat-10.1.34/bin/startup.sh'
}

