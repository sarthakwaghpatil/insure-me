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
            emailext body: '''dear all ,
            the jenkins job ${JOB_NAME} has been failed 
            look it by clicking on following link
            ${BUILD_URL}''', subject: 'Job ${JOB_NAME} ${BUILD_NUMBER} is failed', to: 'sarthakwaghpatil@gmail.com'
        }
    }
    
    stage('Build th application'){
            echo ' clean compile .. test .. package'
            //sh 'mvn clean package'
            sh "${mavenCMD} clean package"
    }
    stage('to containerizing aplication'){
            echo 'creating docker image'
            sh "sudo ${dockerCMD} build -t sarthakwaghpatil/insure-me:${tagName} ."
        
    }
    stage('pushing it to dockerhub'){
        echo'pushing an image to dockerhub'
        withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerhubpasword')]) {
            sh "sudo ${dockerCMD} login -u sarthakwaghpatil -p ${dockerhubpasword}"
            sh "sudo ${dockerCMD} push sarthakwaghpatil/insure-me:${tagName}"
        }
        
        
    }
    stage ('configure and deploy to slave-node server'){
        ansiblePlaybook become: true, credentialsId: 'ansible-key', disableHostKeyChecking: true, installation: 'ansible', inventory: '/etc/ansible/hosts', playbook: 'file.yml'
    }
    

    
    
    
    
    
    
}
