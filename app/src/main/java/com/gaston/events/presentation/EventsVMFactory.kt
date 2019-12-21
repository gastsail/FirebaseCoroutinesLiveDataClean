package com.gaston.events.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaston.events.domain.IEvents

/**
 * Created by Gastón Saillén on 21 December 2019
 */
class EventsVMFactory(private val useCase: IEvents): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IEvents::class.java).newInstance(useCase)
    }
}