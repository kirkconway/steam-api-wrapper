package com.discobeard.dota2.api.wrapper.deserializers

import com.discobeard.dota2.api.wrapper.domain.SteamId
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer


class SteamIdDeserializer extends  JsonDeserializer<SteamId> {
    @Override
    SteamId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        SteamId.createFrom64Bit(p.getText())
    }
}
