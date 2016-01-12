package com.discobeard.dota2.api.wrapper.to.getplayersummaries

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class GetPlayerSummaries {
    GetPlayerSummariesResponse response
}
