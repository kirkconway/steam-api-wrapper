package com.discobeard.dota2.api.wrapper.requests

import com.discobeard.dota2.api.wrapper.BaseSpec
import com.discobeard.dota2.api.wrapper.to.getgameitems.GetGameItems
import com.sun.jersey.api.client.Client

class GetGameItemsRequestTest extends BaseSpec {

    Client client = Client.create()
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
