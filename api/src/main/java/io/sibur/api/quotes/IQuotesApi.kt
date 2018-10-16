package io.sibur.api.quotes

import io.reactivex.Single
import io.sibur.api.models.Quote
import retrofit2.http.GET

interface IQuotesApi {
    @GET("api/quotes/random")
    fun getRandomQuote(): Single<Quote>
}