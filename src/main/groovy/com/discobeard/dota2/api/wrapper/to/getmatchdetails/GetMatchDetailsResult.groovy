package com.discobeard.dota2.api.wrapper.to.getmatchdetails

import com.discobeard.dota2.api.wrapper.deserializers.BooleanToTeamDeserializer
import com.discobeard.dota2.api.wrapper.deserializers.LobbyTypeDeserializer
import com.discobeard.dota2.api.wrapper.deserializers.PlayerDeserializer
import com.discobeard.dota2.api.wrapper.domain.LobbyType
import com.discobeard.dota2.api.wrapper.domain.MatchDetailsPlayer
import com.discobeard.dota2.api.wrapper.domain.Team
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonIgnoreProperties(ignoreUnknown = true)
class GetMatchDetailsResult {

    @JsonProperty(value = 'match_id')
    int matchId
    @JsonProperty(value = 'match_seq_num')
    int matchSequenceNumber

    @JsonDeserialize(using=PlayerDeserializer.class, as = List.class)
    List<MatchDetailsPlayer> players

    @JsonProperty(value = 'radiant_win')
    @JsonDeserialize(using=BooleanToTeamDeserializer.class, as = Team.class)
    Team winner

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
    int cluster
    @JsonProperty(value = 'first_blood_time')
    int firstBloodTimeInSeconds
    @JsonProperty(value = 'lobby_type')
    @JsonDeserialize(using=LobbyTypeDeserializer.class, as = LobbyType.class)
    LobbyType lobbyType
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

    @JsonProperty(value = 'dire_team_id')
    int direTeamId
    @JsonProperty(value = 'dire_name')
    String direTeamName
    @JsonProperty(value = 'dire_logo')
    String direLogo
    @JsonProperty(value = 'dire_team_complete')
    String direTeamComplete
    @JsonProperty(value = 'dire_captain')
    int direCaptain
    @JsonProperty(value = 'radiant_captain')
    int radiantCaptain
    @JsonProperty(value = 'picks_bans')
    PicksAndBans[] picksAndBans

}
