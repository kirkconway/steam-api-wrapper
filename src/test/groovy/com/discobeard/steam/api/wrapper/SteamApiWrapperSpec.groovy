package com.discobeard.steam.api.wrapper

class SteamApiWrapperSpec extends BaseSpec {

    def 'when the client is created with a specific base url the baseUrl and key are stored successfully'() {
        when:
            SteamApiWrapper testObj = new SteamApiWrapper('key', 'www.baseurl.com');
        then:
            testObj.dota2.baseUrl == 'www.baseurl.com'
            testObj.dota2.key == 'key'
            testObj.api.baseUrl == 'www.baseurl.com'
            testObj.api.key == 'key'
            testObj.player.baseUrl == 'www.baseurl.com'
            testObj.player.key == 'key'
    }

    def 'when only the key is sent the base url is set to the default'() {
        when:
            SteamApiWrapper testObj = new SteamApiWrapper('key');
        then:
            testObj.dota2.baseUrl == 'https://api.steampowered.com'
            testObj.dota2.key == 'key'
            testObj.api.baseUrl == 'https://api.steampowered.com'
            testObj.api.key == 'key'
            testObj.player.baseUrl == 'https://api.steampowered.com'
            testObj.player.key == 'key'
    }
}
