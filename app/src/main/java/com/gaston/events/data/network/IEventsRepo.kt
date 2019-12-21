package com.gaston.events.data.network

import com.gaston.events.model.Event
import com.gaston.events.vo.Resource

/**
 * Created by Gastón Saillén on 21 December 2019
 */
interface IEventsRepo {

    suspend fun getEventsDB(): Resource<MutableList<Event>>
}