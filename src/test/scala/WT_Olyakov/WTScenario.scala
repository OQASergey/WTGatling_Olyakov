package WT_Olyakov

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object WTScenario{
  val userFeeder = csv("users.csv").circular

  def apply(): ScenarioBuilder = scenario("Main Scenario")
    .exec(WTActions.getMainPage)
    .exec(WTActions.login)
    .exec(WTActions.getPageFlights)
    .exec(WTActions.getFlightForm)
    .exec(WTActions.chooseCities)
    .exec(WTActions.findFlights)
    .exec(WTActions.flightsDetails)
    .exec(WTActions.paymentDetails)
    .exec(WTActions.getMainPage)
}

