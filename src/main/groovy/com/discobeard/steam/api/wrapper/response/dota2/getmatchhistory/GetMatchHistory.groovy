package com.discobeard.steam.api.wrapper.response.dota2.getmatchhistory

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class GetMatchHistory {
    GetMatchHistoryResult result
}
