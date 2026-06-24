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
                    dockerBuild()
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
