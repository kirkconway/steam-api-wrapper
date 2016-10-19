package com.discobeard.steam.api.wrapper.response.dota2.getmatchhistory

import com.fasterxml.jackson.annotation.JsonProperty

class GetMatchHistoryResult {

    @JsonProperty(value = 'num_results')
    int numberOfResults
    @JsonProperty(value = 'total_results')
    int totalResults
    @JsonProperty(value = 'results_remaining')
    int resultsRemaining
    int status
    Match[] matches
}
