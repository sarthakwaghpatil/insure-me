node{
    def mavenHome
    def mavenCMD
    def docker
    def dockerCMD
    def tagName
    stage('prepare environment'){
        echo 'initializing variables'
        mavenHome = tool name: 'maven' , type: 'maven'
        mavenCMD = "${mavenHome}/bin/mvn"
        docker = tool name: 'docker' , type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
        dockerCMD = "${docker}/bin/docker"
        tagName = "1.0"
    }

    stage('git code chekiout'){
        try{
            echo 'checkout code from git repo'
            git 'https://github.com/sarthakwaghpatil/insure-me.git'
        }
        catch(Exception e){
            echo 'Exception occured in git code checkout stage'
            currentBuild.result - "FAILURE"
            emailext body: '''DEAR ALL,
             the jenkins job has been failed request you to please  have a look it immediately
             by clicking on below link 
             ${BUILD_URL}''', subject: 'THE JENKINS JOB ${JOB_NAME} ${BUILD_NUMBER} IS FAILED ', to: 'sarthakwaghpatil@gmail.com'
        }
    }
    
    stage('Build th application'){
            echo ' clean compile .. test .. package'
            //sh 'mvn clean package'
            sh "${mavenCMD} clean package"
    }
    stage('publish test reports'){
        publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: '', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: '/var/lib/jenkins/workspace/insure-me-project/target/surefire-reports/', useWrapperFileDirectly: true])
    }
    stage('to containerizing aplication'){
            echo 'creating docker image'
            sh "sudo ${dockerCMD} build -t sarthakwaghpatil/insure-me:${tagName} ."
        
    }
    stage('pushing it to dockerhub'){
        echo 'pushing the docker image'
        withCredentials([string(credentialsId: 'dock-password', variable: 'dockerhubpassword')]) {
            sh "sudo ${dockerCMD} login -u sarthakwaghpatil -p ${dockerhubpassword}"
            sh "sudo ${dockerCMD} push sarthakwaghpatil/insure-me:${tagName}"
    }
    stage('configure and deploy to slave-node-server'){
        ansiblePlaybook become: true, credentialsId: 'ansible-key', disableHostKeyChecking: true, installation: 'ansible', inventory: '/etc/ansible/hosts', playbook: 'file.yml'
    }
    }
    stage('to run selenium script'){
    echo "run java test app"
    sh 'sudo java -jar selenium-app.jar'
    }
    
    

    
    
    
    
    
    
}
