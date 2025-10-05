pipeline {
    agent any

    tools {
        maven 'Maven_3.9'
        jdk 'JDK_17'
    }

    stages {
        stage('Checkout') {
            steps {
                deleteDir() // limpa o workspace antes do clone
                git branch: 'main',
                    url: 'https://github.com/EliseuFelipe/jenkins.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t meuapp:1.0 .'
                }
            }
        }

        stage('Run Container (opcional)') {
            steps {
                script {
                    sh 'docker rm -f meuapp || true'  // força remoção se existir
                    sh 'docker run -d -p 8080:8080 --name meuapp meuapp:1.0'
                }
            }
        }
    }

    post {
        always {
            sh 'docker ps -a'   // só para debug
        }
    }
}
