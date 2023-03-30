package ni.edu.uca.repuesto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ni.edu.uca.repuesto.databinding.ActivityMainBinding
import ni.edu.uca.repuesto.entidad.Coordinador
import ni.edu.uca.repuesto.objetosRecyclerView.VistaObjetos
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cargardatos(){
        var lista: MutableList<Coordinador> = mutableListOf()
        var cliente = OkHttpClient().newBuilder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
        val url = "http://192.168.58.1/APICoordinador/mostrarcoordinador.php"
        val request: Request = Request.Builder()
            .url(url)
            .header("Connection", "close")
            .build()
        cliente.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }
            override fun onResponse(call: Call, response: Response){
                response.use(){
                    try{
                        val body = response.body?.string()
                        val jsonObject = JSONObject(body!!)
                        val dataArray = jsonObject.getJSONArray("data")
                        val lenght = dataArray.length()
                        var i = 0
                        do {
                            if(lenght != 0){
                                val coordinadorJSON = dataArray.getJSONObject(i)
                                val idC = coordinadorJSON.getString("idC").toInt()
                                val nombre = coordinadorJSON.getString("nombre")
                                val apellido = coordinadorJSON.getString("apellido")
                                val fechaNac = coordinadorJSON.getString("fechaNac")
                                val titulo = coordinadorJSON.getString("titulo")
                                val email = coordinadorJSON.getString("email")
                                val facultad = coordinadorJSON.getString("facultad")
                                var coordinador:Coordinador=Coordinador(idC, nombre, apellido, fechaNac, titulo, email, facultad)
                                lista.add(coordinador)
                            }
                        }while (i < lenght - 1)
                        GlobalScope.launch(Dispatchers.Main){
                            cargarreciclador(lista)
                        }
                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                }

            }
        })


    }

    fun cargarreciclador(listacambiante:MutableList<Coordinador>){

        recycler=binding.recyclerview
        recycler.layoutManager=LinearLayoutManager(this)
        recycler.adapter=VistaObjetos(this, listacambiante, binding.root)
    }
}