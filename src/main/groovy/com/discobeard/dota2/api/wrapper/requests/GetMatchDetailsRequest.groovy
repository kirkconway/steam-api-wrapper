package com.discobeard.dota2.api.wrapper.requests

import com.discobeard.dota2.api.wrapper.to.getmatchdetails.GetMatchDetails
import com.sun.jersey.api.client.Client

class GetMatchDetailsRequest extends Request {

    private static final PATH = 'IDOTA2Match_570/GetMatchDetails/V001/'

    public GetMatchDetailsRequest(Client client, String baseUrl, String key) {
        super(client, baseUrl, PATH, key)
        this.returnType = GetMatchDetails.class
    }

    public GetMatchDetailsRequest withMatchId(String matchId) {
        resource += "&match_id=${matchId}"
        this
    }
}
