pipeline {
    agent any

    tools {
        maven 'Maven_3.9'   // Nome da instalação do Maven configurada no Jenkins
        jdk 'JDK_17'        // Nome da instalação do JDK configurada no Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'develop',
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
