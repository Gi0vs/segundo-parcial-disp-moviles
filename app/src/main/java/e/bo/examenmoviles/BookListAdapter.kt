package e.bo.examenmoviles

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.book_row.view.*


class BookListAdapter(val items: ArrayList<Book>, val context: Context): RecyclerView.Adapter<BookListAdapter.BookListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_row, parent, false)
        return BookListViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        val book = items.get(position)
        holder.itemView.txtView_book_title.text = book.title
        holder.itemView.txtView_book_pages.text = book.pages
    }

    class BookListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}

