# 이전 소스 삭제
cd /home/yongschoi/test/example-ui/build

# github에서 소스 가져오기
git clone https://github.com/yongschoi/example-ui.git source

# example-ui 프로젝트로 source 파일 이동 후 삭제
rsync -a source/ project/
rm -rf source/



