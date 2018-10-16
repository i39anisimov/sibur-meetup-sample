package io.sibur.sample.feature

import android.arch.lifecycle.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.sibur.api.models.Quote
import io.sibur.api.quotes.IQuotesApi
import io.sibur.api.quotes.QuotesApi

class MainViewModel: ViewModel(), LifecycleObserver {

    var quotesApi: IQuotesApi = QuotesApi()

    val quoteLiveData = MutableLiveData<Quote>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onStart() {
        getQuote()
    }

    fun getQuote() {
        quotesApi.getRandomQuote()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ quoteLiveData.value = it }, { it.printStackTrace() } )
    }
}