
docker stop yongs-jenkins
docker rm yongs-jenkins

docker run --name yongs-jenkins --network=YONGS-NET -p 7777:8080 -p 50000:50000 -v /home/yongschoi/data/jenkins:/var/jenkins_home -d --rm jenkins/jenkins:alpine


