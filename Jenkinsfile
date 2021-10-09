pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
				sh 'mvn clean'  
            }
			steps {
                sh 'mvn install' 
            }
        }
    }
}