data class Direccion(
    val departamento: String,
    val municipio: String,
    val distrito: String,
    val complemento: String
)

data class Estudiante(
    val nombre: String,
    val carnet: String,
    val edad: Int,
    val carrera: String,
    val direccion: Direccion
)

fun main() {
    val estudiante1 = Estudiante(
        "Ana L¢pez", 
        "20231001", 
        20, 
        "Ingenier¡a", 
        Direccion("San Salvador", "San Salvador", "Centro", "Casa 101")
    )
    
    val estudiante2 = Estudiante(
        "Carlos P‚rez", 
        "20231002", 
        22, 
        "Medicina", 
        Direccion("La Libertad", "Santa Tecla", "Distrito 2", "Apartamento 5B")
    )
    
    val estudiante3 = Estudiante(
        "Luc¡a Ram¡rez", 
        "20231003", 
        19, 
        "Arquitectura", 
        Direccion("San Miguel", "San Miguel", "Distrito 1", "Calle 12 #34")
    )
    
    val estudiante4 = Estudiante(
        "Diego Mart¡nez", 
        "20231004", 
        21, 
        "Derecho", 
        Direccion("Santa Ana", "Santa Ana", "Distrito 3", "Residencial Los Pinos")
    )
    
    val estudiante5 = Estudiante(
        "Sof¡a Gonz lez", 
        "20231005", 
        20, 
        "Contabilidad", 
        Direccion("Usulut n", "Usulut n", "Distrito 4", "Colonia La Paz")
    )

    val estudiantes = listOf(estudiante1, estudiante2, estudiante3, estudiante4, estudiante5)

    for (estudiante in estudiantes) {
        println("Nombre: ${estudiante.nombre}")
        println("Carnet: ${estudiante.carnet}")
        println("Edad: ${estudiante.edad}")
        println("Carrera: ${estudiante.carrera}")
        println("Direcci¢n: ${estudiante.direccion.departamento}, ${estudiante.direccion.municipio}, ${estudiante.direccion.distrito}, ${estudiante.direccion.complemento}")
        println("------------------------------")
    }
}

