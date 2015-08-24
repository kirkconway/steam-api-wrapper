package com.discobeard.dota2.api.wrapper.requests

import com.discobeard.dota2.api.wrapper.BaseSpec
import com.discobeard.dota2.api.wrapper.exception.SteamException
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
import com.sun.jersey.api.client.Client

class RequestSpec extends BaseSpec {

    Client client = Client.create()

    def 'when steam does not respond or entity does not parse then a SteamException is thrown' (){
        given:
            GetPlayerSummariesRequest testObj = new GetPlayerSummariesRequest(client,"http://localhost:10000","key")
        when:
            testObj.submit()
        then:
            SteamException ex = thrown()
            ex.message == "Could not connect to the steam api"
            ex.cause instanceof ConnectException

    }

    def 'when an entity does not parse then a SteamException is thrown' (){
        given:
            GetPlayerSummariesRequest testObj = new GetPlayerSummariesRequest(client,"http://localhost:1080","key")
            returnUnparsablePlayerSummaries()
        when:
            testObj.submit()
        then:
            SteamException ex = thrown()
            ex.message == "Could not parse response from steam"
            ex.cause instanceof UnrecognizedPropertyException
    }


}
