package com.discobeard.steam.api.wrapper.request.player

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.player.getrecentlyplayedgames.GetRecentlyPlayedGames

import javax.ws.rs.client.Client

class GetRecentlyPlayedGamesRequest extends Request<GetRecentlyPlayedGames> {

    private static final PATH = 'IPlayerService/GetRecentlyPlayedGames/v0001/'

    GetRecentlyPlayedGamesRequest(Client client, String baseUrl, String key) {
        super(client, baseUrl, PATH, key)
        this.returnType = GetRecentlyPlayedGames.class
    }

    GetRecentlyPlayedGamesRequest withSteamId(String steamIds) {
        resource += "&steamid=$steamIds"
        this
    }
}
