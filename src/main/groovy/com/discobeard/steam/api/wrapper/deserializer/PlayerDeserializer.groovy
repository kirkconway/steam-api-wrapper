package com.discobeard.steam.api.wrapper.deserializer

import com.discobeard.steam.api.wrapper.domain.LeaverStatus
import com.discobeard.steam.api.wrapper.domain.MatchDetailsPlayer
import com.discobeard.steam.api.wrapper.domain.Team
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode

class PlayerDeserializer extends  JsonDeserializer<List<MatchDetailsPlayer>> {
    @Override
    List<MatchDetailsPlayer> deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = jsonParser.getCodec()
        JsonNode jsonNode = objectCodec.readTree(jsonParser)

        List<MatchDetailsPlayer> players = new ArrayList<>()

        if (jsonNode.isArray()) {

            players = jsonNode.collect {

                MatchDetailsPlayer marketDetailsPlayer = new MatchDetailsPlayer()

                marketDetailsPlayer.accountId = it.get('account_id').asLong()
                marketDetailsPlayer.abilities = getAbility(it.get('ability_upgrades'))
                marketDetailsPlayer.items = getItems(it)
                marketDetailsPlayer.level = it.get('level').asInt()
                marketDetailsPlayer.assists = it.get('assists').asInt()
                marketDetailsPlayer.deaths = it.get('deaths').asInt()
                marketDetailsPlayer.kills = it.get('kills').asInt()
                marketDetailsPlayer.team = getTeam(it.get('player_slot').asInt())
                marketDetailsPlayer.heroId = it.get('hero_id').asInt()
                marketDetailsPlayer.leaverStatus = getLeaverStatus(it.get('leaver_status').asInt())
                marketDetailsPlayer.gold = it.get('gold').asInt()
                marketDetailsPlayer.lastHits = it.get('last_hits').asInt()
                marketDetailsPlayer.denies = it.get('denies').asInt()
                marketDetailsPlayer.goldPerMin = it.get('gold_per_min').asInt()
                marketDetailsPlayer.xpPerMin = it.get('xp_per_min').asInt()
                marketDetailsPlayer.goldSpent = it.get('gold_spent').asInt()
                marketDetailsPlayer.heroDamage = it.get('hero_damage').asInt()
                marketDetailsPlayer.towerDamage = it.get('tower_damage').asInt()
                marketDetailsPlayer.heroHealing = it.get('hero_healing').asInt()

                marketDetailsPlayer
            }
        }

        players
    }

    private List<Integer> getItems(JsonNode jsonNode){
        List<Integer> items = new ArrayList<>()
        for(int i=0;i<6;i++) {
            items.add(jsonNode.get("item_${i}")?.asInt())
        }

        items
    }

    private List<MatchDetailsPlayer.Ability> getAbility(JsonNode jsonNode){
        List<MatchDetailsPlayer.Ability> abilities = new ArrayList<>()

        if(jsonNode.isArray()){
            abilities = jsonNode.collect{
                MatchDetailsPlayer.Ability ability =  new MatchDetailsPlayer.Ability()
                ability.ability = it.get('ability').asInt()
                ability.level = it.get('level').asInt()
                ability.time = it.get('time').asInt()
                ability
            }
        }

        abilities
    }

    private Team getTeam(int team){
        if(team>=128){
            return Team.Dire
        }
        Team.Radiant
    }

    private LeaverStatus getLeaverStatus(int leaverStatus){
        LeaverStatus.getByValue(leaverStatus)
    }
}
