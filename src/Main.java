import java.io.Console;

import javax.xml.transform.Source;

public class Main {
    public static void main(String[] args) throws Exception {

        String fname = args[0];
        Parser parse = new Parser(fname);
        startConsole(parse);
    }

    public static void startConsole(Parser parse) {

        Console cons = System.console();
        String input = "";
        while (!input.trim().toLowerCase().equals("exit")) {
            input = cons.readLine(">");
            input = input.trim().toLowerCase();
            if (parse.getCurrentPosition().getDirection().containsKey(input)) {
                String nextID = parse.getCurrentPosition().getDirection().get(input);
                parse.setPosition(parse.getAllPositions().getPositionList().get(nextID));
                System.out.printf("You have decided to go %s\n", input);
                parse.look();
            } else {
                System.out.println("You can't go there!\n");
            }
        }
        System.out.println("Exiting...");
    }

}