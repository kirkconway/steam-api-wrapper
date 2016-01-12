package com.discobeard.dota2.api.wrapper.to.getmatchhistory

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Match {

    @JsonProperty(value = 'match_id')
    long matchId
    @JsonProperty(value = 'match_seq_num')
    long matchSequenceNumber
    @JsonProperty(value = 'start_time')
    long startTime
    @JsonProperty(value = 'lobby_type')
    String lobbyType
    @JsonProperty(value = 'radiant_team_id')
    int radiantTeamId
    @JsonProperty(value = 'dire_team_id')
    int direTeamId

    Player[] players
}
