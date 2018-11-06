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

class PlayerDeserializer extends JsonDeserializer<List<MatchDetailsPlayer>> {
    @Override
    List<MatchDetailsPlayer> deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = jsonParser.getCodec()
        JsonNode jsonNode = objectCodec.readTree(jsonParser)

        List<MatchDetailsPlayer> players = new ArrayList<>()

        if (jsonNode.isArray()) {

            players = jsonNode.collect { JsonNode node ->

                MatchDetailsPlayer marketDetailsPlayer = new MatchDetailsPlayer()

                marketDetailsPlayer.accountId = node.get('account_id').asLong()
                marketDetailsPlayer.abilities = getAbility(node.get('ability_upgrades'))
                marketDetailsPlayer.items = getItems(node)
                marketDetailsPlayer.level = safelyGetInteger(node, "level")
                marketDetailsPlayer.assists = safelyGetInteger(node, "assists")
                marketDetailsPlayer.deaths = safelyGetInteger(node, 'deaths')
                marketDetailsPlayer.kills = safelyGetInteger(node, 'kills')
                marketDetailsPlayer.team = getTeam(node.get('player_slot').asInt())
                marketDetailsPlayer.heroId = safelyGetInteger(node, 'hero_id')
                marketDetailsPlayer.leaverStatus = getLeaverStatus(safelyGetInteger(node, 'leaver_status'))
                marketDetailsPlayer.gold = safelyGetInteger(node, 'gold')
                marketDetailsPlayer.lastHits = safelyGetInteger(node, 'last_hits')
                marketDetailsPlayer.denies =safelyGetInteger(node, 'denies')
                marketDetailsPlayer.goldPerMin = safelyGetInteger(node, 'gold_per_min')
                marketDetailsPlayer.xpPerMin = safelyGetInteger(node, 'xp_per_min')
                marketDetailsPlayer.goldSpent = safelyGetInteger(node, 'gold_spent')
                marketDetailsPlayer.heroDamage = safelyGetInteger(node, 'hero_damage')
                marketDetailsPlayer.towerDamage = safelyGetInteger(node, 'tower_damage')
                marketDetailsPlayer.heroHealing = safelyGetInteger(node, 'hero_healing')

                marketDetailsPlayer
            }
        }

        players
    }

    private Integer safelyGetInteger(JsonNode node, String fieldName){
        node.get(fieldName) == null ? 0 : node.get(fieldName).asInt()

    }

    private List<Integer> getItems(JsonNode jsonNode) {
        List<Integer> items = new ArrayList<>()
        for (int i = 0; i < 6; i++) {
            items.add(jsonNode.get("item_${i}")?.asInt())
        }

        items
    }

    private List<MatchDetailsPlayer.Ability> getAbility(JsonNode jsonNode) {
        List<MatchDetailsPlayer.Ability> abilities = new ArrayList<>()

        if (jsonNode?.isArray()) {
            abilities = jsonNode.collect {
                MatchDetailsPlayer.Ability ability = new MatchDetailsPlayer.Ability()
                ability.ability = it.get('ability').asInt()
                ability.level = it.get('level').asInt()
                ability.time = it.get('time').asInt()
                ability
            }
        }

        abilities
    }

    private Team getTeam(int team) {
        if (team >= 128) {
            return Team.Dire
        }
        Team.Radiant
    }

    private LeaverStatus getLeaverStatus(int leaverStatus) {
        LeaverStatus.getByValue(leaverStatus)
    }
}
