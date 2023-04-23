pipeline {
  agent any

  stages {
    stage('Git Clone') {
      steps {
        // Get some code from a GitHub repository
        git 'git@github.com:imajeetyadav/DevOps-Project.git'
      }
    }
    stage('Build') {
      steps {
        sh "echo test"
      }
    }
  post {
    always {
      // One or more steps need to be included within each condition's block.
      cleanWs()
    }
  }
}