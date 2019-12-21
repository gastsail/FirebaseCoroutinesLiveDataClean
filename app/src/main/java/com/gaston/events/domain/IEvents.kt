package com.gaston.events.domain

import com.gaston.events.model.Event
import com.gaston.events.vo.Resource

/**
 * Created by Gastón Saillén on 21 December 2019
 */
interface IEvents {
    suspend fun getEvents(): Resource<MutableList<Event>>
}