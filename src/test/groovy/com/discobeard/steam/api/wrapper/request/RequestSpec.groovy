package com.discobeard.steam.api.wrapper.request

import com.discobeard.steam.api.wrapper.BaseSpec
import com.discobeard.steam.api.wrapper.exception.SteamException
import com.discobeard.steam.api.wrapper.request.player.GetPlayerSummariesRequest
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException

class RequestSpec extends BaseSpec {

    def 'when steam does not respond or entity does not parse then a SteamException is thrown' (){
        given:

            GetPlayerSummariesRequest testObj = steamApiWrapper.player.playerSummariesRequest
        when:
            testObj.submit()
        then:
            SteamException ex = thrown()
            ex.message == "Could not connect to the steam api"
            ex.cause instanceof JsonMappingException

    }

    def 'when an entity does not parse then a SteamException is thrown' (){
        given:
            GetPlayerSummariesRequest testObj = steamApiWrapper.player.playerSummariesRequest
            returnUnparsablePlayerSummaries()
        when:
            testObj.submit()
        then:
            testObj
            SteamException ex = thrown()
            ex.message == "Could not parse response from steam"
            ex.cause instanceof JsonParseException
    }


}
