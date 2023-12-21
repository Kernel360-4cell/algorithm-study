import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numerOfLines;

        StringBuilder sb = new StringBuilder();
        numerOfLines = Integer.parseInt(br.readLine());

        for(int i = 0; i < numerOfLines; i++){
            String testString = br.readLine();
            sb.append(solution(testString)).append("\n");
        }
        System.out.print(sb);
    }

    public static String solution(String testString) throws IOException{

        String pattern = "^[A-F]?A+F+C+[A-F]?$";
        if(testString.matches(pattern))
            return "Infected!";
        else
            return "Good";

    }
}
