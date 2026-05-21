def gv 

pipeline {
    agent any
  
    stages {
        stage('Initialize') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }
        stage('Build') {
            steps {
               script {
                   gv.build()
               }
            }
        }
        stage('Test') {
            steps {
               script {
                   gv.test()
               }
            }
        }
        stage('build image') {
            when {
                expression {
                    echo "Branch name is: ${env.BRANCH_NAME}"
                    return env.BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    gv.buildImage()
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    gv.deploy()
                }
            }
            }
        }
    post {
        always {
            echo 'This will always run after the stages.lets go s'
            // Add any cleanup or notification commands here
        }
        success {
            echo 'This will run only if the pipeline succeeds.'
            // Add any success notification commands here
        }
        failure {
            echo 'This will run only if the pipeline fails.'
            echo "the error message is: ${currentBuild.currentResult}"
            // Add any failure notification commands here
        }
    }
}