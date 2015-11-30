package com.discobeard.dota2.api.wrapper.requests

import com.discobeard.dota2.api.wrapper.BaseSpec
import com.discobeard.dota2.api.wrapper.domain.LeaverStatus
import com.discobeard.dota2.api.wrapper.to.getmatchdetails.GetMatchDetails

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder

import static com.discobeard.dota2.api.wrapper.domain.Team.Dire
import static com.discobeard.dota2.api.wrapper.domain.Team.Radiant

class GetMatchDetailsRequestSpec extends BaseSpec {

    Client client = ClientBuilder.newClient()
    GetMatchDetailsRequest testObj = new GetMatchDetailsRequest(client, "http://localhost:1080","key")

    def 'match details are converted correctly'(){
        given:
            returnMatchDetails()
        when:
            GetMatchDetails getMatchDetails =  testObj.submit()
        then:
            getMatchDetails.result.matchId == 1714311165
            getMatchDetails.result.winner == Radiant
            getMatchDetails.result.players[0].leaverStatus == LeaverStatus.None
            getMatchDetails.result.players[0].team == Radiant
            getMatchDetails.result.players[6].team == Dire

    }

    def 'with matchid correct adds the match id'() {
        when:
            testObj.withMatchId("12341")
        then:
            testObj.resource == 'http://localhost:1080/IDOTA2Match_570/GetMatchDetails/V001/?key=key&match_id=12341'
    }

}
