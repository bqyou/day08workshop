import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Parser {

    private Position currentPosition;
    private AllPositions allPositions;

    public Parser(String f) throws Exception {
        Path p = Paths.get(f);
        File file = p.toFile();
        Reader r = new FileReader(file);
        BufferedReader br = new BufferedReader(r);
        String line;
        this.allPositions = new AllPositions();

        while (null != (line = br.readLine())) {
            String[] argument = line.split(" ");

            switch (argument[0].trim()) {
                case "room:":
                    this.currentPosition = new Position(argument[1]);
                    break;
                case "name:":
                    this.currentPosition.setName(line.substring(6));
                    break;
                case "description:":
                    this.currentPosition.setDescription(line.substring(13));
                    break;
                case "direction:":
                    this.currentPosition.addDirection(argument[1], argument[2]);
                    break;
                case "":
                    this.allPositions.setPositionList(currentPosition.getId(), currentPosition);

                    break;
                case "start:":
                    if (allPositions.getPositionList().keySet().contains(argument[1])) {
                        this.currentPosition = allPositions.getPositionList().get(argument[1]);
                        System.out.println("\n ------------WELCOME---------");
                        System.out.printf("Starting Position: %s\n", this.currentPosition.getName());
                        System.out.println(this.currentPosition.getDescription());
                        System.out.printf("Available moves: %s\n", this.currentPosition.getDirection().keySet());
                    }
                    break;
            }
        }
        br.close();

    }

    public Position getCurrentPosition() {
        return this.currentPosition;
    }

    public AllPositions getAllPositions() {
        return this.allPositions;
    }

    public void setPosition(Position p) {
        this.currentPosition = p;
    }

    public void look() {
        System.out.printf("Current room: %s\n", this.currentPosition.getName());
        System.out.println(this.currentPosition.getDescription() + "\n");
        System.out.printf("Available options -> %s\n", this.currentPosition.getDirection().keySet());
    }

    // String room = "";
    // String name = "";
    // String description = "";
    // Map<String, String> directions = new HashMap<String, String>();
    // Map<String, Position> positions = new HashMap<String, Position>();

    //

}
