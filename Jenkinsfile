pipeline{
  agent any
  stages{
    stage("build")
    {
      steps{
        echo 'building the application'
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
        echo 'testing the application IN master BRANCH'     
      }
    }
      stage("deploy")
    {
      steps{
        echo 'deploying the application'
      }
    }
  }
  post{
    always{
      echo 'post running always' 
    }
    success{
     echo 'post running for success' 
    }
  }
}
