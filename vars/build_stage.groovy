// vars/build_stage.groovy

def call(){
   sh 'mvn clean package'
        sh 'ls'
}
