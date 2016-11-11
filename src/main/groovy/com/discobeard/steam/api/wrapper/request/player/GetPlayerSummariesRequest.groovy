package com.discobeard.steam.api.wrapper.request.player

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.player.getplayersummaries.GetPlayerSummaries
import org.asynchttpclient.AsyncHttpClient

class GetPlayerSummariesRequest extends Request<GetPlayerSummaries> {

    private static final PATH = 'ISteamUser/GetPlayerSummaries/v0002/'

    GetPlayerSummariesRequest(AsyncHttpClient client, String baseUrl, String key) {
        super(client, newGetBuilder(baseUrl+'/'+PATH), GetPlayerSummaries.class)
        requestBuilder.addQueryParam("key", key)
    }

    GetPlayerSummariesRequest withSteamIds(String[] steamIds) {
        requestBuilder.addQueryParam("steamids", "${getSteamAccountIdString(steamIds)}")
        this
    }

    private String getSteamAccountIdString(String[] steamIds) {
        String convertedIds = ''

        for (int i = 0; i < steamIds.length; i++) {
            convertedIds += steamIds[i] + (i != steamIds.length - 1 ? ',' : '')
        }

        convertedIds
    }
}
