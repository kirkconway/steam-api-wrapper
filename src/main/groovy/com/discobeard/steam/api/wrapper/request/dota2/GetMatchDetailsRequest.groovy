package com.discobeard.steam.api.wrapper.request.dota2

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.dota2.getmatchdetails.GetMatchDetails

import javax.ws.rs.client.Client

class GetMatchDetailsRequest extends Request<GetMatchDetails> {

    private static final PATH = 'IDOTA2Match_570/GetMatchDetails/V001/'

    GetMatchDetailsRequest(Client client, String baseUrl, String key) {
        super(client, baseUrl, PATH, key)
        this.returnType = GetMatchDetails.class
    }

    GetMatchDetailsRequest withMatchId(String matchId) {
        resource += "&match_id=${matchId}"
        this
    }
}
