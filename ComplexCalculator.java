/**
 * Создать проект калькулятора комплексных чисел (достаточно сделать сложение, умножение и деление).
Применить при создании программы архитектурные паттерны, добавить логирование калькулятора.
Соблюдать принципы SOLID, паттерны проектирования.
 */


public class ComplexCalculator {

    public static class ComplexNumber {
        private double real;
        private double imaginary;

        public ComplexNumber(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public double getReal() {
            return real;
        }

        public double getImaginary() {
            return imaginary;
        }

        @Override
        public String toString() {
            return real + " + " + imaginary + "i";
        }
    }

    public static ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        double realResult = num1.getReal() + num2.getReal();
        double imaginaryResult = num1.getImaginary() + num2.getImaginary();
        return new ComplexNumber(realResult, imaginaryResult);
    }

    public static ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        double realResult = num1.getReal() * num2.getReal() - num1.getImaginary() * num2.getImaginary();
        double imaginaryResult = num1.getReal() * num2.getImaginary() + num1.getImaginary() * num2.getReal();
        return new ComplexNumber(realResult, imaginaryResult);
    }

    public static ComplexNumber divide(ComplexNumber num1, ComplexNumber num2) {
        double denominator = num2.getReal() * num2.getReal() + num2.getImaginary() * num2.getImaginary();
        double realResult = (num1.getReal() * num2.getReal() + num1.getImaginary() * num2.getImaginary()) / denominator;
        double imaginaryResult = (num1.getImaginary() * num2.getReal() - num1.getReal() * num2.getImaginary()) / denominator;
        return new ComplexNumber(realResult, imaginaryResult);
    }

    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber(2, 3);
        ComplexNumber num2 = new ComplexNumber(1, 2);

        ComplexNumber sum = add(num1, num2);
        ComplexNumber product = multiply(num1, num2);
        ComplexNumber quotient = divide(num1, num2);

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
    }
}
