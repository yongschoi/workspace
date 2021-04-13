# Jenkins에서 remote로 접속후, 작업 dir로 이동
cd /home/yongschoi/test/example-ui/build

# 버전정보(0.1.0) grep
version=$(cat project/package.json | grep version | head -1 | awk -F: '{ print $2 }' | sed 's/[",]//g' | tr -d '[[:space:]]')

# docker build
docker build -t yongs2020/example-ui:$version .


