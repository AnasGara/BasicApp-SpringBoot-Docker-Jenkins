pipeline {
  agent any
  tools { maven 'maven' }
  options {
    skipDefaultCheckout(true)
    disableConcurrentBuilds()
    timeout(time: 20, unit: 'MINUTES')
    buildDiscarder(logRotator(numToKeepStr: '20'))
  }
  stages {
    stage('Checkout') {
      steps {
        deleteDir()
        checkout scm
      }
    }
    stage('Verify') {
      steps { sh 'mvn --batch-mode --no-transfer-progress clean verify' }
      post { always { junit 'target/surefire-reports/*.xml' } }
    }
    stage('Build image') {
      steps { sh 'docker build --tag "jenkins-hello:$BUILD_NUMBER" .' }
    }
    stage('Validate Compose') {
      steps { sh 'docker compose config --quiet' }
    }
  }
}
