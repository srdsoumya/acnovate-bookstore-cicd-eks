pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
				sh 'mvn clean' 
				sh 'mvn compiler:compile'
                sh 'mvn install' 
            }
        }
    }
}