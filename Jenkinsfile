CODE_CHANGES = getGitChanges()
pipeline {
    agent any 
    parameters {
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Version to build')
        choice(name: 'BRANCH', choices: ['main', 'develop'], description: 'Branch to build')
        booleanParam(name: 'DEPLOY', defaultValue: false, description: 'Deploy to server')

    }
   
    stages {
        stage('Build') {
            when {
                expression {
                    parameters.DEPLOY == true
                }
            }

            steps {
                echo 'Building...'
              

            }
        } // Closes Stage
        
        stage('Test') {
            steps {
                echo 'Testing...'
                echo "${params.VERSION}"
            }
        } // Closes Stage
    } // Closes ALL Stages
} // Closes the Pipeline (This is likely the one you are missing!)
