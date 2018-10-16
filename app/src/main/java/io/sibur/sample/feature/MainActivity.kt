package io.sibur.sample.feature

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.sibur.sample.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscribeOnData()

        btnGetQuote.setOnClickListener { viewModel.getQuote() }

        lifecycle.addObserver(viewModel)
    }

    private fun subscribeOnData() {
        viewModel.quoteLiveData.observe(this, Observer {
            it?.let {
                tvQuote.text = it.quote
                tvAuthor.text = it.author
                tvCat.text = it.category
            }
        })
    }
}
