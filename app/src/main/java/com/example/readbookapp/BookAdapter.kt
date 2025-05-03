package com.example.readbookapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.readbookapp.databinding.ItemBookBinding

class BookAdapter(
    private val bookList: List<Book>, // Danh sách sách
    private val onItemClick: (Book) -> Unit // Hàm xử lý khi item được click
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    // ViewHolder cho từng item
    inner class BookViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            // Set tên sách và tác giả
            binding.titleTextView.text = book.title
            binding.authorTextView.text = book.author

            // Set ảnh sách nếu có
            Glide.with(binding.bookImageView.context)
                .load(book.imageUrl)
                .placeholder(R.drawable.placeholder_image) // Đảm bảo resource tồn tại
                .into(binding.bookImageView)

            // Xử lý sự kiện click vào item
            itemView.setOnClickListener {
                onItemClick(book)
            }
        }
    }

    // Tạo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    // Trả về số lượng item trong danh sách
    override fun getItemCount() = bookList.size

    // Gán dữ liệu cho từng item
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(bookList[position])
    }
}
