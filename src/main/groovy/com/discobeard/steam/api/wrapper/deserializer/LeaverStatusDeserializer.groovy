package com.discobeard.steam.api.wrapper.deserializer

import com.discobeard.steam.api.wrapper.domain.LeaverStatus
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

class LeaverStatusDeserializer extends JsonDeserializer<LeaverStatus> {
    @Override
    LeaverStatus deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        LeaverStatus.getByValue(p.intValue)
    }
}