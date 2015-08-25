package com.discobeard.dota2.api.wrapper.domain

import com.discobeard.dota2.api.wrapper.to.getmatchdetails.AdditionalUnits

class MatchDetailsPlayer {

    long accountId
    Team team
    int heroId
    List<Integer> items
    int kills
    int deaths
    int assists
    AdditionalUnits[] additionalUnits
    LeaverStatus leaverStatus
    int gold
    int lastHits
    int denies
    int goldPerMin
    int xpPerMin
    int goldSpent
    int heroDamage
    int towerDamage
    int heroHealing
    List<Ability> abilities
    int level


    public static class Ability{
        int ability
        int time
        int level
    }
}
