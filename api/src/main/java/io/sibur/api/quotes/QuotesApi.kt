package io.sibur.api.quotes

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.sibur.api.models.Quote
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class QuotesApi: IQuotesApi {

    private var service: IQuotesApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://talaikis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        service = retrofit.create<IQuotesApi>(IQuotesApi::class.java)
    }

    override fun getRandomQuote(): Single<Quote> {
        return service.getRandomQuote()
            .subscribeOn(Schedulers.io())
    }

}