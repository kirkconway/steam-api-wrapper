package com.discobeard.steam.api.wrapper.response.dota2.getmatchdetails

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class GetMatchDetails {
    GetMatchDetailsResult result
}
