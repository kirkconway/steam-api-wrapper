package com.discobeard.steam.api.wrapper.request.player

import com.discobeard.steam.api.wrapper.BaseSpec
import com.discobeard.steam.api.wrapper.response.player.getrecentlyplayedgames.GetRecentlyPlayedGames

class GetRecentlyPlayedGamesRequestSpec extends BaseSpec {

    def 'player summaries are converted correctly'() {
        given:
            returnGetRecentlyPlayedGames()
        when:
            GetRecentlyPlayedGames recentlyPlayedGames = steamApiWrapper.player.getRecentlyPlayedGamesRequest().submit()
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

    def 'attaches steam id to request' () {
        when:
            GetRecentlyPlayedGamesRequest request = steamApiWrapper.player.getRecentlyPlayedGamesRequest().withSteamId("1")
        then:
            request.resource.contains("&steamid=1")
    }


}