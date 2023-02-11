pipeline {
    agent {
        docker { image 'maven:3.8.7-eclipse-temurin-11' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn --version'
                sh 'mvn package'
                    sh """
                    #!/bin/bash
                    cd /home/hard/Apache/apache-storm/bin
                    python storm jar ~/.jenkins/workspace/simple-jenkins/targets/simple-jenkins.jar id.fivebyte.TopologyMain
                    python storm list
                    """
            }
        }
    }
}
