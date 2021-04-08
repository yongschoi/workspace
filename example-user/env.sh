# stop eureka
docker stop eureka
docker rm eureka

# start eureka(SpringBoot로생성된 src를 docker images로 만들어 실행)
docker run --name eureka --network=YONGS-NET -p 8761:8761 -d --rm yongs2020/eureka:v1

# stop maria-db
docker stop maria-db
docker rm maria-db

# start maria-db
docker run --name maria-db --network=YONGS-NET -p 3306:3306 -e MYSQL_ROOT_PASSWORD=tiger -v /home/yongschoi/data/maria:/var/lib/mysql -d --rm mariadb

# stop mongo
docker stop flex-mongo
docker rm flex-mongo

# start mongo(flex)
docker run --name flex-mongo --network=YONGS-NET -p 27017:27017 -v /home/yongschoi/data/mongo/flex:/data/db -d --rm mongo

# minio(Object Storage) 
docker stop minio
docker run -p 9000:9000 \
 -e "MINIO_ACCESS_KEY=AKIAIOSFODNN7EXAMPLE" \
 -e "MINIO_SECRET_KEY=wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY" \
 -v /home/yongschoi/data/minio:/data \
 -d --rm --name minio --network=YONGS-NET \
 minio/minio server /data

