pipeline {
  agent any

  stages {
    stage('Maven Test') {
      steps {
        sh "mvn clean test"
      }
    }
    stage('Build') {
      steps {
        sh "mvn clean package"
      }
    }
    stage('Docker Build and tagging') {
      steps {
        sh "docker build -t imajeetyadav/$JOB_NAME:latest ."
        sh "docker image tag imajeetyadav/$JOB_NAME imajeetyadav/$JOB_NAME:$BUILD_ID"
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