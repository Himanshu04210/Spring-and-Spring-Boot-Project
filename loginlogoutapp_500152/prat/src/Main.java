// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    int num ;

    class InnerClass{
        Integer num = 105;
    }
    public Main() {

    }
    public Main(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        System.out.println(new Main().new InnerClass().num);
    }
}