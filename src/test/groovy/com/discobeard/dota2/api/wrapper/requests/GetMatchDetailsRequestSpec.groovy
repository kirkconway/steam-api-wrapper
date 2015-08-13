package com.discobeard.dota2.api.wrapper.requests

import com.discobeard.dota2.api.wrapper.BaseSpec
import com.discobeard.dota2.api.wrapper.to.getmatchdetails.GetMatchDetails
import com.sun.jersey.api.client.Client

class GetMatchDetailsRequestSpec extends BaseSpec {

    Client client = Client.create()
    GetMatchDetailsRequest testObj = new GetMatchDetailsRequest(client, "http://localhost:1080","key")

    def 'match details are converted correctly'(){
        given:
            returnMatchDetails()
        when:
            GetMatchDetails getMatchDetails =  testObj.submit()
        then:
            getMatchDetails.result.matchId == 1466186419

    }

}
