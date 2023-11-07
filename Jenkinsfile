pipeline {
    agent any
    environment
    {
        registry = "chinx23/calculator-devops"
        registryCredential = "dockersignin"
        dockerImage = ""
    }
    stages {
        stage('Pull from GitHub') {
            steps {
                git branch: 'main', url: 'https://github.com/Chinthan23/Calculator-Devops.git'
            }
        }
        stage('Build maven') {
            steps {
                script{
                    sh 'mvn clean install'
                }
            }
        }
        stage('Docker Image Build') {
            steps {
                script {
                    dockerImage = docker.build(registry + ":latest")
                }
            }
        }
        stage('DockerHub Image Push') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Cleaning Up') {
            steps {
                sh "docker rmi $registry:latest"
            }
        }
        stage('Execute Ansible') {
            steps {
                ansiblePlaybook colorized: true,
                installation: 'Ansible',
                inventory: 'inventory',
                playbook: 'playbook.yml'
            }
        }
    }
}