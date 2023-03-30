package ni.edu.uca.repuesto.objetosRecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import ni.edu.uca.repuesto.MainActivity
import ni.edu.uca.repuesto.R
import ni.edu.uca.repuesto.entidad.Coordinador


class VistaObjetos(var context : Context, var listaCoordinador : MutableList<Coordinador>, var vista : View) :
    RecyclerView.Adapter<VistaObjetos.MyHolder>() {
    inner class MyHolder(item: View): RecyclerView.ViewHolder(item){
        var idC: TextView
        var nombre: TextView
        var apellido: TextView
        var fechaNac: TextView
        var titulo: TextView
        var email: TextView
        var facultad: TextView
        init {
            idC=item.findViewById(R.id.tvidC)
            nombre=item.findViewById(R.id.tvnombre)
            apellido=item.findViewById(R.id.tvApellido)
            fechaNac=item.findViewById(R.id.tvfechaNac)
            titulo=item.findViewById(R.id.tvtitulo)
            email=item.findViewById(R.id.email)
            facultad=item.findViewById(R.id.facultad)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var item= LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        return MyHolder(item)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var coordinador=listaCoordinador[position]
        holder.idC.text=coordinador.idC.toString()
        holder.nombre.text=coordinador.nombre
        holder.apellido.text=coordinador.apellido
        holder.fechaNac.text=coordinador.fechaNac
        holder.titulo.text=coordinador.titulo
        holder.email.text=coordinador.email
        holder.facultad.text=coordinador.facultad


    }

    override fun getItemCount(): Int {
        return listaCoordinador.size
    }
}