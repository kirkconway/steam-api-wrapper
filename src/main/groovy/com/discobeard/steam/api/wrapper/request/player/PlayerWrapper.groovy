package com.discobeard.steam.api.wrapper.request.player

import com.discobeard.steam.api.wrapper.request.RequestWrapper

class PlayerWrapper extends RequestWrapper{

    GetRecentlyPlayedGamesRequest getRecentlyPlayedGamesRequest(){
        new GetRecentlyPlayedGamesRequest(client, baseUrl, key)
    }

    GetPlayerSummariesRequest getPlayerSummariesRequest(){
        new GetPlayerSummariesRequest(client, baseUrl, key)
    }
}
