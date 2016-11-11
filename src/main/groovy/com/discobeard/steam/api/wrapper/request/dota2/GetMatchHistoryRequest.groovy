package com.discobeard.steam.api.wrapper.request.dota2

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.dota2.getmatchhistory.GetMatchHistory
import org.asynchttpclient.AsyncHttpClient

class GetMatchHistoryRequest extends Request<GetMatchHistory> {

    private static final PATH = 'IDOTA2Match_570/GetMatchHistory/V001/'

    GetMatchHistoryRequest(AsyncHttpClient client, String baseUrl, String key) {
        super(client, newGetBuilder(baseUrl + '/' + PATH), GetMatchHistory.class)
        addKey(key)
    }

    GetMatchHistoryRequest withHeroId(String heroId) {
        requestBuilder.addQueryParam("hero_id", heroId)
        this
    }

    GetMatchHistoryRequest withGameMode(String gameMode) {
        requestBuilder.addQueryParam("game_mode", gameMode)
        this
    }

    GetMatchHistoryRequest withMinPlayers(String minPlayers) {
        requestBuilder.addQueryParam("min_players", minPlayers)
        this
    }

    GetMatchHistoryRequest withMatchesRequested(String matchesRequested) {
        requestBuilder.addQueryParam("matches_requested", matchesRequested)
        this
    }

    GetMatchHistoryRequest withAccountId(String accountId) {
        requestBuilder.addQueryParam("account_id", accountId)
        this
    }
}
