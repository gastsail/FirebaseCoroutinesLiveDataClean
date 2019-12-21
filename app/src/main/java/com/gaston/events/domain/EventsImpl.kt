package com.gaston.events.domain

import com.gaston.events.model.Event
import com.gaston.events.vo.Resource
import com.gaston.events.data.network.IEventsRepo

/**
 * Created by Gastón Saillén on 21 December 2019
 */
class EventsImpl(private val eventsRepo: IEventsRepo): IEvents {

    override suspend fun getEvents(): Resource<MutableList<Event>> = eventsRepo.getEventsDB()
}