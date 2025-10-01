public abstract class Factorial {
    public abstract long calculate(int n);
}

class IterativeFactorial extends Factorial {
    @Override
    public long calculate(int n) {
        long total = 1;
        for (long i = n; i >= 1; i--) {
            total *= i;
        }
        return total;
    }
}

class RecursiveFactorial extends Factorial {
    @Override
    public long calculate(int n) {
        if (n == 1) {
            return 1;
        }
        return n * calculate(n - 1);
    }
}