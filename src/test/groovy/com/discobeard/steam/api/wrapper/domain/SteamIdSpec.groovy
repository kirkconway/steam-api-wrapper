package com.discobeard.steam.api.wrapper.domain

import spock.lang.Specification

class SteamIdSpec extends Specification {

    def 'create steam id from 32 bit id'() {
        when:
            SteamId steamId = new SteamId("1449859")
        then:
            steamId.accountId32Bit=="1449859"
            steamId.accountId64Bit=="76561197961715587"
    }

    def 'create steam id from 64 bit id'() {
        when:
            SteamId steamId = SteamId.createFrom64Bit("76561197961715587")
        then:
            steamId.accountId32Bit=="1449859"
            steamId.accountId64Bit=="76561197961715587"

    }
}
