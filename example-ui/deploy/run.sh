# Jenkins에서 remote로 접속후, 작업 dir로 이동
cd /home/yongschoi/test/example-ui/build

# 버전정보(0.1.0) grep
version=$(cat project/package.json | grep version | head -1 | awk -F: '{ print $2 }' | sed 's/[",]//g' | tr -d '[[:space:]]')

# stop example-ui
sudo docker stop example-ui
if [ $? -eq 0 ]; then
  echo example-ui "stopped"
else
  echo example-ui "not found"
fi

# run example-ui
sudo docker run --name example-ui --network=YONGS-NET -p 7070:80 -d --rm yongs2020/example-ui:$version

# garbage clean
# <none> tage 이미지 모두 삭제
sudo docker rmi $(sudo docker images -f "dangling=true" -q)
if [ $? -eq 0 ]; then
  echo "<none> tag images removed"
else
  echo "<none> tag images not found"
fi

