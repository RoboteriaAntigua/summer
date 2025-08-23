# Maquina de cruds

# Crear crud:

    java summer Client -all

# Registrar

    Post a http://localhost:8080/signup
    o desde la web

# Login

    Post a http://localhost:8080/login
    con body x-www-form-urlencoded:
    {
        "username": "tete2",
        "password": "1234"
    }
    Debe ser un email y password valido
    (Postman recordara la session para proximas peticiones)

# Usar los endpoints

    get http://localhost:8080/api/producto/index



