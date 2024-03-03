package com.example.oech.data.network

import com.example.oech.data.model.BalanceResponse
import com.example.oech.data.model.ChangePasswordBody
import com.example.oech.data.model.GetValidCodeBody
import com.example.oech.data.model.MessageResponse
import com.example.oech.data.model.PackageResponse
import com.example.oech.data.model.SendPackageBody
import com.example.oech.data.model.SignInBody
import com.example.oech.data.model.SignInResponse
import com.example.oech.data.model.SignInState
import com.example.oech.data.model.SignUpBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ApiService {
    @POST("signUp")
    suspend fun signUp(@Body body: SignUpBody)

    @POST("signIn")
    suspend fun signIn(@Body body: SignInBody): SignInResponse

    @POST("getValidCode")
    suspend fun getValidCode(@Body body: GetValidCodeBody): MessageResponse

    @GET("checkValidCode")
    suspend fun checkValidCode(
        @Query("email") email: String,
        @Query("valid_code") validCode: String
    ): MessageResponse

    @PUT("changePassword")
    suspend fun changePassword(@Body body: ChangePasswordBody)

    @GET("getBalance")
    suspend fun getBalance(@Header("token") token: String): BalanceResponse

    @POST("sendPackage")
    suspend fun sendPackage(
        @Header("token") token: String,
        @Body body: SendPackageBody
    ): PackageResponse
}