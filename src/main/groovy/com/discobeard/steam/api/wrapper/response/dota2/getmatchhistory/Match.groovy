package com.discobeard.steam.api.wrapper.response.dota2.getmatchhistory

import com.fasterxml.jackson.annotation.JsonProperty

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
