def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.9'
        dockerTool 'my-docker-cli'
    }
    stages {
        stage('init'){
            steps{
                script { 
                gv = load "./Groovy.script.groovy"
            }
        }
        stage('Build jar') {
            steps {
                script {
                gv.buildJar()
            }
        }
        }

          stage('Build docker image') {
            steps {
                script {
                gv.buildDockerImage()   
                }
            }
        }
        }

        stage('Deploy') {
            steps {
                script {
                    gv.deployApp()   
                    
                }
                
            }
        }
     
 }
}
    
