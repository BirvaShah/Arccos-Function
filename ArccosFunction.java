import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArccosFunction {
  /**
  * Main function is the starting point of the program.
  * The implemented function Arccos(x) is called in this main function via object.
  * Some additional functions are also called to support the implemented function.
  */
  public static void main(String[] args) {
    ArccosFunction arccosObj = new ArccosFunction();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a value to calculate Arccos(x)...");
    try {  
      double input = sc.nextDouble();
      boolean check = arccosObj.checkDomain(input);
      double ansInRad;
      if (check) {
        ansInRad = arccosObj.calculateArccos(input);
        System.out.println("Calculated value of Arccos(x) in radians...");
        ansInRad =  BigDecimal.valueOf(ansInRad).setScale(4, RoundingMode.HALF_UP).doubleValue();
        System.out.println(ansInRad);
        double ansInDeg = arccosObj.convertToDegree(ansInRad);
        System.out.println("Calculated value of Arccos(x) in degrees...");
        ansInDeg = BigDecimal.valueOf(ansInDeg).setScale(4, RoundingMode.HALF_UP).doubleValue();
        System.out.println(ansInDeg);
      } else {
        System.out.println("Invalid input...");
      }
    } catch (InputMismatchException e) { 
      System.out.println("Invalid input...");
    }
  }
  /**
  * Calculates whether the user input is within the required domain or not.
  * @param input Value entered by the user 
  * @return boolean value
  */

  public boolean checkDomain(double input) {
    // TODO Auto-generated method stub
    if (input <= 1.0000 && input >= -1.0000) {
      return true;
    } else {
      return false;
    }
  }

  /**
  * Converts the radian value into degree value with the help of mathematical calculations.
  * @param ansInRad Value in radians
  * @return value  in degrees
  */
  public double convertToDegree(double ansInRad) {
    double ansInDeg = ansInRad * (180 / pi());
    return ansInDeg;
  }
  
  /**
  * Calculates value of PI with the help of the formula developed 
  * by German mathematician Gottfried Leibniz to get the approximate value of PI.
  * @return value of PI
  */
  public double pi() {
    double value = 4;
    boolean flag = false;
    for (int i = 3; i < 999999; i += 2) {
      if (flag) {
        value += 4.0 / i;
      } else {
        value -= 4.0 / i;
      }
      flag = !flag;
    }
    return value;
  }

  /**
  * Calculates b^pow, the power function where b is base and pow is power.
  * @param b Base value
  * @param pow Power value
  * @return value of b^pow
  */

  public double calculatePower(double b, int pow) {
    double base = 1.0000;
    if (pow == 0) {
      base = 1;
    } else {
      for (int i = 1; i <= pow; i++) {
        base = b * base;
      }
    }
    return base;
  }

  /**
  * Calculates the factorial of the given number using basic mathematical operations.
  * @param fact Value to calculate factorial
  * @return value of factorial of a number
  */

  public double calculateFactorial(int fact) {
    double val = 1.0;
    if (fact == 0) {
      val = 1;
    } else {
      for (int i = 1; i <= fact; i++) {
        val = val * i;
      }
    }
    return val;
  }

  /**
  * Calculates the Arccos(input) function with the help basic mathematical 
  * operations and formula based on Taylor's series.
  * @param input User input to calculate Arccos
  * @return calculated value of Arccos(input) in radians
  */

  public double calculateArccos(double input) {
    double ans = 0;
    int i = 0;
    if (input == 1.00000) {
      return 0;
    } else if (input == -1.00000) {
      return pi();
    } else if (input <= 1.0000 && input >= -1.0000) {
      while (i < 99) {
        double fact1 = calculateFactorial(2 * i);
        double pow1 = calculatePower(2, (2 * i));
        double pow2 = calculatePower(calculateFactorial(i), 2);
        int exp = (2 * i) + 1;
        try {
          double b = calculatePower(input, exp) / exp;
          if (Double.isInfinite(fact1)) {
            break;
          }
          ans = ans + ((fact1 / (pow1 * pow2)) * b);
          i++;
        } catch (ArithmeticException ae) {
          System.out.println("Cannot divide by zero !");
        }

      }
      double arccosValue = 9999;
      if (((pi() / 2) - ans) >= 0 || ((pi() / 2) - ans) <= pi()) {
        arccosValue = ((pi() / 2) - ans);
      }
      return arccosValue;
    } else {
      return 9999;
    }
  }
}
