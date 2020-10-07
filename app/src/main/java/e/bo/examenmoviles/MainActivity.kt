package e.bo.examenmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    //funcando_********
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)
            repository.insert(Book("Alguien","5", "Algo","alguien","desc","https://i.imgur.com/tGbaZCY.jpg"))
            val lista = repository.getListBooks()
        }*/
        val lista = arrayListOf<Book>()
        lista.add(Book("Alguien","5", "Algo","alguien","desc","https://i.imgur.com/tGbaZCY.jpg"))
        val userListAdapter = BookListAdapter(lista, this)
        book_recyclerView.adapter = userListAdapter
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        book_recyclerView.layoutManager = linearLayoutManager
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)
            repository.insert(Book("Alguien","5", "Algo","alguien","desc","https://i.imgur.com/tGbaZCY.jpg"))
            val lista = repository.getListBooks()
            lista.forEach {
                Log.d("DBTEST","Id book = ${it.id}, Title: ${it.title}")
            }
        }

    }

        /*val lista = arrayListOf<Book>()
        lista.add(
            Book(
                "Alguien",
                "5",
                "Algo",
                "alguien",
                "desc",
                "https://i.imgur.com/tGbaZCY.jpg"
            )
        )
        val userListAdapter = BookListAdapter(lista, this)
        book_recyclerView.adapter = userListAdapter
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        book_recyclerView.layoutManager = linearLayoutManager*/



}