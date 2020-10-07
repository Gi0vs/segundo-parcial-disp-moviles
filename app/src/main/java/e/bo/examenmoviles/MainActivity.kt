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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)
            //repository.insert(Book("Alguien","5", "Algo","alguien","desc","https://i.imgur.com/tGbaZCY.jpg"))
            val lista = repository.getListBooks()
            val userListAdapter = BookListAdapter(lista as ArrayList<Book>, applicationContext)
            book_recyclerView.adapter = userListAdapter
            val linearLayoutManager = LinearLayoutManager(applicationContext)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            book_recyclerView.layoutManager = linearLayoutManager
        }
        val addFloatingButton: View = findViewById(R.id.floatingBtn_add_book)
        addFloatingButton.setOnClickListener {
            startActivity(Intent(this, AddBookActivity::class.java))
        }
    }
}