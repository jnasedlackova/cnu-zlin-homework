package dk.cngroup.university;

public class Main {

    public static void main(String[] args) {

        String input = "1,0\n" +
                "\n" +
                "N\n" +
                "\n" +
                "5\n" +
                "\n" +
                "3,0;1,3;4,3;1,5\n" +
                "\n" +
                "4,1\n" +
                "\n" +
                "RRFLFRFF";

        boolean result = Solver.solve(input);
        System.out.println(result);




    }
}
