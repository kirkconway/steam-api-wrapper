package com.discobeard.steam.api.wrapper.request.dota2

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.dota2.getmatchhistory.GetMatchHistory

import javax.ws.rs.client.Client

class GetMatchHistoryRequest extends Request<GetMatchHistory> {

    private static final PATH = 'IDOTA2Match_570/GetMatchHistory/V001/'

    public GetMatchHistoryRequest(Client client, String baseUrl, String key){
        super(client, baseUrl, PATH, key)
        this.returnType = GetMatchHistory.class
    }

    public GetMatchHistoryRequest withHeroId(String heroId){
        resource += "&hero_id=${heroId}"
        this
    }

    public GetMatchHistoryRequest withGameMode(String gameMode){
        resource += "&game_mode=${gameMode}"
        this
    }

    public GetMatchHistoryRequest withMinPlayers(String minPlayers){
        resource += "&min_players=${minPlayers}"
        this
    }

    public GetMatchHistoryRequest withMatchesRequested(String matchesRequested){
        resource += "&matches_requested=${matchesRequested}"
        this
    }

    public GetMatchHistoryRequest withAccountId(String accountId){
        resource += "&account_id=${accountId}"
        this
    }
}
