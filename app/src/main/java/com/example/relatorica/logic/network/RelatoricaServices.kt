package com.example.relatorica.logic.network

import com.example.relatorica.logic.models.ParentModel
import com.example.relatorica.logic.network.RestClient.Companion.PARENTS
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface RelatoricaServices {

    /*
    @POST(LOGIN)
    fun login(@Body requestBody: JsonObject): Call<RestView<JsonObject>>

    @GET(APPOINTMENTS)
    fun getAppts(@Header("access_token") accessToken: String, @Path("user_id") userId: Int): Call<ApptModel.Response>

    @POST(SIGNUP_USER)
    fun signup(@Body requestBody: JsonObject): Call<RestView<JsonObject>>
    @POST(FINISH_APPOINTMENT)
    fun finishAppointment(@Header("access_token") accessToken: String,
                          @Path("appt_id") appointmentId: Int,
                          @Body requestBody: JsonObject
    ): Call<RestView<JsonObject>>


     */

    @GET(PARENTS)
    fun getParents(@Header("Authorization") authorization: String): Call<ParentModel.Response>

}