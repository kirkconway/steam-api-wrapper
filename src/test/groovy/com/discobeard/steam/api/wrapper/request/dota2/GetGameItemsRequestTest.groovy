package com.discobeard.steam.api.wrapper.request.dota2

import com.discobeard.steam.api.wrapper.BaseSpec
import com.discobeard.steam.api.wrapper.response.dota2.getgameitems.GetGameItems

class GetGameItemsRequestTest extends BaseSpec {

    def 'match details are converted correctly'() {
        given:
            steamReturnsGetItemsResponse()
        when:
            GetGameItems getGameItems = steamApiWrapper.dota2.gameItemsRequest.submit()
        then:
            getGameItems.result.items[0].id == 1
            getGameItems.result.items[0].localizedName == "Blink Dagger"
    }

    def 'with language correct adds the language param'() {
        when:
            GetGameItemsRequest request = steamApiWrapper.dota2.gameItemsRequest.withLanguage("en_us")
        then:
            request.resource == 'http://localhost:1080/IEconDOTA2_570/GetGameItems/V001/?key=key&language=en_us'
    }
}
