package com.discobeard.steam.api.wrapper.request.dota2

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.dota2.getgameitems.GetGameItems

import javax.ws.rs.client.Client

class GetGameItemsRequest extends Request<GetGameItems> {

    private static final PATH = 'IEconDOTA2_570/GetGameItems/V001/'

    GetGameItemsRequest(Client client, String baseUrl, String key) {
        super(client, baseUrl, PATH, key)
        returnType = GetGameItems.class
    }

    public GetGameItemsRequest withLanguage(String language){
        resource += "&language=${language}"
        this
    }
}
