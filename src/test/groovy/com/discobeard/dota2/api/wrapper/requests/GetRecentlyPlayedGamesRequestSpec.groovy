package com.discobeard.dota2.api.wrapper.requests

import com.discobeard.dota2.api.wrapper.BaseSpec
import com.discobeard.dota2.api.wrapper.to.getrecentlyplayedgames.GetRecentlyPlayedGames

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder

class GetRecentlyPlayedGamesRequestSpec extends BaseSpec {
    Client client = ClientBuilder.newClient()
    GetRecentlyPlayedGamesRequest testObj = new GetRecentlyPlayedGamesRequest(client, "http://localhost:1080", "key")

    def 'player summaries are converted correctly'() {
        given:
            returnGetRecentlyPlayedGames()
        when:
            GetRecentlyPlayedGames recentlyPlayedGames = testObj.submit()
        then:
            recentlyPlayedGames.response.total_count == 5
            recentlyPlayedGames.response.games.size() == 5

            recentlyPlayedGames.response.games[0].appid == 105600
            recentlyPlayedGames.response.games[0].name == 'Terraria'
            recentlyPlayedGames.response.games[0].playedIn2Weeks == 2909
            recentlyPlayedGames.response.games[0].playedForever == 8247
            recentlyPlayedGames.response.games[0].imageIconUrl == '858961e95fbf869f136e1770d586e0caefd4cfac'
            recentlyPlayedGames.response.games[0].imageLogoUrl == '783399da7d865b7b5b1560891b1e9463345e8fa9'
    }
}