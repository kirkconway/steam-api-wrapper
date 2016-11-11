package com.discobeard.steam.api.wrapper.request.player

import com.discobeard.steam.api.wrapper.BaseSpec
import com.discobeard.steam.api.wrapper.domain.SteamId
import com.discobeard.steam.api.wrapper.response.player.getplayersummaries.GetPlayerSummaries
import org.mockserver.model.HttpRequest

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
            returnPlayerSummaries()
            String[] steamIds = ["12", "13", "14"]
        when:
            steamApiWrapper.player.getPlayerSummariesRequest().withSteamIds(steamIds).submit()
        then:
            mockServer.verify(HttpRequest.request().withQueryStringParameter('steamIds','12,13,14'))
    }
}
