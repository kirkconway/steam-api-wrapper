package com.discobeard.dota2.api.wrapper.requests

import com.discobeard.dota2.api.wrapper.BaseSpec
import com.discobeard.dota2.api.wrapper.to.getmatchhistory.GetMatchHistory

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder

class GetMatchHistoryRequestSpec extends BaseSpec {

    Client client = ClientBuilder.newClient()
    GetMatchHistoryRequest testObj = new GetMatchHistoryRequest(client, "http://localhost:1080","key")

    def 'match details are converted correctly'(){
        given:
            returnMatchHistory()
        when:
            GetMatchHistory matchHistory =  testObj.submit()
        then:
            matchHistory.result.status == 1
    }
}
