package com.discobeard.steam.api.wrapper.request.api

import com.discobeard.steam.api.wrapper.request.RequestWrapper

class ApiWrapper extends RequestWrapper{

    GetSupportedAPIListRequest getSupportedAPIListRequest(){
        new GetSupportedAPIListRequest(client, baseUrl, key)
    }

    GetServerInfoRequest getServerInfoRequest(){
        new GetServerInfoRequest(client, baseUrl, key)
    }
}
