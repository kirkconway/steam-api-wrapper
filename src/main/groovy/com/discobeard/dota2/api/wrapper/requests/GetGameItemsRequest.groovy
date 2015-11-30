package com.discobeard.dota2.api.wrapper.requests

import com.discobeard.dota2.api.wrapper.to.getgameitems.GetGameItems

import javax.ws.rs.client.Client

class GetGameItemsRequest extends Request<GetGameItems>{

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
