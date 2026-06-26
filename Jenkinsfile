#!/usr/bin/env groovy
@Library('Jenkins-shared-library') _


def gv 


pipeline {
    agent any
tools   {
    maven 'maven-3.9'
}
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "Groovy.script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    buildJava()
                }
            }
        }
        stage("build,login and push docker image") {
            steps {
                script {
                    dockerBuild 'omar1015/omar-test:jma-4.0'
                    dockerlogin()
                    dockerpush 'omar1015/omar-test:jma-4.0'
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
