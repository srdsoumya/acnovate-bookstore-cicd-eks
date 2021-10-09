pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
				sh 'mvn clean' 
				sh 'mvn install -Dmaven.compiler.fork=true -Dmaven.compiler.executable=/usr/lib/jvm/java-openjdk/bin/javac'
            }
        }
    }
}