package e.bo.examenmoviles

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_book_activity.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_book_activity)
        val addBookBtn: View = findViewById(R.id.btn_add_book)
        addBookBtn.setOnClickListener {
            GlobalScope.launch {
                val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
                val repository = BookRepository(bookDao)

                repository.insert(Book(input_title.text.toString(),
                                       input_pages.text.toString(),
                                       input_editorial.text.toString(),
                                       input_author.text.toString(),
                                       input_description.text.toString(),
                                       input_photo_url.text.toString()))
            }
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}