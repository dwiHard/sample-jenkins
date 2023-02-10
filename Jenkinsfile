pipeline {
    agent {
        docker { image 'maven:3.8.7-eclipse-temurin-11' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
