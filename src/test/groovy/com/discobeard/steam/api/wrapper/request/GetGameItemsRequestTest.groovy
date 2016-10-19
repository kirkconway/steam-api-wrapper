package com.discobeard.steam.api.wrapper.request

import com.discobeard.steam.api.wrapper.BaseSpec
import com.discobeard.steam.api.wrapper.request.dota2.GetGameItemsRequest
import com.discobeard.steam.api.wrapper.response.dota2.getgameitems.GetGameItems

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder

class GetGameItemsRequestTest extends BaseSpec {

    Client client = ClientBuilder.newClient()
    GetGameItemsRequest testObj = new GetGameItemsRequest(client, "http://localhost:1080","key")

    def 'match details are converted correctly'(){
        given:
            returnItems()
        when:
            GetGameItems getGameItems =  testObj.submit()
        then:
            getGameItems.result.items[0].id == 1
            getGameItems.result.items[0].localizedName == "Blink Dagger"
    }

    def 'with language correct adds the language param'(){
        when:
            testObj.withLanguage("en_us")
        then:
            testObj.resource == 'http://localhost:1080/IEconDOTA2_570/GetGameItems/V001/?key=key&language=en_us'

    }
}
