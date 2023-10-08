# PlayersAppApis
How to run 

mkdir player_app_apis
cd player_app_apis
git clone https://github.com/masadzahid/PlayersAppApis.git
./mvnw spring-boot:run

or make a jar and execute cmd> java --jar playerappapis_SNAPSHOT_0.0.1.jar

open the browser
and 
http://localhost:8080/swagger-ui/index.html
<img width="564" alt="OpenAPI" src="https://github.com/masadzahid/PlayersAppApis/assets/147319187/01b979d5-f0e7-43e2-9360-ac7677c14f54">

or import this into PostMan

[Uploa{"swagger":"2.0","info":{"description":"API Endpoint Decoration","version":"1.0.0","title":"Player App Services","contact":{"name":"Contact","url":"https://localhost/","email":"test@test.com"},"license":{"name":"Apache 2.0","url":"http://www.apache.org/licenses/LICENSE-2.0.html"}},"host":"localhost:8080","basePath":"/","tags":[{"name":"player-controller","description":"Player Controller"},{"name":"sport-controller","description":"Sport Controller"}],"paths":{"/api/v1/players":{"get":{"tags":["player-controller"],"summary":"getAllPlayers","operationId":"getAllPlayersUsingGET","produces":["*/*"],"responses":{"200":{"description":"OK","schema":{"type":"array","items":{"$ref":"#/definitions/Player"}}},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}},"post":{"tags":["player-controller"],"summary":"createPlayer","operationId":"createPlayerUsingPOST","consumes":["application/json"],"produces":["*/*"],"parameters":[{"in":"body","name":"player","description":"player","required":true,"schema":{"$ref":"#/definitions/Player"}}],"responses":{"200":{"description":"OK","schema":{"$ref":"#/definitions/Player"}},"201":{"description":"Created"},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}}},"/api/v1/players/findPlayers":{"get":{"tags":["player-controller"],"summary":"findPlayers","operationId":"findPlayersUsingGET","produces":["*/*"],"parameters":[{"name":"age","in":"query","description":"age","required":true,"type":"integer","format":"int32"},{"name":"gender","in":"query","description":"gender","required":true,"type":"string"},{"name":"level","in":"query","description":"level","required":true,"type":"integer","format":"int32"}],"responses":{"200":{"description":"OK","schema":{"type":"array","items":{"$ref":"#/definitions/Player"}}},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}}},"/api/v1/players/findPlayersWithNoSports":{"get":{"tags":["player-controller"],"summary":"findPlayersWithNoSports","operationId":"findPlayersWithNoSportsUsingGET","produces":["*/*"],"responses":{"200":{"description":"OK","schema":{"type":"array","items":{"type":"array","items":{"type":"object"}}}},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}}},"/api/v1/players/{id}":{"get":{"tags":["player-controller"],"summary":"findById","operationId":"findByIdUsingGET","produces":["*/*"],"parameters":[{"name":"id","in":"path","description":"id","required":true,"type":"integer","format":"int64"}],"responses":{"200":{"description":"OK","schema":{"$ref":"#/definitions/Error-ModelName{namespace='java.util', name='Optional«Player»'}"}},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}},"delete":{"tags":["player-controller"],"summary":"delete","operationId":"deleteUsingDELETE","produces":["*/*"],"parameters":[{"name":"id","in":"path","description":"id","required":true,"type":"integer","format":"int64"}],"responses":{"200":{"description":"OK"},"204":{"description":"No Content"},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"}}}},"/api/v1/playersList":{"get":{"tags":["player-controller"],"summary":"getAllPlayersPagination","operationId":"getAllPlayersPaginationUsingGET","produces":["*/*"],"parameters":[{"name":"pageNo","in":"query","description":"pageNo","required":true,"type":"integer","format":"int32"},{"name":"pageSize","in":"query","description":"pageSize","required":true,"type":"integer","format":"int32"}],"responses":{"200":{"description":"OK","schema":{"type":"array","items":{"$ref":"#/definitions/Player"}}},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}}},"/api/v1/sports":{"get":{"tags":["sport-controller"],"summary":"getAllPlayers","operationId":"getAllPlayersUsingGET_1","produces":["*/*"],"responses":{"200":{"description":"OK","schema":{"type":"array","items":{"$ref":"#/definitions/Sport"}}},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}},"post":{"tags":["sport-controller"],"summary":"savesportsData","operationId":"savesportsDataUsingPOST","consumes":["application/json"],"produces":["*/*"],"parameters":[{"in":"body","name":"playerRequest","description":"playerRequest","required":true,"schema":{"$ref":"#/definitions/PlayerRequest"}}],"responses":{"200":{"description":"OK","schema":{"$ref":"#/definitions/Sport"}},"201":{"description":"Created"},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}}},"/api/v1/sports/findByName":{"get":{"tags":["sport-controller"],"summary":"findByName","operationId":"findByNameUsingGET","produces":["*/*"],"parameters":[{"name":"name","in":"query","description":"name","required":true,"type":"string"}],"responses":{"200":{"description":"OK","schema":{"type":"array","items":{"$ref":"#/definitions/Sport"}}},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}}},"/api/v1/sports/findSportsRegisterdWithMultpilePlayers":{"get":{"tags":["sport-controller"],"summary":"findSportRegisterdWithMultpilePlayers","operationId":"findSportRegisterdWithMultpilePlayersUsingGET","produces":["*/*"],"responses":{"200":{"description":"OK","schema":{"type":"array","items":{"type":"array","items":{"type":"object"}}}},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}}},"/api/v1/sports/{id}":{"get":{"tags":["sport-controller"],"summary":"findById","operationId":"findByIdUsingGET_1","produces":["*/*"],"parameters":[{"name":"id","in":"path","description":"id","required":true,"type":"integer","format":"int64"}],"responses":{"200":{"description":"OK","schema":{"$ref":"#/definitions/Error-ModelName{namespace='java.util', name='Optional«Sport»'}"}},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}},"put":{"tags":["sport-controller"],"summary":"updatesportsData","operationId":"updatesportsDataUsingPUT","consumes":["application/json"],"produces":["*/*"],"parameters":[{"name":"id","in":"path","description":"id","required":true,"type":"integer","format":"int64"},{"in":"body","name":"playerRequest","description":"playerRequest","required":true,"schema":{"$ref":"#/definitions/PlayerRequest"}}],"responses":{"200":{"description":"OK","schema":{"$ref":"#/definitions/Sport"}},"201":{"description":"Created"},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}},"delete":{"tags":["sport-controller"],"summary":"delete","operationId":"deleteUsingDELETE_1","produces":["*/*"],"parameters":[{"name":"id","in":"path","description":"id","required":true,"type":"integer","format":"int64"}],"responses":{"200":{"description":"OK"},"204":{"description":"No Content"},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"}}}}},"definitions":{"Player":{"type":"object","properties":{"age":{"type":"integer","format":"int32"},"email":{"type":"string"},"gender":{"type":"string","pattern":"male|female"},"level":{"type":"integer","format":"int32","minimum":0,"maximum":9223372036854775807,"exclusiveMinimum":false,"exclusiveMaximum":false},"playerId":{"type":"integer","format":"int64"}},"title":"Player"},"PlayerRequest":{"type":"object","properties":{"name":{"type":"string"},"playerId":{"type":"integer","format":"int64"}},"title":"PlayerRequest"},"Sport":{"type":"object","properties":{"name":{"type":"string"},"sportId":{"type":"integer","format":"int64"}},"title":"Sport"}}}ding OpenApi.json…]()

