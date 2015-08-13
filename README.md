# dota2-api-wrapper
Groovy wrapper for the dota 2 api


# Usage
Dota2ApiClient client = new Dota2ApiClient('key');
client.getMatchHistoryRequest().withAccountId("12131212").submit()

# Supported API

getMatchHistory
getMatchDetails
getHeroes


