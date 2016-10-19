package com.discobeard.steam.api.wrapper.deserializer

import com.discobeard.steam.api.wrapper.domain.LobbyType
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

class LobbyTypeDeserializer extends  JsonDeserializer<LobbyType> {
    @Override
    LobbyType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        LobbyType.getLobbyType(p.intValue)
    }
}
