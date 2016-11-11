package com.discobeard.steam.api.wrapper.request.dota2

import com.discobeard.steam.api.wrapper.BaseSpec
import com.discobeard.steam.api.wrapper.response.dota2.getmatchhistory.GetMatchHistory
import org.mockserver.model.HttpRequest

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
        given:
            steamReturnsMatchHistoryResponse()
        when:
            steamApiWrapper.dota2.getMatchHistoryRequest().withHeroId("heroId").submit()
        then:
            mockServer.verify(HttpRequest.request().withQueryStringParameter('hero_id','heroId'))
    }

    def 'attaches game mode to request'() {
        given:
            steamReturnsMatchHistoryResponse()
        when:
            steamApiWrapper.dota2.getMatchHistoryRequest().withGameMode("gamemode").submit()
        then:
            mockServer.verify(HttpRequest.request().withQueryStringParameter('game_mode','gamemode'))
    }

    def 'attaches mid players to request'() {
        given:
            steamReturnsMatchHistoryResponse()
        when:
            steamApiWrapper.dota2.getMatchHistoryRequest().withMinPlayers("1").submit()
        then:
            mockServer.verify(HttpRequest.request().withQueryStringParameter('min_players','1'))
    }

    def 'attaches matches requested to request'() {
        given:
            steamReturnsMatchHistoryResponse()
        when:
            steamApiWrapper.dota2.getMatchHistoryRequest().withMatchesRequested("1").submit()
        then:
            mockServer.verify(HttpRequest.request().withQueryStringParameter('matches_requested','1'))
    }

    def 'attaches with accountId to request'() {
        given:
            steamReturnsMatchHistoryResponse()
        when:
            steamApiWrapper.dota2.getMatchHistoryRequest().withAccountId("1").submit()
        then:
            mockServer.verify(HttpRequest.request().withQueryStringParameter('account_id','1'))
    }
}
