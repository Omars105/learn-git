pipeline {
    agent any 
    parameters {
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Version to build')
        choice(name: 'BRANCH', choices: ['main', 'develop'], description: 'Branch to build')
        booleanParam(name: 'DEPLOY', defaultValue: false, description: 'Deploy to server')

    }
   
    stages {
        stage('init') {
           

            steps {
                script {
                    gv = load "Groovy.script.groovy"

                }
            }
        } // Closes Stage

        stage('Build') {
           
            steps {
                script {
                    gv.buildApp()
                }

            } // Closes Steps
        } // Closes Stage
        
        stage('Test') {
            steps {
                script {
                    gv.testApp()
                }
            }
        } // Closes Stage

        stage('Deploy') {
            steps {
                script {
                    gv.deployApp()
                }
            }
        } // Closes Stage
    } // Closes ALL Stages
} // Closes the Pipeline (This is likely the one you are missing!)
