package com.discobeard.steam.api.wrapper.request.player

import com.discobeard.steam.api.wrapper.BaseSpec
import com.discobeard.steam.api.wrapper.domain.SteamId
import com.discobeard.steam.api.wrapper.response.player.getplayersummaries.GetPlayerSummaries

class GetPlayerSummariesRequestSpec extends BaseSpec {

    def 'player summaries are converted correctly'() {
        given:
            returnPlayerSummaries()
        when:
            GetPlayerSummaries playerSummaries = steamApiWrapper.player.getPlayerSummariesRequest().submit()
        then:
            playerSummaries.response.players.size() == 17
            playerSummaries.response.players[0].steamid instanceof SteamId
    }

    def 'steam ids are correctly split and added to the response'() {
        given:
            String[] steamIds = ["12", "13", "14"]
        when:
            GetPlayerSummariesRequest request = steamApiWrapper.player.getPlayerSummariesRequest().withSteamIds(steamIds)
        then:
            request.resource == "http://localhost:1080/ISteamUser/GetPlayerSummaries/v0002/?key=key&steamids=12,13,14"
    }
}
