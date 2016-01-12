package com.discobeard.dota2.api.wrapper.requests

import com.discobeard.dota2.api.wrapper.to.getrecentlyplayedgames.GetRecentlyPlayedGames

import javax.ws.rs.client.Client

class GetRecentlyPlayedGamesRequest extends Request<GetRecentlyPlayedGames>{

    private static final PATH = 'IPlayerService/GetRecentlyPlayedGames/v0001/'

    public GetRecentlyPlayedGamesRequest(Client client, String baseUrl, String key){
        super(client, baseUrl, PATH, key)
        this.returnType = GetRecentlyPlayedGames.class
    }

    public GetRecentlyPlayedGamesRequest withSteamId(String steamIds){
        resource+= "&steamid=$steamIds"
        this
    }
}
