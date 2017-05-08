package com.rps.game.manager

import com.rps.game.action.GameOption
import com.rps.game.player.Player
import com.rps.game.action.GameOption
import com.rps.game.player.Player
import com.rps.game.support.ScalaTestSupport
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.{spy, verifyNoMoreInteractions, when}
import org.scalatest.junit.JUnitRunner
import org.fest.assertions.Assertions.assertThat

/**
  * Created by vinicius on 2017-05-07.
  */
@RunWith(classOf[JUnitRunner])
class RoundManagerTest extends ScalaTestSupport {

  val roundManager: RoundManager = spy(new RoundManager())
  val player1:Player = mock[Player]
  val player2:Player = mock[Player]

  override protected def beforeAll(): Unit = {
    Mockito.when(player1.`type`()).thenReturn("Computer")
    Mockito.when(player2.`type`()).thenReturn("Computer")
  }

  feature("Game round") {

    scenario("The player one should win") {

      Given("scissors and Paper game options")
      when(player1.getGameOption).thenReturn(GameOption.SCISSORS)
      when(player2.getGameOption).thenReturn(GameOption.PAPER)

      When("the round starts")
      val winner:Player = roundManager.play(player1, player2)

      Then("the winner should be the player one")
      assertThat(winner).isEqualTo(player1)
    }

    scenario("The player two should win") {

      Given("paper and Scissors game options")
      when(player1.getGameOption).thenReturn(GameOption.PAPER)
      when(player2.getGameOption).thenReturn(GameOption.SCISSORS)

      When("the round starts")
      val winner:Player = roundManager.play(player1, player2)

      Then("the winner should be the player two")
      assertThat(winner).isEqualTo(player2)
    }

  }

}
