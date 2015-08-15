package com.discobeard.dota2.api.wrapper.deserializers

import com.discobeard.dota2.api.wrapper.domain.Team
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer


class BooleanToTeamDeserializer extends  JsonDeserializer<Team> {
    @Override
    Team deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if(p.booleanValue){
            return Team.Radiant
        }

        Team.Dire
    }
}
