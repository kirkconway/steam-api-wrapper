package com.discobeard.steam.api.wrapper.request.player

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.player.getplayersummaries.GetPlayerSummaries

import javax.ws.rs.client.Client

class GetPlayerSummariesRequest extends Request<GetPlayerSummaries> {

    private static final PATH = 'ISteamUser/GetPlayerSummaries/v0002/'

    GetPlayerSummariesRequest(Client client, String baseUrl, String key){
        super(client, baseUrl, PATH, key)
        this.returnType = GetPlayerSummaries.class
    }

    GetPlayerSummariesRequest withSteamIds(String[] steamIds){
        resource+= "&steamids=${getSteamAccountIdString(steamIds)}"
        this
    }

    private String getSteamAccountIdString(String[] steamIds) {
        String convertedIds = ''

        for(int i=0;i<steamIds.length;i++){
            convertedIds += steamIds[i] + (i!= steamIds.length-1 ? ',' :'')
        }

        convertedIds
    }
}
