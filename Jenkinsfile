
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
                    sh '''#!/bin/bash
mvn build-helper:parse-version versions:set \
-DnewVersion=\\${parsedVersion.majorVersion}.\\${parsedVersion.minorVersion}.\\${parsedVersion.nextIncrementalVersion}
'''
                    sh 'mvn versions:commit'

                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_TAG = "${version}-${BUILD_NUMBER}"
                }
            }
        }
        stage("build java application") {
            steps {
                script {
                    echo "hello from build java application"
                    sh 'mvn clean package'
                }
            }
        }
        stage("build docker image") {
            steps {
                script {
                    echo "hello from build docker image"
                    sh "docker build -t omar1015/omar-test:jma-$IMAGE_TAG ."
                    withCredentials([usernamePassword(credentialsId: 'omar-dockerhub-repo', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASSWORD')]) {
                        sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USER --password-stdin'
                        sh "docker push omar1015/omar-test:jma-$IMAGE_TAG"
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
        stage('commit version in git') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'Github-jenkins-pat', usernameVariable: 'GIT_USER', passwordVariable: 'GIT_TOKEN')]) {
                        sh "git config user.name ${GIT_USER}"
                        sh 'git config user.email "jenkins@example.com"'
                        sh 'git status'
                        sh 'git branch'
                        sh 'git config --list'
                        sh "git remote set-url origin https://${GIT_USER}:${GIT_TOKEN}@github.com/Omars105/learn-git.git"
                        sh 'git add .'
                        sh "git commit -m 'version incremented to ${IMAGE_TAG}'"
                        sh 'git push origin HEAD:increment-version-test'
                    }
                }
            }
        }
    }
}