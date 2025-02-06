// vars/publish_stage_1.groovy

def call() {
            sh 'mkdir -p ~/.m2'
            sh '''
            echo "<settings>
                    <servers>
                        <server>
                          <id>new-hello-world-war-libs-release</id>
                          <username>$ARTIFACTORY_CREDENTIALS_USR</username>
                          <password>$ARTIFACTORY_CREDENTIALS_PSW</password>
                        </server>
                      </servers>
                    </settings>" > ~/.m2/settings.xml
            '''
            sh 'cat ~/.m2/settings.xml'
            sh 'mvn clean deploy'
}
