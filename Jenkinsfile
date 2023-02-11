pipeline {
    agent any
    stages {
        stage('Compile') {
            steps {
                sh 'mvn --version'
                sh 'mvn package'
            }
        }
        stage('Deploy') {
            steps {
                sh """
                #!/bin/bash
                cd /home/hard/Apache/apache-storm/bin
                python storm.py jar ~/.jenkins/workspace/simple-jenkins/target/simple-jenkins.jar id.fivebyte.TopologyMain
                python storm list
                """
            }
        }
    }
}
