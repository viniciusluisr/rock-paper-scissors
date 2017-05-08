package com.rps.game.manager

import com.rps.game.action.MenuAction.{COMPUTER_VS_COMPUTER, COMPUTER_VS_HUMAN, NONE, QUIT}
import com.rps.game.action.{MenuAction, UserInput}
import com.rps.game.player.{ComputerPlayer, HumanPlayer}
import com.rps.game.support.ScalaTestSupport
import com.rps.game.action.UserInput
import com.rps.game.player.{ComputerPlayer, HumanPlayer}
import com.rps.game.support.ScalaTestSupport
import org.junit.runner.RunWith
import org.mockito.Matchers.any
import org.mockito.Mockito
import org.mockito.Mockito.{spy, verifyNoMoreInteractions, when}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GameTest extends ScalaTestSupport {

  val userInput:UserInput = mock[UserInput]
  val roundManager:RoundManager = mock[RoundManager]

  val game:Game = spy(new Game())

  override protected def beforeAll(): Unit = {
    game.setUserInput(userInput)
    game.setRoundManager(roundManager)
  }

  feature("Play Rock Paper Scissors") {

    scenario("Quit the game menu") {

      Given("the Computer Vs Computer option")
      when(userInput.readAction).thenReturn(QUIT)

      When("the game starts")
      game.play()

      Then("the game should finishes")
      verifyNoMoreInteractions(roundManager)
    }

    scenario("Play Computer Vs Computer") {

      Given("the Computer Vs Computer option")
      when(userInput.readAction).thenReturn(COMPUTER_VS_COMPUTER, QUIT)

      When("the game starts")
      game.play()

      Then("the result should be randomized")
      Mockito.verify(roundManager).play(any(classOf[ComputerPlayer]), any(classOf[ComputerPlayer]))

    }

    scenario("Play Computer Vs Human") {

      Given("the Computer Vs Human option")
      when(userInput.readAction).thenReturn(COMPUTER_VS_HUMAN, QUIT)

      When("the game starts")
      game.play()

      Then("the result should be based on inputs")
      Mockito.verify(roundManager, Mockito.times(2)).play(any(classOf[ComputerPlayer]), any(classOf[HumanPlayer]))
    }

    scenario("Invalid input") {

      Given("an invalid input")
      when(userInput.readAction).thenReturn(NONE, QUIT)

      When("the game starts")
      game.play()

      Then("the result should be based on inputs")
      verifyNoMoreInteractions(roundManager)

    }

  }

}