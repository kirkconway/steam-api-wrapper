package com.discobeard.dota2.api.wrapper.requests

import com.discobeard.dota2.api.wrapper.to.getplayersummaries.GetPlayerSummaries
import com.sun.jersey.api.client.Client

class GetPlayerSummariesRequest extends Request<GetPlayerSummaries>{

    private static final PATH = 'ISteamUser/GetPlayerSummaries/v0002/'

    public GetPlayerSummariesRequest(Client client, String baseUrl, String key){
        super(client, baseUrl, PATH, key)
        this.returnType = GetPlayerSummaries.class
    }

    public GetPlayerSummariesRequest withSteamIds(String[] steamIds){
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
