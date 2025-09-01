import groovy.json.JsonSlurper

if (args.length < 2) {
    println "Use mode: groovy create.groovy <Name> -<options> -[mysql] (optional for mysql, mongodb is default)"
    println "options: -all -c -e -dto -rep -s"
}

String name = args[0]
String option = args[1]
String dbType = (args.length > 2) ? args[2] : ""


/**
 * Open base páth
 */
def configFile = new File('./summerConfig.json')

if (!configFile.exists()) {
    println "Error: Configuration file not found at ${configFile.absolutePath}"
    return // Exit the script if the config is missing
}

def config = new JsonSlurper().parse(configFile)
def baseDir = config.modulesPath + name
println "Base directory loaded from config: ${baseDir}"

/**
 *  PackageName
 *  "./src/main/java/roboto/machineCruds/modules/" -> roboto.machineCruds.modules
 */
def packageName = baseDir
        .replace('./src/main/java/', '')
        .replace('/', '.')
println "Package name: ${packageName}"

/**
 * Patterns to remplace
 */
String packagePattern = "roboto.machineCruds.modules.Product"
String pattern = ~/Product/
String template = (dbType == "-mysql") ? "./scripts/Product" : "./scripts/ProductNoSQL"

//Crea carpeta con nombre del modulo
def dir = new File(baseDir)
if (!dir.exists()) {
    dir.mkdirs() ? println("Directory created: ${dir.path}") : println("Fails trying to create module: ${baseDir}")
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
    new File(template, 'ProductController.java').toString()

    new File(template, 'ProductController.java').eachLine { line ->
        if (line.contains(packagePattern)) {
            def reemplacePackageName = line.replace(packagePattern, packageName)
            controllerFile.append(reemplacePackageName + "\n")
            println "reemplaced package name for controller"
            return
        }
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

    new File(template, 'ProductEntity.java').eachLine { line ->
        if (line.contains(packagePattern)) {
            def reemplacePackageName = line.replace(packagePattern, packageName)
            entityFile.append(reemplacePackageName + "\n")
            println "reemplaced package name for Entity"
            return
        }
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
    new File(template, 'ProductRepository.java').eachLine { line ->
        if (line.contains(packagePattern)) {
            def reemplacePackageName = line.replace(packagePattern, packageName)
            repositoryFile.append(reemplacePackageName + "\n")
            println "reemplaced package name for repository"
            return
        }
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
    new File(template, 'ProductDTO.java').eachLine { line ->
        if (line.contains(packagePattern)) {
            def reemplacePackageName = line.replace(packagePattern, packageName)
            requestFile.append(reemplacePackageName + "\n")
            println "reemplaced package name for dto"
            return
        }
        def replacedLine = line.replaceAll(pattern, name)
        def replacedLineToLower = replacedLine.replaceAll(pattern.toLowerCase(), name.toLowerCase())
        requestFile.append(replacedLineToLower + "\n")
    }

    // --------------------- Service --------------------------------------------------------
    if (option == "-s" || option == "-all") {

        println "Creating " + name + "Service"

        def repository = ""

        def repositoryFile = new File(baseDir + "/", name + 'Service.java')

        new File(template, 'ProductService.java').eachLine { line ->
            if (line.contains(packagePattern)) {
                def reemplacePackageName = line.replace(packagePattern, packageName)
                repositoryFile.append(reemplacePackageName + "\n")
                println "reemplaced package name for service"
                return
            }
            def replacedLine = line.replaceAll(pattern, name)
            def replacedLineToLower = replacedLine.replaceAll(pattern.toLowerCase(), name.toLowerCase())
            repositoryFile.append(replacedLineToLower + "\n")
        }
    }

}