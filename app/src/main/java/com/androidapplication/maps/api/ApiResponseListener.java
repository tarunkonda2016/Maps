package com.androidapplication.maps.api;

import retrofit2.Call;
import retrofit2.Response;

public interface ApiResponseListener {
    /**
     * Call on success API response with request code
     *
     * @param call     API Request object
     * @param response Response of called API
     * @param reqCode  Request code of called API
     */
    void onApiResponse(Call<Object> call, Response<Object> response, int reqCode);

    /**
     * Call on success API response with request code and passed position
     *
     * @param call     API Request object
     * @param response Response of called API
     * @param reqCode  Request code of called API
     * @param position Position which is passed at API request time
     */
    void onApiResponse(Call<Object> call, Response<Object> response, int reqCode, int position);

    /**
     * Call on error of API with request code
     *
     * @param call    API Request object
     * @param object  Message to for display error
     * @param reqCode Request code of called API*
     */
    void onApiError(Call<Object> call, Object object, int reqCode);

    /**
     * Called when some thing not found in API. (e.g. Requested Spot is not found/inactive, Requested post is deleted).
     * When error code is 404 then this method will be called
     *
     * @param call    API Request object
     * @param object  Message to for display error
     * @param reqCode Request code of called API
     */
    void onDataNotFound(Call<Object> call, Object object, int reqCode);

}
