package com.discobeard.steam.api.wrapper.deserializer

import com.discobeard.steam.api.wrapper.domain.Team
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext

import spock.lang.Specification
import spock.lang.Unroll

class BooleanToTeamDeserializerSpec extends Specification {

    JsonParser jsonParser = Mock(JsonParser)
    DeserializationContext deserializationContext = Mock(DeserializationContext)


    @Unroll
    def "boolean to team"() {
        given:
            jsonParser.booleanValue >> input
        when:
            Team result = new BooleanToTeamDeserializer().deserialize(jsonParser, deserializationContext)
        then:
            result == team
        where:
            input | team
            true  | Team.Radiant
            false | Team.Dire


    }
}
