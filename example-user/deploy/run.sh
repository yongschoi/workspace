# Jenkins에서 remote로 접속하므로 현재 위치는 /home/yongschoi 이므로 작업 dir로 이동
cd /home/yongschoi/test/example-user/build

fname=`basename *.jar .jar`;
version=${fname##*-};
image=${fname%-*};

# stop example-hello
sudo docker stop $image
if [ $? -eq 0 ]; then
  echo $image "stopped"
else
  echo $image "not found"
fi

sudo docker run --name $image --network=YONGS-NET -p 7071:8080 -d --rm yongs2020/$image:$version

# garbage clean
rm $fname.jar

# <none> tage 이미지 모두 삭제
sudo docker rmi $(sudo docker images -f "dangling=true" -q)
if [ $? -eq 0 ]; then
  echo "<none> tag images removed"
else
  echo "<none> tag images not found"
fi


