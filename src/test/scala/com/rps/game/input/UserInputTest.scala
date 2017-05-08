package com.rps.game.input

import java.io.ByteArrayInputStream
import java.util.Scanner

import com.rps.game.action.{GameOption, MenuAction, UserInput}
import com.rps.game.support.ScalaTestSupport
import com.rps.game.action.{GameOption, MenuAction, UserInput}
import com.rps.game.support.ScalaTestSupport
import org.fest.assertions.Assertions.assertThat
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class UserInputTest extends ScalaTestSupport {

  val userInput:UserInput = new UserInput()

  feature("User possible inputs for the main menu") {

    scenario("Option one") {

      Given("the menu option one")
      userInput.setScanner(new Scanner(new ByteArrayInputStream("1".getBytes)))

      Then("should return Computer Vs Human option")
      assertThat(userInput.readAction).isEqualTo(MenuAction.COMPUTER_VS_HUMAN)
    }

    scenario("Option two") {

      Given("the menu option two")
      userInput.setScanner(new Scanner(new ByteArrayInputStream("2".getBytes)))

      Then("should return Computer Vs Computer option")
      assertThat(userInput.readAction).isEqualTo(MenuAction.COMPUTER_VS_COMPUTER)
    }

    scenario("Option Q") {

      Given("the menu option Q")
      userInput.setScanner(new Scanner(new ByteArrayInputStream("Q".getBytes)))

      Then("should quit the game")
      assertThat(userInput.readAction).isEqualTo(MenuAction.QUIT)
    }

    scenario("Invalid option") {

      Given("an invalid option")
      userInput.setScanner(new Scanner(new ByteArrayInputStream("NONE".getBytes)))

      Then("the result should be NONE")
      assertThat(userInput.readAction).isEqualTo(MenuAction.NONE)
    }

  }

  feature("User possible inputs for the game action menu") {

    scenario("Option R") {

      Given("the option R")
      userInput.setScanner(new Scanner(new ByteArrayInputStream("R".getBytes)))

      Then("should return Rock")
      assertThat(userInput.readGameOption()).isEqualTo(GameOption.ROCK)
    }

    scenario("Option P") {

      Given("the option P")
      userInput.setScanner(new Scanner(new ByteArrayInputStream("P".getBytes)))

      Then("should return Paper")
      assertThat(userInput.readGameOption()).isEqualTo(GameOption.PAPER)
    }

    scenario("Option S") {

      Given("the option S")
      userInput.setScanner(new Scanner(new ByteArrayInputStream("S".getBytes)))

      Then("should return Scissors")
      assertThat(userInput.readGameOption()).isEqualTo(GameOption.SCISSORS)
    }

    scenario("Invalid option") {

      Given("an invalid option")
      userInput.setScanner(new Scanner(new ByteArrayInputStream("".getBytes)))

      Then("should throw an exception")
      intercept[NoSuchElementException] {
        userInput.readAction()
      }
    }


  }

}