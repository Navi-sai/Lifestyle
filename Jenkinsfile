pipeline{
    agent any

    environment {
       ENV_FILE = credentials('LIFESTYLE_ENV')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo 'Checking out lifestyle project...'
            }
        }
        stage('Load environment properties') {
            steps {
                echo 'Loading environmental variables...'
                writeFile file: 'lifestyle-env.properties', text: ENV_FILE
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