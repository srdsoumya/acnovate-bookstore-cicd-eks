pipeline{
    agent any
    triggers {
      pollSCM '* * * * *'
    }
    stages{
        stage("SCM"){
            steps{
				def mavenHome = tool name: 'mvn', type: 'maven'
				sh "${mavenHome}/bin/mvn install" 
            }
        }
    }
}