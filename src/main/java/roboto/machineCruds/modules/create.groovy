package roboto.machineCruds.modules

if (!args.length == 2) {
    println "Use mode: groovy create.groovy <Name> -all"
    println "options: -all -c -e -dto -rep -s"
}

String name = args[0]
String option = args[1]
def baseDir = "./" + args[0]
String pattern = ~/Product/

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

    println "Creating " + name + "Controller"

    def controller = ""

    //Crea controlador nuevo
    def controllerFile = new File(baseDir + "/", name + 'Controller.java')

    //Lee controlador Producto y reemplaza matches
    new File("./Product/", 'ProductController.java').eachLine { line ->
        def replacedLine = line.replaceAll(pattern, name)
        def replacedLineToLower = replacedLine.replaceAll(pattern.toLowerCase(), name.toLowerCase())
        controllerFile.append(replacedLineToLower + "\n")
    }
}

// --------------------- Entity --------------------------------------------------------
if (option == "-e" || option == "-all") {

    println "Creating " + name + "Entity"

    def entity = ""

    //Create new entity
    def entityFile = new File(baseDir + "/", name + 'Entity.java')

    new File("./Product/", 'ProductEntity.java').eachLine { line ->
        def replacedLine = line.replaceAll(pattern, name)
        def replacedLineToLower = replacedLine.replaceAll(pattern.toLowerCase(), name.toLowerCase())
        entityFile.append(replacedLineToLower + "\n")
    }
}


// --------------------- Repositoy --------------------------------------------------------
if (option == "-repo" || option == "-all") {

    println "Creating " + name + "Repository"

    def repository = ""

    //Creating new repo
    def repositoryFile = new File(baseDir + "/", name + 'Repository.java')

    //Read the Repository and replace all matches
    new File("./Product/", 'ProductRepository.java').eachLine { line ->
        def replacedLine = line.replaceAll(pattern, name)
        def replacedLineToLower = replacedLine.replaceAll(pattern.toLowerCase(), name.toLowerCase())
        repositoryFile.append(replacedLineToLower + "\n")
    }
}

// --------------------- DTO --------------------------------------------------------
if (option == "-dto" || option == "-all") {

    println "Creating " + name + "DTO"

    def request = ""

    //Create a new DTO
    def requestFile = new File(baseDir + "/", name + 'DTO.java')

    //Read an existing DTO an replace all the matches
    new File("./Product/", 'ProductDTO.java').eachLine { line ->
        def replacedLine = line.replaceAll(pattern, name)
        def replacedLineToLower = replacedLine.replaceAll(pattern.toLowerCase(), name.toLowerCase())
        requestFile.append(replacedLineToLower + "\n")
    }

    // --------------------- Service --------------------------------------------------------
    if (option == "-s" || option == "-all") {

        println "Creating " + name + "Service"

        def repository = ""

        def repositoryFile = new File(baseDir + "/", name + 'Service.java')
        
        new File("./Product/", 'ProductService.java').eachLine { line ->
            def replacedLine = line.replaceAll(pattern, name)
            def replacedLineToLower = replacedLine.replaceAll(pattern.toLowerCase(), name.toLowerCase())
            repositoryFile.append(replacedLineToLower + "\n")
        }
    }

}