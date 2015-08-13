package com.discobeard.dota2.api.wrapper

class DotaApiClientTest extends BaseSpec {


    def 'when the client is created with a specific base url the baseUrl and key are stored successfully'() {
        when:
            DotaApiClient testObj = new DotaApiClient('key', 'www.baseurl.com');
        then:
            testObj.baseUrl == 'www.baseurl.com'
            testObj.key == 'key'
    }

    def 'when only the key is sent the base url is set to the default' (){
        when:
            DotaApiClient testObj = new DotaApiClient('key');
        then:
            testObj.baseUrl == 'https://api.steampowered.com'
            testObj.key == 'key'
    }
}
