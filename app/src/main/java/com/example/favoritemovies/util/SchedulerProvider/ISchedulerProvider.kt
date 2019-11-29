package com.example.favoritemovies.util.SchedulerProvider

import io.reactivex.Scheduler

interface ISchedulerProvider {

    fun computation(): Scheduler
    fun io(): Scheduler
    fun ui(): Scheduler

}