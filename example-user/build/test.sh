# 테스트 환경 구성하기
cd /home/yongschoi/test/example-user/build/source/src/main/resources
# ------------ gradle test를 docker 컨테이너가 아닌 Node에서 수행할 경우 db설정을 임시로 변경한다.
sed -e s/'maria-db:3306'/'localhost:3306'/g application.yml > application.yml.tmp
mv application.yml.tmp application.yml

# gradle 테스트
cd /home/yongschoi/test/example-user/build/source
/opt/gradle/gradle-6.7/bin/gradle test

# ------------ gradle test 완료후 db설정을 원복한다.
cd /home/yongschoi/test/example-user/build/source/src/main/resources
sed -e s/'localhost:3306'/'maria-db:3306'/g application.yml > application.yml.tmp
mv application.yml.tmp application.yml

