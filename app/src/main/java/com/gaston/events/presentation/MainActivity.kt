package com.gaston.events.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gaston.events.*
import com.gaston.events.data.network.EventsRepoImpl
import com.gaston.events.domain.EventsImpl
import com.gaston.events.vo.Resource

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProviders.of(this,
        EventsVMFactory(EventsImpl(EventsRepoImpl()))
    ).get(
        EventsViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchEventList.observe(this, Observer {

            when (it) {

                is Resource.Loading -> {
                    // Before try catch in viewmodel we can use emit(Resource.Loading()) to tell the view we started fetching results and this will be triggered
                }

                is Resource.Success -> {
                    // we get the list data with it.data
                }

                is Resource.Failure -> {
                    //Handle the failure
                    Toast.makeText(
                        this,
                        "An error has ocurred:${it.throwable.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }


        })
    }
}
