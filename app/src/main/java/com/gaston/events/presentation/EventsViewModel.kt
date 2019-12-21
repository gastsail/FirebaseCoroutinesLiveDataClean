package com.gaston.events.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.gaston.events.domain.IEvents
import com.gaston.events.vo.Resource
import kotlinx.coroutines.Dispatchers

/**
 * Created by Gastón Saillén on 21 December 2019
 */
class EventsViewModel(private val useCase: IEvents):ViewModel() {

    val fetchEventList = liveData(Dispatchers.IO){
        try {
            val eventList = useCase.getEvents()
            emit(eventList)

        }catch (e:Exception){
            emit(Resource.Failure(e.cause!!))
        }

    }
}