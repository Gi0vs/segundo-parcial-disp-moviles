package e.bo.examenmoviles
class BookRepository(private val bookDao: IBookDAO) {

    suspend fun insert(book: Book) {
        bookDao.insert(book)
    }

    fun getListBooks(): List<Book> {
        return bookDao.getList()
    }
}
