pipeline {
    agent any
    tools {
        maven 'maven-3.9'
        dockerTool 'my-docker-cli'
    }
    stages {
        stage('Build jar') {
            steps {
                script {
                echo 'Building the app...'
                sh 'mvn package'
            }
        }
        }

          stage('Build docker image') {
            steps {
                script {
                echo 'Building the docker image ...'
                withCredentials([usernamePassword(credentialsId: 'omar-dockerhub-repo', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh 'docker build -t omar1015/omar-test:jma-2.0 .'
                    sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USER --password-stdin'
                    sh 'docker push omar1015/omar-test:jma-2.0  '   
                }
            }
        }
        }

        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying...'
                    
                }
                
            }
        }
     
 }
}
    
