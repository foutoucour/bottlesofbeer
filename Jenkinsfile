pipeline {
  agent {
    docker {
      image 'maven:3'
    }
    
  }
  stages {
    stage('') {
      steps {
        parallel(
          "Echo Path": {
            sh 'echo "PATH = ${PATH}"'
            
          },
          "echo Home": {
            sh 'echo "M2_HOME = ${M2_HOME}"'
            
          }
        )
      }
    }
    stage('echo message') {
      steps {
        sh 'echo \'This is a minimal pipeline.\''
      }
    }
    stage('Cleanup') {
      steps {
        cleanWs(skipWhenFailed: true)
      }
    }
  }
}