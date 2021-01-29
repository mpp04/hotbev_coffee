pipeline {
    agent none
    stages {
        stage('TEST,BUILD AND PUSH ON PRESLAV'){
            agent {
                label 'master'
            }
            steps {
                git url: 'https://github.com/mpp04/hotbev_coffee.git', branch: 'dev'
                bat 'dir'
                bat 'mvn test'
                bat 'docker build -t mpp04/hotbev_coffee .'
                bat "docker login -u ${env.DOCKER_USR} -p $env.DOCKER_PWD"
                bat 'docker push mpp04/hotbev_coffee'
            }
        }
        stage('DEPLOY ON EC2'){
            agent {
                label 'slave'
            }
            steps {
                sh 'echo $HOME' //ensure user ubuntu and jenkins are added to sudoers file
                // sh 'sudo service docker restart'
                sh 'sudo docker stop coffee'
                sh 'sudo docker rm coffee'
                sh "sudo docker login -u $env.DOCKER_USR -p $env.DOCKER_PWD"
                sh 'sudo docker pull mpp04/hotbev_coffee'
                sh 'sudo docker run -d -p 8091:8091 --name coffee mpp04/hotbev_coffee'
            }
        }
    }
}
//test