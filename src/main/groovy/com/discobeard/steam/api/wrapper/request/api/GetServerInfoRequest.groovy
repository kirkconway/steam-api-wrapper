package com.discobeard.steam.api.wrapper.request.api

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.api.getserverinfo.GetServerInfoResponse

import javax.ws.rs.client.Client

class GetServerInfoRequest extends Request<GetServerInfoResponse> {

    private static final PATH = 'ISteamWebAPIUtil/GetServerInfo/v0001/'

    GetServerInfoRequest(Client client, String baseUrl,String key) {
        super(client, baseUrl, PATH, key)
        this.returnType = GetServerInfoResponse.class
    }
}
