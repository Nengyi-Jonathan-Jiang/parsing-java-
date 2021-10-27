import parsing.*;

public class Main{
    public static void main(String[] args){
        var scan = new java.util.Scanner(System.in);
        while(true){
            System.out.print(">>> ");
            if(Parsing.exec(scan.nextLine())) break;
        }
        scan.close();
    }
}