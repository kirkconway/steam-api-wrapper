package com.discobeard.dota2.api.wrapper.to.getmatchdetails

import com.fasterxml.jackson.annotation.JsonProperty

class Player {

    @JsonProperty(value = 'account_id')
    long accountId
    @JsonProperty(value = 'player_slot')
    long playerSlot
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
    @JsonProperty(value = 'leaver_status')
    int leaverStatus
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
