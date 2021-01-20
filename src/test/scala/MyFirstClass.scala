import io.gatling.core.Predef._
import io.gatling.http.Predef._


class MyFirstClass extends Simulation {

  // 1 http Conf
  //val httpConf= http.baseUrl("http://localhost:8080/app/")
  val httpConf = http.baseUrl("http://localhost:8080/swagger-ui/index.html#/Video_Games")
    .header("Accept", "application/json")
    //.proxy(Proxy("localhost", 8888))
  // 2 Scenario Definition
  val scn = scenario("My First Test")
    .exec(http("Get All Games")
    .get("videogames"))
  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}
