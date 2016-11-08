package com.discobeard.steam.api.wrapper.request.dota2

import com.discobeard.steam.api.wrapper.BaseSpec
import com.discobeard.steam.api.wrapper.response.dota2.getmatchhistory.GetMatchHistory

class GetMatchHistoryRequestSpec extends BaseSpec {

    def 'match details are converted correctly'() {
        given:
            steamReturnsMatchHistoryResponse()
        when:
            GetMatchHistory matchHistory = steamApiWrapper.dota2.getMatchHistoryRequest().submit()
        then:
            matchHistory.result.status == 1
    }
}
