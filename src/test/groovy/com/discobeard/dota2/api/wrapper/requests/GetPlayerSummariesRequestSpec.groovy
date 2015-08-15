package com.discobeard.dota2.api.wrapper.requests

import com.discobeard.dota2.api.wrapper.BaseSpec
import com.discobeard.dota2.api.wrapper.domain.SteamId
import com.discobeard.dota2.api.wrapper.to.getplayersummaries.GetPlayerSummaries
import com.sun.jersey.api.client.Client

class GetPlayerSummariesRequestSpec extends BaseSpec {

    Client client = Client.create()
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
