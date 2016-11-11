package com.discobeard.steam.api.wrapper.request.api

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.api.getserverinfo.GetServerInfoResponse
import org.asynchttpclient.AsyncHttpClient

class GetServerInfoRequest extends Request<GetServerInfoResponse> {

    private static final PATH = 'ISteamWebAPIUtil/GetServerInfo/v0001/'

    GetServerInfoRequest(AsyncHttpClient client, String baseUrl, String key) {
        super(client, newGetBuilder(baseUrl + '/' + PATH), GetServerInfoResponse.class)
        requestBuilder.addQueryParam("key", key)
    }
}
