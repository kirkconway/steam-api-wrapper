package com.discobeard.steam.api.wrapper.request.api

import com.discobeard.steam.api.wrapper.BaseSpec
import com.discobeard.steam.api.wrapper.response.api.getsupportedapilist.GetSupportedApiListResponse

class GetSupportedApiListRequestSpec extends BaseSpec {

    def "response is converted correctly"() {
        given:
            steamReturnsSupportedApiListResponse()
        when:
            GetSupportedApiListResponse response = steamApiWrapper.api.getSupportedAPIListRequest().submit()
        then:
            response.apilist.interfaces.size() == 50
    }
}
