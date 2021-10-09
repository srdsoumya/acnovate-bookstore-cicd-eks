pipeline{
    agent any
    triggers {
      pollSCM '* * * * *'
    }
    stages{
        stage("SCM"){
			withMaven {
			  sh "mvn install"
			} // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
        }
    }
}