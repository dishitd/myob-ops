docker-compose build
docker-compose up --scale api=5 --scale nginx-lb=1 -d