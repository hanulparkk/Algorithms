public class Main {
    /*
    두 개의 자연수에 대한 최대공약수를 구하는 대표적인 알고리즘으로 유클리드 호제법이 있습니다.

    유클리드 호제법
    1.두 자연수 A, B에 대하여 (A > B)일 때, A를 B로 나눈 나머지를 R이라고 합시다.
    2.이때 A와 B의 최대공약수는 B와 R의 최대공약수와 같습니다.

    예시: GCD(192,162)
    *GCD(Greatest Common Divisor)

    1.A가 B로 나누어 떨어지 때까지 반복합니다.
    2.A가 B로 나누어 떨어지면 B가 A, B에 대한 최대공약수가 됩니다.

    Step1 : A = 192, B = 162
    Step2 : A = 162, B = 30
    Step3 : A = 30, B = 12
    Step4 : A = 12, B = 6
    최대공약수 : 6
    */
    public static int gcdIterative(int a, int b) {
        int temp;

        while (a % b != 0) {
            temp = a;
            a = b;
            b = temp % b;
        }

        return b;
    }

    public static int gcdRecursive(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return gcdRecursive(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("반복적으로 구현:" + gcdIterative(192, 162));
        System.out.println("재귀적으로 구현:" + gcdRecursive(192, 162));
    }
}