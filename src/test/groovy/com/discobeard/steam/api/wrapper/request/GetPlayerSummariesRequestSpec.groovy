package com.discobeard.steam.api.wrapper.request

import com.discobeard.steam.api.wrapper.BaseSpec
import com.discobeard.steam.api.wrapper.domain.SteamId
import com.discobeard.steam.api.wrapper.request.player.GetPlayerSummariesRequest
import com.discobeard.steam.api.wrapper.response.player.getplayersummaries.GetPlayerSummaries

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder

class GetPlayerSummariesRequestSpec extends BaseSpec {

    Client client = ClientBuilder.newClient()
    GetPlayerSummariesRequest testObj = new GetPlayerSummariesRequest(client,"http://localhost:1080","key")

    def 'player summaries are converted correctly'(){
        given:
            returnPlayerSummaries()
        when:
            GetPlayerSummaries playerSummaries =  testObj.submit()
        then:
            playerSummaries.response.players.size() == 17
            playerSummaries.response.players[0].steamid instanceof SteamId
    }

    def 'steam ids are correctly split and added to the response'() {
        given:
            String[] steamIds = ["12","13","14"]
        when:
            testObj.withSteamIds(steamIds)
        then:
            testObj.resource == "http://localhost:1080/ISteamUser/GetPlayerSummaries/v0002/?key=key&steamids=12,13,14"
    }
}
