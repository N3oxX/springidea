CONFIG LOCAL

docker run --name some-postgres -e POSTGRES_PASSWORD=zapatilla -e POSTGRES_USER=root -p 5432:5432 -d postgres
