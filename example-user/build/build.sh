# localhost환경에서 docker환경으로 변경
cd /home/yongschoi/test/example-user/build/source/src/main/resources
sed -e s/'active: window-dev'/'active: container'/g application.yml > application.yml.tmp
mv application.yml.tmp application.yml

# gradle build
cd /home/yongschoi/test/example-user/build/source
/opt/gradle/gradle-6.7/bin/gradle clean build -x test


