package com.gaston.events.data.network

import com.gaston.events.model.Event
import com.gaston.events.vo.Resource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

/**
 * Created by Gastón Saillén on 21 December 2019
 */
class EventsRepoImpl : IEventsRepo {

    override suspend fun getEventsDB(): Resource<MutableList<Event>> {
        val eventList = mutableListOf<Event>()
        val resultList = FirebaseFirestore.getInstance()
            .collection("events")
            .get().await()

        for (document in resultList) {
            val photoUrl = document.getString("photoUrl")
            val eventName = document.getString("eventName")
            val time = document.getString("time")
            eventList.add(Event(photoUrl!!, eventName!!, time!!))
        }

        return Resource.Success(eventList)
    }
}