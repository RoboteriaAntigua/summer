# Maquina de cruds

# Crear crud (mongo):

    java summer Client -all

# Encender mongo

    sudo service mongod start

# Agregar propiedades tanto al dto como a la entidad

    private String name

# Usar los endpoints

    show all    ->  get http://localhost:8080/api/producto/index
    create      ->  post http://localhost:8080/api/client/store con body acorde al dto y entidad
    show        ->  get http://localhost:8080/api/client/68b371e63e1229224f96a1c4
    Update      ->  put http://localhost:8080/api/client/68b371e63e1229224f96a1c4

