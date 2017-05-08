package com.rps.game.support

import org.scalatest._
import org.scalatest.mockito.MockitoSugar

abstract class  ScalaTestSupport extends FeatureSpec with GivenWhenThen with Matchers with OptionValues with Inside with Inspectors with BeforeAndAfterAll with MockitoSugar {

}