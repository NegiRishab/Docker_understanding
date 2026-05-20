def function (){
    echo "Hello World"
}

def build(){
    echo 'Building...'
    
}
def buildImage(){
    echo 'Building Docker image...'
                // Add your Docker build commands here
                withCredentials([usernamePassword(credentialsId: 'docker_hub', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh "docker build -t ankit42098/myapp:2.1 ."
                    sh "echo ${DOCKER_PASSWORD} | docker login -u ${DOCKER_USERNAME} --password-stdin"
                    sh "docker push ankit42098/myapp:2.1"
                }

}
def test(){
    echo 'Testing...'
                // Add your test commands here
}

def deploy(){
    echo 'Deploying...'
    
}

return this