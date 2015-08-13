package com.discobeard.dota2.api.wrapper.to.getmatchhistory

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
