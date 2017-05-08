package com.rps.game.manager

import com.rps.game.action.GameOption._
import com.rps.game.support.ScalaTestSupport
import org.fest.assertions.Assertions.assertThat
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class JudgeTest extends ScalaTestSupport {

  val judge:Judge = new Judge

  feature("Compare game possible results") {

    scenario("Rock equals Rock") {
      assertThat(judge.compare(ROCK, ROCK)).isEqualTo(0)
    }

    scenario("Rock loses with Paper") {
      assertThat(judge.compare(ROCK, PAPER)).isEqualTo(-1)
    }

    scenario("Rock beats Scissors") {
      assertThat(judge.compare(ROCK, SCISSORS)).isEqualTo(1)
    }

    scenario("Scissors equals Scissors") {
      assertThat(judge.compare(SCISSORS, SCISSORS)).isEqualTo(0)
    }

    scenario("Paper loses with Scissors") {
      assertThat(judge.compare(PAPER, SCISSORS)).isEqualTo(-1)
    }

    scenario("Paper equals Paper") {
      assertThat(judge.compare(PAPER, PAPER)).isEqualTo(0)
    }

    scenario("Paper beats Rock") {
      assertThat(judge.compare(PAPER, ROCK)).isEqualTo(1)
    }

    scenario("Scissors loses with Rock") {
      assertThat(judge.compare(SCISSORS, ROCK)).isEqualTo(-1)
    }

    scenario("Scissors beats Paper") {
      assertThat(judge.compare(SCISSORS, PAPER)).isEqualTo(1)
    }

  }

}
