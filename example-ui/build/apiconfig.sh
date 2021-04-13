# main.js의 example-user HOST 정보 변경
# $apiURI = "http://127.0.0.1:8081" --> Vue.prototype.$apiURI = "http://example-user:7071"

cd /home/yongschoi/test/example-ui/build/project/src

sed -e s/'localhost:8081'/'localhost:7071'/g main.js > main.js.tmp1
sed -e s/'localhost:8082'/'localhost:7072'/g main.js.tmp1 > main.js.tmp2
mv main.js.tmp2 main.js
rm main.js.tmp1



