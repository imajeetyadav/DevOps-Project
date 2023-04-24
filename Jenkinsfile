pipeline {
  agent any

  stages {
    stage('Maven Test') {
      steps {
        sh "mvn clean test"
      }
    }
    stage('Maven Build') {
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
    stage('Docker Push and cleanup') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
                    sh "docker login -u $DOCKER_HUB_USERNAME -p $DOCKER_HUB_PASSWORD"
                    sh "docker push imajeetyadav/$JOB_NAME:$BUILD_ID"
                    sh "docker push imajeetyadav/$JOB_NAME:latest"
                    sh "docker logout"
            }        
        sh "docker image rmi imajeetyadav/$JOB_NAME:latest imajeetyadav/$JOB_NAME:$BUILD_ID"
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