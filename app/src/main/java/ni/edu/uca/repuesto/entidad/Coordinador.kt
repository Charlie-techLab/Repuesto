package ni.edu.uca.repuesto.entidad

class Coordinador (
    var idC : Int?,
    var nombre : String?,
    var apellido : String?,
    var fechaNac : String?,
    var titulo : String?,
    var email : String?,
    var facultad : String?
) {

    fun cargarDatosBD() : MutableList<Coordinador>{
        var cor : Coordinador = Coordinador(1, "Luis Guillermo", "Orozco Lazo", "2001-12-22", "Ing.", "lorozcolazo@gmail.com", "Humanidades")
        var lista : MutableList<Coordinador> = mutableListOf(cor)
        return lista
    }
}