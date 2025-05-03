package com.example.readbookapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.readbookapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var bookAdapter: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerViews()
        setupMenuIcon()


        return binding.root
    }

    // Phương thức để xử lý sự kiện click từ XML
    fun openStoryPage(view: View) {
        val intent = Intent(requireContext(), StoryPageActivity::class.java)
        startActivity(intent)
    }

    // Các phần còn lại của Fragment
    private fun setupRecyclerViews() {
        val books = getDummyBooks()

        bookAdapter = BookAdapter(books) { book ->
            Toast.makeText(requireContext(), "Bạn chọn: ${book.title}", Toast.LENGTH_SHORT).show()
        }

        binding.recyclerViewBooks.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewBooks.adapter = bookAdapter
    }

    private fun setupMenuIcon() {
        binding.menuIcon.setOnClickListener { view ->
            showPopupMenu(view)
        }
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(requireContext(), view)
        popupMenu.menuInflater.inflate(R.menu.menu_home, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_post -> {
                    openPostPage()
                    true
                }
                R.id.menu_liked_books -> {
                    openLikedBooksPage()
                    true
                }
                R.id.menu_commented -> {
                    openCommentedPage()
                    true
                }
                R.id.menu_settings -> {
                    openSettingsPage()
                    true
                }
                R.id.menu_logout -> {
                    logout()
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }

    private fun getDummyBooks(): List<Book> {
        return listOf(
            Book("Dark Roads", "Chevy Stevens", "https://link.to.image1"),
            Book("Once There Were Wolves", "Charlotte McConaghy", "https://link.to.image2"),
            Book("The Old Farmer's Almanac", "Almanac", "https://link.to.image3"),
            Book("Atomic Habits", "James Clear", "https://link.to.image4"),
            Book("The Body Keeps the Score", "Bessel van der Kolk", "https://link.to.image5")
        )
    }

    private fun openPostPage() {
        val intent = Intent(requireContext(), PostActivity::class.java)
        startActivity(intent)
    }

    private fun openLikedBooksPage() {
        val intent = Intent(requireContext(), LikedBooksActivity::class.java)
        startActivity(intent)
    }

    private fun openCommentedPage() {
        val intent = Intent(requireContext(), CommentedActivity::class.java)
        startActivity(intent)
    }

    private fun openSettingsPage() {
        val intent = Intent(requireContext(), SettingsActivity::class.java)
        startActivity(intent)
    }

    private fun logout() {
        Toast.makeText(requireContext(), "Đăng xuất thành công", Toast.LENGTH_SHORT).show()

        val intent = Intent(requireContext(), LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
