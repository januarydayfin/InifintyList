package com.krayapp.inifintylist.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.addRepeatingJob
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.inifintylist.R
import com.krayapp.inifintylist.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val postsAdapter by lazy { PagingAdapter() }
    private val viewModel:MainViewModel by viewModel()
    private val viewBinding:ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.postsRecycler.adapter = postsAdapter
        addRepeatingJob(Lifecycle.State.STARTED){
            viewModel.hotPost.collectLatest { postsAdapter.submitData(it) }
        }
    }
}