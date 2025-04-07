# Maquina de cruds

# Por ahora es una app basada en session

# Registrar

    Post a http://localhost:8080/signup
    o desde la web

# Login

    Post a http://localhost:8080/loguin
    con body x-www-form-urlencoded:
    {
        "username": "tete2",
        "password": "1234"
    }
    Debe ser un email y password valido
    (Postman recordara la session para proximas peticiones)

# Usar los endpoints

    get http://localhost:8080/api/producto/index



