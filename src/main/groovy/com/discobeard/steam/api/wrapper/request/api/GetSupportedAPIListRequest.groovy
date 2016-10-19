package com.discobeard.steam.api.wrapper.request.api

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.api.getsupportedapilist.GetSupportedApiListResponse

import javax.ws.rs.client.Client

class GetSupportedAPIListRequest extends Request {

    private static final PATH = 'ISteamWebAPIUtil/GetSupportedAPIList/v0001'

    GetSupportedAPIListRequest(Client client, String baseUrl, String key) {
        super(client, baseUrl, PATH, key)
        this.returnType = GetSupportedApiListResponse.class
    }
}
