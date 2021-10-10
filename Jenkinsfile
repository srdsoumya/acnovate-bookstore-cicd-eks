pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
				cleanWs()
				sh 'mvn clean' 
				sh 'mvn install'
            }
        }
        stage ('Docker Build') {
            steps {
				sh 'docker version' 
            }
        }
    }
}