pipeline {
    agent { label 'master' }
    tools {
        git 'git'
        maven 'maven'
        jdk 'java8'
    }
    stages {
        stage('Pull Repo') {
            steps {
                //git 'https://github.com/mpp04/hotbev_coffee.git'
                bat 'git clone https://github.com/mpp04/hotbev_coffee.git'
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