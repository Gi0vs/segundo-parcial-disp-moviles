package e.bo.examenmoviles

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.book_row.view.*


class BookListAdapter(val items: ArrayList<Book>, val context: Context): RecyclerView.Adapter<BookListAdapter.UserListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_row, parent, false)
        return UserListViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val book = items.get(position)
        holder.itemView.txtView_book_title.text = book.title
        holder.itemView.txtView_book_title.text = book.title
        holder.itemView.txtView_book_pages.text = book.pages
        holder.itemView.txtView_book_editorial.text = book.editorial
        holder.itemView.txtView_book_author.text = book.author
        holder.itemView.txtView_book_description.text = book.description
        holder.itemView.txtView_book_photo_url.text = book.photoURL
    }

    class UserListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}
