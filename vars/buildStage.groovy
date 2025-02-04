// vars/buildStage.groovy

def call() {
    stage('build') {
        agent { label 'build-server' }
        steps {
            sh 'mvn clean package'
        }
    }
}

