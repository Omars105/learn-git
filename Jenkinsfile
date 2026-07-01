pipeline {
    agent any
    stages {
        stage("test") {
            steps {
                script {
                    echo "hello from test "
                    echo "Executing the pipeline for branch : ${BRANCH_NAME}"
                }
            }
        }
        stage("build jar") {
            when {
                expression {
                    BRANCH_NAME == "main"
                }
            }
            steps {
                script {
                    echo "hello from build jar"
                }
            }
        }
        stage("deploy") {
            when {
                expression {
                    BRANCH_NAME == "main"
                }
            }
            steps {
                script {
                    echo "hello from deploy"
                }
            }
        }
    }
}