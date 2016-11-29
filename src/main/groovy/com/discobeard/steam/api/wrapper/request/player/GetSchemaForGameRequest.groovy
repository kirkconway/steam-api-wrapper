package com.discobeard.steam.api.wrapper.request.player

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.dota2.getschemaforgame.GetSchemaForGame

import javax.ws.rs.client.Client

class GetSchemaForGameRequest extends Request<GetSchemaForGame>{
    private static final PATH = 'ISteamUserStats/GetSchemaForGame/v2/'

    GetSchemaForGameRequest(Client client, String baseUrl, String key) {
        super(client, baseUrl, PATH, key)
        returnType = GetSchemaForGame.class
    }

    GetSchemaForGameRequest withAppId(String appId) {
        resource += "&appid=${appId}"
        this
    }

}
