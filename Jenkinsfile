
pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages {
        stage('increment version') {
            steps {
                script {
                    echo "hello from increment version"
                    sh 'mvn build-helper:parse-version versions:set -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.nextIncrementalVersion} versions:commit'
                    def Omar = readFile('pom.xml')   =~ '<version>(.+)</version>'
                    def version = Omar[0][1]
                    env.IMAGE_TAG = "version-$BUILD_NUMBER"

                   
                }
            }
        }
        stage("build java application") {
            steps {
                script {
                    echo "hello from build java application"
                    sh 'mvn package'
                }
            }
        }
        stage("build docker image") {
            steps {
                script {
                    echo "hello from build docker image"
                    sh "docker build -t omar1015/omar-test:$IMAGE_TAG ."
                    withCredentials([usernamePassword(credentialsId: 'omar-dockerhub-repo', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASSWORD')]) {
                        sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USER --password-stdin'
                        sh "docker push omar1015/omar-test:$IMAGE_TAG"
                    }   
                }
            }
        }
        stage("deploy application") {
            steps {
                script {
                    echo 'hello from deploy application'
                }
            }
        }
    }
}