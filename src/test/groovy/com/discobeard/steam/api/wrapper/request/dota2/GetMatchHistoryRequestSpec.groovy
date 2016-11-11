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

    def 'attaches hero id to request'() {
        when:
            GetMatchHistoryRequest request = steamApiWrapper.dota2.getMatchHistoryRequest().withHeroId("heroId")
        then:
            request.resource.contains("&hero_id=heroId")
    }

    def 'attaches game mode to request'() {
        when:
        GetMatchHistoryRequest request = steamApiWrapper.dota2.getMatchHistoryRequest().withGameMode("gamemode")
        then:
        request.resource.contains("&game_mode=gamemode")
    }

    def 'attaches mid players to request'() {
        when:
        GetMatchHistoryRequest request = steamApiWrapper.dota2.getMatchHistoryRequest().withMinPlayers("1")
        then:
        request.resource.contains("&min_players=1")
    }

    def 'attaches matches requested to request'() {
        when:
        GetMatchHistoryRequest request = steamApiWrapper.dota2.getMatchHistoryRequest().withMatchesRequested("1")
        then:
        request.resource.contains("&matches_requested=1")
    }

    def 'attaches with accountId to request'() {
        when:
        GetMatchHistoryRequest request = steamApiWrapper.dota2.getMatchHistoryRequest().withAccountId("1")
        then:
        request.resource.contains("&account_id=1")
    }
}
