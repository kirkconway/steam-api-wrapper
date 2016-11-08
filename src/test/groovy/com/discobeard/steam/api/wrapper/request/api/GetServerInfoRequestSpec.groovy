package com.discobeard.steam.api.wrapper.request.api

import com.discobeard.steam.api.wrapper.BaseSpec
import com.discobeard.steam.api.wrapper.response.api.getserverinfo.GetServerInfoResponse

class GetServerInfoRequestSpec extends BaseSpec {

    def "when request is converted successfully"() {
        given:
            steamReturnsGetServerInfoResponse()
        when:
            GetServerInfoResponse response = steamApiWrapper.api.serverInfoRequest.submit()
        then:
            response.servertime == 1478615552l
            response.servertimestring == "Tue Nov 08 06:32:32 2016"
    }

}
