pipeline{
  agent any
  tools {
    maven 'Maven' 
  }
  environment {
   ENVIRONMENT_URL = 'merge10' 
  }
  stages{
    stage("build")
    {
      steps{
        echo "building the application ${ENVIRONMENT_URL}"
      }
    }
      stage("test")
    { 
      when{
      expression{
        BRANCH_NAME == 'master'
      }
    }
      steps{
        echo "testing the application IN master BRANCH ${ENVIRONMENT_URL}" 
        sh "cd /var/lib/jenkins/workspace/SeleniumCucumberPipelinee_master/libs"
        sh "chmod +x chromedriver"
        sh "mvn test"
      }
    }
      stage("deploy")
    {
      steps{
        echo "deploying the application ${ENVIRONMENT_URL}"
      }
    }
  }
  post{
    always{
      echo "post running always ${ENVIRONMENT_URL}"
    }
    success{
     echo "post running for success ${ENVIRONMENT_URL}"
    }
  }
}
