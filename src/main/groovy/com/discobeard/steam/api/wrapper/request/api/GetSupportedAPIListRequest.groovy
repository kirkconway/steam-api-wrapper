package com.discobeard.steam.api.wrapper.request.api

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.api.getsupportedapilist.GetSupportedApiListResponse
import org.asynchttpclient.AsyncHttpClient

class GetSupportedAPIListRequest extends Request<GetSupportedApiListResponse> {

    private static final PATH = 'ISteamWebAPIUtil/GetSupportedAPIList/v0001'

    public GetSupportedAPIListRequest(AsyncHttpClient client, String baseUrl, String key) {
        super(client, newGetBuilder(baseUrl + '/' + PATH), GetSupportedApiListResponse.class)
        requestBuilder.addQueryParam('key', key)
    }
}
