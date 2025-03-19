
if ( !args.length == 2 ) {
    println "Modo de uso: groovy Maquina.groovy <Name> -all"
    println "opciones: -all -c -e -req -rep" 
} 

String name = args[0]
String option = args[1]
def baseDir = "./" + args[0]
String pattern = ~/Producto/

//Crea carpeta con nombre del modulo
def dir = new File(baseDir)
if (!dir.exists()) {
    dir.mkdir()  // Creates the directory
    println "Directory created: ${dir.path}"
} else {
    println "Directory already exists: ${dir.path}"
}

// --------------------- Controller --------------------------------------------------------
if (option == "-c" || option == "-all") {
    
    println "Creando " + name + "Controller"
    
    def controller = ""

    //Crea controlador nuevo
    def controllerFile = new File(baseDir+"/", name +'Controller.java')

    //Lee controlador Producto y reemplaza matches
    new File("./Producto/", 'ProductoController.java').eachLine { line ->
        def replacedLine = line.replaceAll(pattern, name)
        def replacedLineToLower = replacedLine.replaceAll(pattern.toLowerCase(), name.toLowerCase())
        controllerFile.append(replacedLineToLower + "\n")
    }
}

// --------------------- Entity --------------------------------------------------------
if (option == "-e" || option == "-all") {
    
    println "Creando " + name + "Entity"
    
    def entity = ""

    //Crea controlador nuevo
    def entityFile = new File(baseDir+"/", name +'Entity.java')

    //Lee controlador Producto y reemplaza matches
    new File("./Producto/", 'ProductoEntity.java').eachLine { line ->
        def replacedLine = line.replaceAll(pattern, name)
        def replacedLineToLower = replacedLine.replaceAll(pattern.toLowerCase(), name.toLowerCase())
        entityFile.append(replacedLineToLower + "\n")
    }
}


// --------------------- Repositoy --------------------------------------------------------
if (option == "-repo" || option == "-all") {
    
    println "Creando " + name + "Repository"
    
    def repository = ""

    //Crea controlador nuevo
    def repositoryFile = new File(baseDir+"/", name +'Repository.java')

    //Lee controlador Producto y reemplaza matches
    new File("./Producto/", 'ProductoRepository.java').eachLine { line ->
        def replacedLine = line.replaceAll(pattern, name)
        def replacedLineToLower = replacedLine.replaceAll(pattern.toLowerCase(), name.toLowerCase())
        repositoryFile.append(replacedLineToLower + "\n")
    }
}

// --------------------- Request --------------------------------------------------------
if (option == "-req" || option == "-all") {
    
    println "Creando " + name + "Request"
    
    def request = ""

    //Crea controlador nuevo
    def requestFile = new File(baseDir+"/", name +'Request.java')

    //Lee controlador Producto y reemplaza matches
    new File("./Producto/", 'ProductoRequest.java').eachLine { line ->
        def replacedLine = line.replaceAll(pattern, name)
        def replacedLineToLower = replacedLine.replaceAll(pattern.toLowerCase(), name.toLowerCase())
        requestFile.append(replacedLineToLower + "\n")
    }
}