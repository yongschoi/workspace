# jenkins에서 remote로 접속후, 작업 dir 로 이동
cd /home/yongschoi/test/example-user/build

# jar 파일가져오기: example-user-0.1.0.jar
find /home/yongschoi/test/example-user/build/source/build/libs -name "*.jar" -exec cp {} . \;

# fname : example-user-0.1.0
fname=`basename *.jar .jar`;
# version : 0.1.0
version=${fname##*-};
# image : example-user
image=${fname%-*};

# sudo docker build 
sudo docker build --build-arg FILENAME=$fname -t yongs2020/$image:$version .

