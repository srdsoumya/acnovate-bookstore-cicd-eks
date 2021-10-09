pipeline{
    agent any
    triggers {
      pollSCM '* * * * *'
    }
    stages{
        stage("SCM"){
            steps{
				withMaven {
				  sh 'mvn install'
				} 
            }
        }
    }
}