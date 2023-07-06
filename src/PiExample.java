import java.math.RoundingMode;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.MathContext;

public class PiExample {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.print("Entrez un entier : ");
        int val = read.nextInt();
        double log = (Math.pow(10, val));

        read.close();

        BigDecimal pi = calculatePi(val);
        System.out.println(pi);
        pi = pi.multiply(BigDecimal.valueOf(log));
        pi = pi.remainder(BigDecimal.valueOf(10));

        MathContext mathContext = new MathContext(1, RoundingMode.UP);

        pi = pi.round(mathContext);
        System.out.println(pi);
    }

    public static BigDecimal calculatePi(int precision) {
        MathContext mc = new MathContext(precision + 2); // Additional digits for accuracy

        BigDecimal pi = BigDecimal.ZERO;
        BigDecimal sixteen = new BigDecimal("16");

        for (int k = 0; k <= precision; k++) {
            BigDecimal term1 = BigDecimal.ONE.divide(new BigDecimal("16").pow(k), mc);
            BigDecimal multiply = new BigDecimal("8").multiply(new BigDecimal(k));
            BigDecimal term2 = new BigDecimal("4").divide(multiply.add(new BigDecimal("1")), mc);
            BigDecimal term3 = new BigDecimal("2").divide(multiply.add(new BigDecimal("4")), mc);
            BigDecimal term4 = new BigDecimal("1").divide(multiply.add(new BigDecimal("5")), mc);
            BigDecimal term5 = new BigDecimal("1").divide(multiply.add(new BigDecimal("6")), mc);

            BigDecimal sum = term1.multiply(term2.subtract(term3).subtract(term4).subtract(term5));
            pi = pi.add(sum);
        }

        return pi;
    }
}