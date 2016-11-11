package com.discobeard.steam.api.wrapper.request.dota2

import com.discobeard.steam.api.wrapper.BaseSpec
import com.discobeard.steam.api.wrapper.domain.LeaverStatus
import com.discobeard.steam.api.wrapper.response.dota2.getmatchdetails.GetMatchDetails
import org.mockserver.model.HttpRequest

import static com.discobeard.steam.api.wrapper.domain.Team.Dire
import static com.discobeard.steam.api.wrapper.domain.Team.Radiant

class GetMatchDetailsRequestSpec extends BaseSpec {

    def 'match details are converted correctly'() {
        given:
            returnMatchDetails()
        when:
            GetMatchDetails getMatchDetails = steamApiWrapper.dota2.getMatchDetailsRequest().submit()
        then:
            getMatchDetails.result.matchId == 1714311165
            getMatchDetails.result.winner == Radiant
            getMatchDetails.result.players[0].leaverStatus == LeaverStatus.None
            getMatchDetails.result.players[0].team == Radiant
            getMatchDetails.result.players[6].team == Dire

    }

    def 'with matchid correct adds the match id'() {
        given:
            returnMatchDetails()
        when:
            steamApiWrapper.dota2.getMatchDetailsRequest().withMatchId("12341").submit()
        then:
            mockServer.verify(HttpRequest.request().withQueryStringParameter('match_id','12341'))
    }

}
