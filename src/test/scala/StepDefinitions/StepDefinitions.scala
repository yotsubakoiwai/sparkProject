package StepDefinitions

import classes.SimpleCalculator
import cucumber.api.scala.{EN, ScalaDsl}

class StepDefinitions ScalaDsl with EN {
  var calc: SimpleCalculator = _
  var result: Int = _
  Given("""^my calculator is running$"""){ () =>
  calc = new MyCalculator
}
  When("""^I add (\d+) and (\d+)$"""){ (firstNum:Int, secondNum:Int) =>
  result = calc.add(firstNum, secondNum)
}
  Then("""^result should be equal to (\d+)$"""){ (expectedResult:Int) =>
  assert(result == expectedResult, "Incorrect result of calculator computation")
}
  When("""^I subtract (\d+) and (\d+)$"""){ (firstNum:Int, secondNum:Int) =>
  result = calc.sub(firstNum, secondNum)
}
}
