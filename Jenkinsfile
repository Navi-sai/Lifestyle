pipeline{
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo 'Checking out lifestyle project...'
            }
        }
        stage('Load environment properties') {
            steps {
                    withCredentials([file(credentialsId: 'LIFESTYLE_ENV_FILE', variable: 'ENV_FILE')]) {
                    bat 'copy %ENV_FILE% lifestyle-env.properties'
                    bat 'type lifestyle-env.properties'
                }
            }
        }   

        stage('Build') {
            steps {
                bat ".\\mvnw clean package -Dspring.config.additional-location=lifestyle-env.properties"
                echo 'Building...'
            }
        }
    }
}