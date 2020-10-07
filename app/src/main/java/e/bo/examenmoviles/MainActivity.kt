package e.bo.examenmoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)
            repository.insert(Book("the best seller: Android","356","coquito", "cortazar","lel","algo"))
            val lista = repository.getListBooks()
            lista.forEach {
                Log.d("DBTEST","Id book = ${it.id}, Title: ${it.title}")
            }
        }*/
        val lista = arrayListOf<Book>()
        lista.add(Book("GOT", "1385", "coquito", "roberto", "terror","urñ"))
        lista.add(Book("Biblia", "345","kipus", "Gabriela Orosco Montaño","religioso","url"))

        val bookListAdapater = BookListAdapter(lista, this)
        book_recyclerView.adapter = bookListAdapater
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        book_recyclerView.layoutManager = linearLayoutManager

    }
}