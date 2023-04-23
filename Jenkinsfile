pipeline {
  agent any

  stages {
    stage('Git Clone') {
      steps {
        // Get some code from a GitHub repository
        git credentialsId: '8f05a564-bb5f-42e9-be53-3968377ecccd', url: 'https://github.com/imajeetyadav/DevOps-Project.git'
      }
    }
    stage('Build') {
      steps {
        sh "echo test"
      }
    }
  }
  post {
    always {
      // One or more steps need to be included within each condition's block.
      cleanWs()
    }
  }
}