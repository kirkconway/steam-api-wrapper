package com.discobeard.dota2.api.wrapper.to.getmatchhistory

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class GetMatchHistory {
    GetMatchHistoryResult result
}
