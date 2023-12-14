package backjoon.string.Silver_3_9342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int t;
    static final String REGEX = "^[A-F]?A+F+C+[A-F]?$";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t= Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            String s = br.readLine();

            // 정규식 조건에 맞으면 Infected! 아니면 Good
            if(s.matches(REGEX)){
                System.out.println("Infected!");
            }
            else{
                System.out.println("Good");
            }
        }
    }
}
