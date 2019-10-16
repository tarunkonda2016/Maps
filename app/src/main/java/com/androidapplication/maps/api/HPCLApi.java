package com.androidapplication.maps.api;

import com.androidapplication.maps.models.Places;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HPCLApi {


    @FormUrlEncoded
    @POST("users/generate-otp")
    Call<Places> generateOtp();


//
//    @FormUrlEncoded
//    @POST("users/verify-otp")
//    Call<VerifyOtpModel> verifyOtp(@Field("mobile") String mobile, @Field("otp") String otp, @Field("os_type") String os_type, @Field("device_token") String device_token);
//
//    @FormUrlEncoded
//    @POST("users/register-user")
//    Call<VerifyOtpModel> regiterUser(@Field("mobile") String mobile, @Field("firstName") String firstName, @Field("lastName") String lastName,
//                                     @Field("role") String roleId, @Field("state") int state, @Field("city") int city, @Field("os_type") String os_type, @Field("device_token") String device_token);
//
//    @FormUrlEncoded
//    @POST("users/register-user")
//    Call<VerifyOtpModel> regiterUserRetialer(@Field("mobile") String mobile, @Field("firstName") String firstName, @Field("lastName") String lastName,
//                                             @Field("role") String roleId, @Field("state") int state, @Field("city") int city, @Field("os_type") String os_type, @Field("device_token") String device_token, @Field("subRetailer1_name") String subRetailer1_name,
//                                             @Field("subRetailer1_mobile") String subRetailer1_mobile, @Field("subRetailer2_name") String subRetailer2_name, @Field("subRetailer2_mobile") String subRetailer2_mobile);
//
//
//    @FormUrlEncoded
//    @POST("users/register-user")
//    Call<VerifyOtpModel> regiterUserRetialer2(@FieldMap Map<String, String> fields);
//
//    @GET("users/my-profile")
//    Call<MyAccountModel> getMyAccountDetails();
//
//    @FormUrlEncoded
//    @POST("users/update-profile")
//    Call<EditMyProfileModel> editMyProfile(@Field("mobile") String mobile, @Field("firstName") String firstName, @Field("lastName") String lastName,
//                                           @Field("role") String roleId, @Field("state") int state, @Field("city") int city);
//
//
//    @FormUrlEncoded
//    @POST("users/update-profile")
//    Call<EditMyProfileModel> editMyProfileRetailer(@Field("mobile") String mobile, @Field("firstName") String firstName, @Field("lastName") String lastName,
//                                                   @Field("role") String roleId, @Field("state") int state, @Field("city") int city, @Field("subRetailer1_name") String subName1,
//                                                   @Field("subRetailer1_mobile") String subMobile, @Field("subRetailer2_name") String subName2, @Field("subRetailer2_mobile") String subMobile2);
//
//    @FormUrlEncoded
//    @POST("users/update-profile")
//    Call<EditMyProfileModel> editMyProfileRetailer2(@FieldMap Map<String, String> fields);
//
//    /**
//     * for Retailer api..!!
//     *
//     * @return
//     */
//
//
//    @GET("reatailers/gift-catalogues")
//    Call<GiftModel> getGiftList();
//
//    @GET("reatailers/track-your-gifts")
//    Call<List<TrackGiftModel>> getTrackGiftList();
//
//    @GET("generals/tnc-content")
//    Call<TnCModel> getTnC();
//
//    @FormUrlEncoded
//    @POST("reatailers/place-order")
//    Call<PlaceGiftOrderModel> placeOrderOfGift(@Field("giftCatalogue") int giftCatalogue, @Field("shippingAddress") String shippingAddress, @Field("isRegular") int isRegular,
//                                               @Field("name") String name, @Field("mobile") String mobile, @Field("email") String email, @Field("state") int state, @Field("city") int city,
//                                               @Field("pincode") String pincode);
//
//    @GET("generals/states")
//    Call<List<StateModel>> getStateList();
//
//    @GET("generals/cities")
//    Call<List<CityModel>> getCityList(@Query("id") int id);
//
//    @FormUrlEncoded
//    @POST("generals/contact-us")
//    Call<ContactUsModel> contactus(@Field("email") String email, @Field("enquiry") String enquiry);
//
//    @GET("reatailers/transactions")
//    Call<TransactionListModel> getLastFiveTransaction();
//
//    @GET("reatailers/transactions")
//    Call<TransactionListModel> getTransactionList(@Query("type") String type, @Query("start-date") String startDate, @Query("end-date") String endDate, @Query("timestamp") String timestamp);
//
//    @GET("reatailers/get-transaction-data")
//    Call<TransactionDetailModel> getTransactionDetail(@Query("tid") int tid, @Query("type") String type);
//
//    @FormUrlEncoded
//    @POST("reatailers/retailer-scan")
//    Call<QRCodeModel> qrRetailerCode(@Field("qrcode") String qrcode);
//
//
//    @FormUrlEncoded
//    @POST("reatailers/verify-scannedotp")
//    Call<MechanicOtpResponse> verifyMechanicOtp(@Field("mobile") String mobile, @Field("otp") String otp, @Field("qrcode") String qrcode);
//
//    @FormUrlEncoded
//    @POST("reatailers/regenerate-otp")
//    Call<MechanicResendOtpResponse> resendMechanicOtp(@Field("mobile") String mobile, @Field("isResend") String isResend);
//
//
//    @GET("generals/faqs")
//    Call<FaqModel> getFaqs();
//
//    @FormUrlEncoded
//    @POST("generals/set-logs")
//    Call<SetLogsModel> setLogs(@Field("logIdentifier") String logIdentifier, @Field("dataJson") String dataJson);
//
//    @GET("users/get-banner")
//    Call<BannersModel> getBanners(@Query("width") String width);
//
//    @GET("generals/get-languages")
//    Call<List<LanguageModel>> getlanguages();
//
//    @FormUrlEncoded
//    @POST("generals/set-language")
//    Call<SetLanguageModel> setlanguage(@Field("language") String language, @Field("isUpdate") String isUpdate);
//
//    @GET("generals/settings")
//    Call<SettingsModel> getContactNoSettings();
//
//
//    /**
//     * for customers api..!!
//     *
//     * @return
//     */
//
//    @FormUrlEncoded
//    @POST("customers/customer-ecash")
//    Call<QRCodeModel> qrCode(@Field("qrcode") String qrcode);
//
//    @GET("customers/customer-transactions")
//    Call<MechanicTransactionListModel> getCustomerLastFiveTransaction();
//
//    @GET("customers/customer-transactions")
//    Call<MechanicTransactionListModel> getCustomerTransactionList(@Query("type") String type, @Query("start-date") String startDate, @Query("end-date") String endDate, @Query("timestamp") String timestamp);
//
//
//
//    /**
//     * Transporter Api call
//     *
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("transporters/transporter-scan")
//    Call<QRCodeModel> qrTransporterCode(@Field("qrcode") String qrcode);
//
//    @GET("transporters/transactions")
//    Call<MechanicTransactionListModel> getTransporterLastFiveTransaction();
//
//    @GET("transporters/gift-catalogues")
//    Call<GiftModel> getTransportersGiftList();
//
//    @FormUrlEncoded
//    @POST("transporters/place-order")
//    Call<PlaceGiftOrderModel> transporterPlaceOrderOfGift(@Field("giftCatalogue") int giftCatalogue, @Field("shippingAddress") String shippingAddress, @Field("isRegular") int isRegular,
//                                                          @Field("name") String name, @Field("mobile") String mobile, @Field("email") String email, @Field("state") int state, @Field("city") int city,
//                                                          @Field("pincode") String pincode);
//
//    @GET("transporters/track-your-gifts")
//    Call<List<TrackGiftModel>> getTransportersTrackGiftList();
//
//
//    @GET("transporters/get-transaction-data")
//    Call<TransactionDetailModel> getTransporterTransactionDetail(@Query("tid") int tid, @Query("type") String type);
//
//    @GET("transporters/transactions")
//    Call<TransactionListModel> getTransportersTransactionList(@Query("type") String type, @Query("start-date") String startDate, @Query("end-date") String endDate, @Query("timestamp") String timestamp);
//
//
//
//    /**
//     * Api call for Mechanic Role..!!
//     *
//     * @return
//     */
//
//    @GET("mechanics/mechanic-transactions")
//    Call<MechanicTransactionListModel> getMechanicLastFiveTransaction();
//
//    @GET("mechanics/mechanic-transactions")
//    Call<TransactionListModel> getMechanicTransactionList(@Query("type") String type, @Query("start-date") String startDate, @Query("end-date") String endDate, @Query("timestamp") String timestamp);
//
//    @FormUrlEncoded
//    @POST("mechanics/mechanic-ecash")
//    Call<QRCodeModel> qrMechanicCode(@Field("qrcode") String qrcode);
//
//    @GET("mechanics/gift-catalogues")
//    Call<GiftModel> getMechanicGiftList();
//
//    @FormUrlEncoded
//    @POST("mechanics/place-order")
//    Call<PlaceGiftOrderModel> mechanicPlaceOrderOfGift(@Field("giftCatalogue") int giftCatalogue, @Field("shippingAddress") String shippingAddress, @Field("isRegular") int isRegular,
//                                                       @Field("name") String name, @Field("mobile") String mobile, @Field("email") String email, @Field("state") int state, @Field("city") int city,
//                                                       @Field("pincode") String pincode);
//
//    @GET("mechanics/track-your-gifts")
//    Call<List<TrackGiftModel>> getMechanicsTrackGiftList();
//
//    @GET("mechanics/get-transaction-data")
//    Call<TransactionDetailModel> getMechanicTransactionDetail(@Query("tid") int tid, @Query("type") String type);
//
//
//    @GET("users/my-notification")
//    Call<NotificationResponse> getNotificationList();
//
//    @FormUrlEncoded
//    @POST("mechanics/mechanic-points-update")
//    Call<PaytmModel> paytmSendData(@Field("pointsUpdate") String qrcode);
//

}