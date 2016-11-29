package com.discobeard.steam.api.wrapper.request.player

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.dota2.getplayerachievements.GetPlayerAchievements

import javax.ws.rs.client.Client

class GetPlayerAchievementsRequest extends Request<GetPlayerAchievements>{
    private static final PATH = 'ISteamUserStats/GetPlayerAchievements/v0001/'

    GetPlayerAchievementsRequest(Client client, String baseUrl, String key) {
        super(client, baseUrl, PATH, key)
        returnType = GetPlayerAchievements.class
    }

    GetPlayerAchievementsRequest withAppId(String appId) {
        resource += "&appid=${appId}"
        this
    }

    GetPlayerAchievementsRequest withSteamId(String steamId) {
        resource += "&steamid=${steamId}"
        this
    }

    GetPlayerAchievementsRequest withLanguage(String language) {
        resource += "&l=${language}"
        this
    }
}
