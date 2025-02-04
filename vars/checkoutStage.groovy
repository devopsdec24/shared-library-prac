// vars/checkoutStage.groovy

def call() {
    stage('checkout') {
        agent { label 'build-server' }
        steps {
            sh 'ls'
            sh 'pwd'
        }
    }
}

