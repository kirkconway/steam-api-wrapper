package com.discobeard.steam.api.wrapper.request.dota2

import com.discobeard.steam.api.wrapper.request.Request
import com.discobeard.steam.api.wrapper.response.dota2.getgameitems.GetGameItems
import org.asynchttpclient.AsyncHttpClient

class GetGameItemsRequest extends Request<GetGameItems> {

    private static final PATH = 'IEconDOTA2_570/GetGameItems/V001/'

    GetGameItemsRequest(AsyncHttpClient client, String baseUrl, String key) {
        super(client, baseUrl, PATH, key)
        returnType = GetGameItems.class
    }

    GetGameItemsRequest withLanguage(String language) {
        resource += "&language=${language}"
        this
    }

}
