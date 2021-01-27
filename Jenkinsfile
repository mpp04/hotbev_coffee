pipeline {
    agent { label 'master' }
    stages {
        stage('Pull Repo') {
            steps {
                git 'https://github.com/mpp04/hotbev_coffee.git'
                }
        }
        stage('Build and Push using Docker') {
            steps {
                bat 'docker build -t mpp04/coffee_service .'
                bat 'docker push mpp04/coffee_service'
            }
        }

    }
}