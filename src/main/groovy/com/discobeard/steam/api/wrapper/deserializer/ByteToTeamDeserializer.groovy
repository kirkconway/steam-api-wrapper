package com.discobeard.steam.api.wrapper.deserializer

import com.discobeard.steam.api.wrapper.domain.Team
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

class ByteToTeamDeserializer extends  JsonDeserializer<Team> {
    @Override
    Team deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if(p.intValue>=128){
            return Team.Dire
        }
        Team.Radiant
    }
}
