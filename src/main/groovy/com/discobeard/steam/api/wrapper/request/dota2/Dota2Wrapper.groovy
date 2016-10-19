package com.discobeard.steam.api.wrapper.request.dota2

import com.discobeard.steam.api.wrapper.request.RequestWrapper

class Dota2Wrapper extends RequestWrapper{

    public GetMatchHistoryRequest getMatchHistoryRequest() {
        new GetMatchHistoryRequest(client, baseUrl, key)
    }

    public GetHeroesRequest getHeroesRequest() {
        new GetHeroesRequest(client, baseUrl, key)
    }

    public GetMatchDetailsRequest getMatchDetailsRequest() {
        new GetMatchDetailsRequest(client, baseUrl, key)
    }

    public GetGameItemsRequest getGameItemsRequest(){
        new GetGameItemsRequest(client, baseUrl, key)
    }
}
