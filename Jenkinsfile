pipeline {
    agent any

    environment {
        DOCKER_NETWORK = "mysql_network"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/Sahil-Naik/JAVA-J2EE'
            }
        }

        stage('Build & Package') {
            steps {
                script {
                    def services = ['Day30-DJ-APIGateaway', 'Day30-DJ-ConfigServer', 'Day30-DJ-ServerRegistry', 'Day30-DJ-WebClientBank', 'Day30-DJ-WebClientCustomer', 'Day30-DJ-WebClientVendor']
                    
                    for (service in services) {
                        bat """
                            cd ${service}
                            mvn clean package -DskipTests
                            cd ..
                        """
                    }
                }
            }
        }

        stage('Build Docker Images') {
            steps {
                script {
                    def services = [
                        'Day30-DJ-APIGateaway': 'api-gateway',
                        'Day30-DJ-ConfigServer': 'config-server',
                        'Day30-DJ-ServerRegistry': 'server-registry',
                        'Day30-DJ-WebClientBank': 'server-bank',
                        'Day30-DJ-WebClientCustomer': 'server-customer',
                        'Day30-DJ-WebClientVendor': 'server-vendor'
                    ]

                    for (service in services.keySet()) {
                        bat """
                            cd ${service}
                            docker build -t ${services[service]} .
                            cd ..
                        """
                    }
                }
            }
        }

        stage('Run Containers') {
            steps {
                script {
                    bat """
                        docker network create ${DOCKER_NETWORK} || true
                        
                        docker run -d --name=server-registry --network=${DOCKER_NETWORK} -p 8761:8761 server-registry
                        timeout /t 5
                        docker run -d --name=config-server --network=${DOCKER_NETWORK} -p 8888:8888 config-server
                        timeout /t 5
                        docker run -d --name=api-gateway --network=${DOCKER_NETWORK} -p 9090:9090 api-gateway
                        timeout /t 5
                        docker run -d --name=server-bank --network=${DOCKER_NETWORK} -p 6061:6061 server-bank
                        timeout /t 5
                        docker run -d --name=server-customer --network=${DOCKER_NETWORK} -p 6060:6060 server-customer
                        timeout /t 5
                        docker run -d --name=server-vendor --network=${DOCKER_NETWORK} -p 6062:6062 server-vendor
                    """
                }
            }
        }
    }
}
