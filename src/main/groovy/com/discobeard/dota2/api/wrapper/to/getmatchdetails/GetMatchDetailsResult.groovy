package com.discobeard.dota2.api.wrapper.to.getmatchdetails

import com.fasterxml.jackson.annotation.JsonProperty

class GetMatchDetailsResult {

    @JsonProperty(value = 'match_id')
    int matchId
    @JsonProperty(value = 'match_seq_num')
    int matchSequenceNumber

    Player[] players

    @JsonProperty(value = 'radiant_win')
    boolean radiantWin
    @JsonProperty(value = 'duration')
    long durationInSeconds
    @JsonProperty(value = 'start_time')
    long startTime
    @JsonProperty(value = 'tower_status_radiant')
    int radiantTowerStatus
    @JsonProperty(value = 'tower_status_dire')
    int direTowerStatus
    @JsonProperty(value = 'barracks_status_radiant')
    int radiantBarracksStatus
    @JsonProperty(value = 'barracks_status_dire')
    int direBarracksStatus
    String cluster
    @JsonProperty(value = 'first_blood_time')
    int firstBloodTimeInSeconds
    @JsonProperty(value = 'lobby_type')
    int lobbyType
    @JsonProperty(value = 'human_players')
    int humanPlayers
    int leagueid
    @JsonProperty(value = 'positive_votes')
    int positiveVotes
    @JsonProperty(value = 'negative_votes')
    int negativeVotes
    @JsonProperty(value = 'game_mode')
    int gameMode
    int engine





}
