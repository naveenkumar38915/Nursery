pipeline {
    agent any

 

    stages {
        stage('git repo and clean') {
            steps {
                bat  "rmdir /s /q   Nursery-Backend"
                bat "git clone https://github.com/naveenkumar38915/Nursery.git"
                bat "mvn clean -f Nursery-Backend"
            }
        }
        stage('install') {
            steps {
                bat  "mvn install -f Nursery-Backend"
            }
        }
        stage('test') {
            steps {
                bat  "mvn test -f Nursery-Backend"
            }
        }
        stage('package') {
            steps {
            bat "mvn package -f Nursery-Backend"

            }
        }
    }
}
