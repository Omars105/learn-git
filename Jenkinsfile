def gv

pipeline {
    agent any
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "Groovy.script.groovy"
                }
            }
        }
        stage("test") {
            steps {
                script {
                    echo "hello from test"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage("build docker image") {
            steps {
                script {
                    gv.buildDockerImage()
                }
            }
        }
    }
}