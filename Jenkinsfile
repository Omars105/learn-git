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
        stage("build Docker image") {
            steps {
                script {
                    dockerBuild 'omar1015/omar-test:jma-3.0'
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
