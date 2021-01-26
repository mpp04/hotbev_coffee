pipeline {
    agent any
    environment { //defined here applies to whole script, else if defined in a stage, defines in stage
        TEST = 'Hello World!'
        GHK = credentials('GitHubCreds') //will subsequently create: ${GHK_USR} and ${GHK_PSW}.

    }
    parameters {
        string(name: 'TEST_STATEMENT', defaultValue: 'hello; ls /', description: 'What should I say?')
    }

    stages {
        stage('ENVIRONMENT TEST STAGE') {
            echo "Expressing testvar using env.TEST for testing purposes is: ${env.TEST}"
            echo "Expressing DollarSignGHK_USR for testing purposes: $GHK_USR"
            // OBSERVE:
            // ' ' will evaluate the $VAR but would not display its contents (interpolate)
            // " " will evaluate the $VAR and will display its contents (interpolate)
            // Use ' ' for evaluating variables
            // NOTE:
            // ' ' go with $VAR ;evaluates
            // " " go with ${VAR} ;interpolates and evaluate
            def test_variable = 'Yes, indeed I am a test variable declared using def'
            echo "Interpolating test_variable declared using def, thus: ${test_variable}"
            sh('echo testing parameter TEST_STATEMENT thus: ${params.TEST_STATEMENT}')
                // use single ' ' and not " " OR agent will execute "ls /"

        }
        stage('GET ENVIRONMENT INFO ') {

            steps {
                sh("echo REPO_URL is ${env.REPO_URL}")
                sh("echo current folder is")
                sh("pwd")
                sh("ls")
                sh("git clone ${env.REPO_URL}")
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                //sh 'make check || true'
                //ensures that the sh step always sees a zero exit code before next step. USE bat for WS systems
                // known as in-line shell condition
                mvn test
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
                //sh 'make' //must return zero error code for line to continue!
                //archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
                sh("echo current folder is")
                sh("pwd")
                sh("ls")
                mvn clean install
                sh("docker build -t $env.DR/$env.DT1 .")
            }
        }
    }
    stage('Deploy') {
        steps {
            echo 'Deploying....'
            when {
                expression {
                    currentBuild.result == null || currentBuild.result == 'SUCCESS'
                    // currentBuild.result variable helps line determine if test failures
                }
            }

        }
    }

}