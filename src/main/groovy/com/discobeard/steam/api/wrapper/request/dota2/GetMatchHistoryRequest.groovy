package com.discobeard.steam.api.wrapper.request.dota2

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.dota2.getmatchhistory.GetMatchHistory
import org.asynchttpclient.AsyncHttpClient

class GetMatchHistoryRequest extends Request<GetMatchHistory> {

    private static final PATH = 'IDOTA2Match_570/GetMatchHistory/V001/'

    GetMatchHistoryRequest(AsyncHttpClient client, String baseUrl, String key) {
        super(client, baseUrl, PATH, key)
        this.returnType = GetMatchHistory.class
    }

    GetMatchHistoryRequest withHeroId(String heroId) {
        resource += "&hero_id=${heroId}"
        this
    }

    GetMatchHistoryRequest withGameMode(String gameMode) {
        resource += "&game_mode=${gameMode}"
        this
    }

    GetMatchHistoryRequest withMinPlayers(String minPlayers) {
        resource += "&min_players=${minPlayers}"
        this
    }

    GetMatchHistoryRequest withMatchesRequested(String matchesRequested) {
        resource += "&matches_requested=${matchesRequested}"
        this
    }

    GetMatchHistoryRequest withAccountId(String accountId) {
        resource += "&account_id=${accountId}"
        this
    }
}
