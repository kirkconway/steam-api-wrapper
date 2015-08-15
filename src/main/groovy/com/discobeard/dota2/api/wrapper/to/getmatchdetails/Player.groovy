package com.discobeard.dota2.api.wrapper.to.getmatchdetails

import com.discobeard.dota2.api.wrapper.deserializers.ByteToTeamDeserializer
import com.discobeard.dota2.api.wrapper.deserializers.LeaverStatusDeserializer
import com.discobeard.dota2.api.wrapper.domain.LeaverStatus
import com.discobeard.dota2.api.wrapper.domain.Team
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

class Player {

    @JsonProperty(value = 'account_id')
    long accountId

    @JsonDeserialize(using=ByteToTeamDeserializer.class, as = Team.class)
    @JsonProperty(value = 'player_slot')
    Team team


    @JsonProperty(value = 'hero_id')
    int heroId
    @JsonProperty(value = 'item_0')
    int item0
    @JsonProperty(value = 'item_1')
    int item1
    @JsonProperty(value = 'item_2')
    int item2
    @JsonProperty(value = 'item_3')
    int item3
    @JsonProperty(value = 'item_4')
    int item4
    @JsonProperty(value = 'item_5')
    int item5
    int kills
    int deaths
    int assists

    @JsonProperty(value = 'additional_units')
    AdditionalUnits[] additionalUnits

    @JsonProperty(value = 'leaver_status')
    @JsonDeserialize(using=LeaverStatusDeserializer.class, as = LeaverStatus.class)
    LeaverStatus leaverStatus

    int gold
    @JsonProperty(value = 'last_hits')
    int lastHits
    int denies
    @JsonProperty(value = 'gold_per_min')
    int goldPerMin
    @JsonProperty(value = 'xp_per_min')
    int xpPerMin
    @JsonProperty(value = 'gold_spent')
    int gold_spent
    @JsonProperty(value = 'hero_damage')
    int heroDamage
    @JsonProperty(value = 'tower_damage')
    int towerDamage
    @JsonProperty(value = 'hero_healing')
    int heroHealing
    @JsonProperty(value = 'ability_upgrades')
    Ability[] abilities
    int level
    public static class Ability{
        int ability
        int time
        int level
    }

}
