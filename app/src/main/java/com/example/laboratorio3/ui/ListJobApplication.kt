package com.example.laboratorio3.ui

import android.content.Intent
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio3.R
import com.google.android.material.snackbar.Snackbar
import java.util.*
import kotlin.collections.ArrayList
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator

class ListJobApplication : AppCompatActivity() {
    var aplicantes = Aplicantes.instance
    lateinit var lista:RecyclerView
    lateinit var adaptador: Aplicantes_RecyclerViewAdapter
    var position: Int = 0
    lateinit var aplicante: Aplicante
    var archived = ArrayList<Aplicante>()

    override fun onResume(){
        super.onResume()
        getListOfAplicantes()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_job_application)

        lista = findViewById(R.id.listRecyclerView)

        findViewById<SearchView>(R.id.svNombre).setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adaptador.filter.filter(newText)
                return false
            }
        })
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
        getListOfAplicantes()

        val itemTouchHelperCallback =
            object : ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END,
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    val fromPosition: Int = viewHolder.adapterPosition
                    val toPosition: Int = target.adapterPosition

                    Collections.swap(aplicantes.getAplicantes(), fromPosition, toPosition)
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    position = viewHolder.adapterPosition
                    if (direction == ItemTouchHelper.LEFT) {
                        aplicante = Aplicante(
                            aplicantes.getAplicantes()[position].user,
                            aplicantes.getAplicantes()[position].firstName,
                            aplicantes.getAplicantes()[position].lastName,
                            aplicantes.getAplicantes()[position].streetAddresOne,
                            aplicantes.getAplicantes()[position].streetAddresTwo,
                            aplicantes.getAplicantes()[position].city,
                            aplicantes.getAplicantes()[position].province,
                            aplicantes.getAplicantes()[position].zipcode,
                            aplicantes.getAplicantes()[position].country,
                            aplicantes.getAplicantes()[position].email,
                            aplicantes.getAplicantes()[position].areacode,
                            aplicantes.getAplicantes()[position].phone,
                            aplicantes.getAplicantes()[position].applyPosition,
                            aplicantes.getAplicantes()[position].startDate,
                            aplicantes.getAplicantes()[position].foto
                        )
                        aplicantes.deleteAplicante(position)
                        lista.adapter?.notifyItemRemoved(position)

                        Snackbar.make(lista, aplicante.firstName + "Ha sido eliminado...", Snackbar.LENGTH_LONG)
                            .setAction("Undo") {
                                aplicantes.getAplicantes().add(position, aplicante)
                                lista.adapter?.notifyItemInserted(position)
                            }.show()
                        adaptador = Aplicantes_RecyclerViewAdapter(aplicantes.getAplicantes())
                        lista.adapter = adaptador
                    } else {
                        aplicante = Aplicante(
                            aplicantes.getAplicantes()[position].user,
                            aplicantes.getAplicantes()[position].firstName,
                            aplicantes.getAplicantes()[position].lastName,
                            aplicantes.getAplicantes()[position].streetAddresOne,
                            aplicantes.getAplicantes()[position].streetAddresTwo,
                            aplicantes.getAplicantes()[position].city,
                            aplicantes.getAplicantes()[position].province,
                            aplicantes.getAplicantes()[position].zipcode,
                            aplicantes.getAplicantes()[position].country,
                            aplicantes.getAplicantes()[position].email,
                            aplicantes.getAplicantes()[position].areacode,
                            aplicantes.getAplicantes()[position].phone,
                            aplicantes.getAplicantes()[position].applyPosition,
                            aplicantes.getAplicantes()[position].startDate,
                            aplicantes.getAplicantes()[position].foto
                        )
                        archived.add(aplicante)

                       // aplicantes.deleteAplicante(position)
                        lista.adapter?.notifyItemRemoved(position)

                        // Este es el Intent que enviara a un formulario para editar al aplicante
                   Intent(this@ListJobApplication,JobApplicationActivity::class.java).also {
                        it.putExtra("USER_EXTRA",aplicante.user)
                        it.putExtra("EXTRA_POSITION",position)
                        startActivity(it)
                    }
                        Snackbar.make(lista, aplicante.firstName + "se editara...", Snackbar.LENGTH_LONG)
                            .setAction("Undo") {
                                archived.removeAt(archived.lastIndexOf(aplicante))

                                lista.adapter?.notifyItemInserted(position)
                            }.show()
                        adaptador = Aplicantes_RecyclerViewAdapter(aplicantes.getAplicantes())
                        lista.adapter = adaptador
                        getListOfAplicantes()
                    }
                }

                override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {

                    RecyclerViewSwipeDecorator.Builder(this@ListJobApplication, c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                        .addSwipeLeftBackgroundColor(ContextCompat.getColor(this@ListJobApplication, R.color.red))
                        .addSwipeLeftActionIcon(R.drawable.ic_baseline_cancel_24)
                        .addSwipeRightBackgroundColor(ContextCompat.getColor(this@ListJobApplication, R.color.green))
                        .addSwipeRightActionIcon(R.drawable.ic_baseline_border_color_24)
                        .create()
                        .decorate()
                    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                }
            }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(lista)

    }

    private fun getListOfAplicantes() {
        val Naplicantes = ArrayList<Aplicante>()
        for (a in aplicantes.getAplicantes()) {
            Naplicantes.add(a)
        }
        adaptador = Aplicantes_RecyclerViewAdapter(Naplicantes)
        lista.adapter = adaptador
        lista.layoutManager = LinearLayoutManager(lista.context)
        lista.setHasFixedSize(true)
    }
}