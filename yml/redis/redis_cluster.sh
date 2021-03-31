# redis node 최소 6개 생성(3노드에 각각 master-slave 1셋트씩)

docker run -d --rm --name redis-master1 --net=host redis redis-server --port 6371 --cluster-enabled yes --cluster-config-file node.conf --cluster-node-timeout 5000 --bind 0.0.0.0
docker run -d --rm --name redis-master2 --net=host redis redis-server --port 6372 --cluster-enabled yes --cluster-config-file node.conf --cluster-node-timeout 5000 --bind 0.0.0.0
docker run -d --rm --name redis-master3 --net=host redis redis-server --port 6373 --cluster-enabled yes --cluster-config-file node.conf --cluster-node-timeout 5000 --bind 0.0.0.0
docker run -d --rm --name redis-slave1 --net=host redis redis-server --port 6374 --cluster-enabled yes --cluster-config-file node.conf --cluster-node-timeout 5000 --bind 0.0.0.0 --appendonly yes
docker run -d --rm --name redis-slave2 --net=host redis redis-server --port 6375 --cluster-enabled yes --cluster-config-file node.conf --cluster-node-timeout 5000 --bind 0.0.0.0 --appendonly yes
docker run -d --rm --name redis-slave3 --net=host redis redis-server --port 6379 --cluster-enabled yes --cluster-config-file node.conf --cluster-node-timeout 5000 --bind 0.0.0.0 --appendonly yes

# cluster 생성
# --net=host옵션으로 신규 컨테이너로 접속 
docker run -it --net=host redis redis-cli --cluster create 10.0.2.15:6371 10.0.2.15:6372 10.0.2.15:6373 10.0.2.15:6374 10.0.2.15:6375 10.0.2.15:6379 --cluster-replicas 1
# 혹은 6379 port로 기동된 컨테이너로 접속
docker exec -it redis-slave3 redis-cli --cluster create 10.0.2.15:6371 10.0.2.15:6372 10.0.2.15:6373 10.0.2.15:6374 10.0.2.15:6375 10.0.2.15:6379 --cluster-replicas 1

# cluster node 확인
# --net=host옵션으로 신규 컨테이너로 접속 
docker run -it --net=host redis redis-cli
# 혹은 6379 port로 기동된 컨테이너로 접속
docker exec -it redis-slave3 redis-cli
# 127.0.0.1:6379> cluster nodes
