pipeline {
    agent any

    tools {
        // Use the installed Maven version
        maven "MAVEN"
        jdk "JDK"
       
    }

    stages {
        stage('Build ConfigServer') {
            steps {
                // Get code from your GitHub repository and the ConfigServer folder
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/Ibrahim25-ai/springProject.git']]])
                dir('ConfigServer') {
                    // Run Maven on a Unix agent.
                    sh "mvn -Dmaven.test.failure.ignore=true clean package"
                }
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/ConfigServer/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'ConfigServer/target/*.jar'
                }
            }
        }
        
        stage('Build and Push Docker Image ConfigServer') {
            steps {
                dir('ConfigServer') {
                    // Build Docker image
                    script {
                        sh 'docker build -t maheribrahim/devops2023:config-server-latest .'
                        
                    }

                    // Push Docker image
                    script {
                         sh 'docker login -u ibrahim12aze -p ?Rw#.nwf%2wQiE''
                         sh 'docker push maheribrahim/devops2023:config-server-latest'
                          // Run a command inside the Docker container
                       
                        sh 'docker run -d --net host maheribrahim/devops2023:config-server-latest'
                    }
                }
            }
        
        }
        stage('Build registryService') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/Ibrahim25-ai/springProject.git']]])
                 dir('registryService') {
            sh "mvn clean package -DskipTests"
            }
        }

    post {
        success {
            archiveArtifacts 'registryService/target/*.jar'
        }
            }
        }
        stage('Build and Push Docker Image registryService') {
            steps {
                dir('registryService') {
                    // Build Docker image
                    script {
                        sh 'docker build -t maheribrahim/devops2023:registry-service-latest .'
                        
                    }

                    // Push Docker image
                    script {
                         
                         sh 'docker push maheribrahim/devops2023:registry-service-latest'
                         sh 'docker run -d maheribrahim/devops2023:registry-service-latest'
                    }
                }
            }
        
        }
        stage('Build Gateway-service') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/Ibrahim25-ai/springProject.git']]])
                dir('Gateway-service') {
                    sh "mvn -Dmaven.test.failure.ignore=true clean package"
                }
            }

            post {
                success {
                    junit '**/Gateway-service/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'Gateway-service/target/*.jar'
                }
            }
        }
        stage('Build and Push Docker Image Gateway-service') {
            steps {
                dir('Gateway-service') {
                    // Build Docker image
                    script {
                        sh 'docker build -t maheribrahim/devops2023:gateway-service-latest .'
                        
                    }

                    // Push Docker image
                    script {
                       
                         sh 'docker push maheribrahim/devops2023:gateway-service-latest'
                         sh 'docker run -d maheribrahim/devops2023:gateway-service-latest'
                    }
                }
            }
        
        }
        stage('Build Evenement-service') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/Ibrahim25-ai/springProject.git']]])
                dir('Evenement-service') {
                    sh "mvn clean package -DskipTests"
                }
            }

            post {
                success {
                    
                    archiveArtifacts 'Evenement-service/target/*.jar'
                }
            }
        }
        stage('Build and Push Docker Image Evenement-service') {
            steps {
                dir('Evenement-service') {
                    // Build Docker image
                    script {
                        sh 'docker build -t maheribrahim/devops2023:evenement-service-latest .'
                        
                    }

                    // Push Docker image
                    script {
                         
                         sh 'docker push maheribrahim/devops2023:evenement-service-latest'
                         sh 'docker run -d maheribrahim/devops2023:evenement-service-latest'
                    }
                }
            }
        
        }
        stage('Build Outil-service') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/Ibrahim25-ai/springProject.git']]])
                dir('Outil-service') {
                    sh "mvn clean package -DskipTests"
                }
            }

            post {
                success {
                    
                    archiveArtifacts 'Outil-service/target/*.jar'
                }
            }
        }
        stage('Build and Push Docker Image Outil-service') {
            steps {
                dir('Outil-service') {
                    // Build Docker image
                    script {
                        sh 'docker build -t maheribrahim/devops2023:outil-service-latest .'
                        
                        
                    }

                    // Push Docker image
                    script {
                         
                         sh 'docker push maheribrahim/devops2023:outil-service-latest'
                         sh 'docker run -d maheribrahim/devops2023:outil-service-latest'
                    }
                }
            }
        
        }
        stage('Build Publication-service') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/Ibrahim25-ai/springProject.git']]])
                dir('Publication-service') {
                    sh "mvn clean package -DskipTests"
                }
            }

            post {
                success {
                    
                    archiveArtifacts 'Publication-service/target/*.jar'
                }
            }
        }
        stage('Build and Push Docker Image Publication-service') {
            steps {
                dir('Publication-service') {
                    // Build Docker image
                    script {
                        sh 'docker build -t maheribrahim/devops2023:publication-service-latest .'
                        
                    }

                    // Push Docker image
                    script {
                         
                         sh 'docker push maheribrahim/devops2023:publication-service-latest'
                         sh 'docker run -d maheribrahim/devops2023:publication-service-latest'
                    }
                }
            }
        
        }
        stage('Build Membre-service') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/Ibrahim25-ai/springProject.git']]])
                dir('Membre-service') {
                    sh "mvn clean package -DskipTests"
                }
            }

            post {
                success {
                    
                    archiveArtifacts 'Membre-service/target/*.jar'
                }
            }
        }
        stage('Build and Push Docker Image Membre-service') {
            steps {
                dir('Membre-service') {
                    // Build Docker image
                    script {
                        sh 'docker build -t maheribrahim/devops2023:membre-service-latest .'
                        
                    }

                    // Push Docker image
                    script {
                         
                         sh 'docker push maheribrahim/devops2023:membre-service-latest'
                         sh 'docker run -d maheribrahim/devops2023:membre-service-latest'
                    }
                }
            }
        
        }
    }
}
