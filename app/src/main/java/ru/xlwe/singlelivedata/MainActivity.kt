package ru.xlwe.singlelivedata

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.xlwe.singlelivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textView1.setOnClickListener {
            viewModel.changeValueSuccess()
        }

        binding.textView2.setOnClickListener {
            viewModel.changeValueFail()
        }

        viewModel.observeSuccess(this) {
            it.getContentOrNot() { value ->
                Snackbar.make(binding.root, value, Snackbar.LENGTH_SHORT).show()
            }
        }

        viewModel.observeError(this) {
            it.getContentOrNot() { value ->
                Snackbar.make(binding.root, value, Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}