import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Day 1 Part 1 : " + day1Part1());
        System.out.println("Day 1 Part 2 : " + day1Part2());
        System.out.println("Day 2 Part 1 : " + day2Part1());
        System.out.println("Day 2 Part 2 : " + day2Part2());
    }

    public static int day1Part1() {
        File file = new File("/Users/pittawattaveekitworachai/Projects/Java/AdventOfCode/src/inputs/day1.txt");
        try {
            Scanner scanner = new Scanner(file);
            int totalFuelOfAllModules = 0;
            while (scanner.hasNext()) {
                int current = scanner.nextInt();
                totalFuelOfAllModules += current / 3 - 2;
            }
            return totalFuelOfAllModules;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int day1Part2() {
        File file = new File("/Users/pittawattaveekitworachai/Projects/Java/AdventOfCode/src/inputs/day1.txt");
        try {
            Scanner scanner = new Scanner(file);
            int totalFuelOfAllModules = 0;
            while (scanner.hasNext()) {
                int current = scanner.nextInt();
                int fuel = current / 3 - 2;
                int currentTotalFuel = 0;
                while (fuel > 0) {
                    currentTotalFuel += fuel;
                    fuel = fuel / 3 - 2;
                }
                totalFuelOfAllModules += currentTotalFuel;
            }
            return totalFuelOfAllModules;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int day2Part1() {
        File file = new File("/Users/pittawattaveekitworachai/Projects/Java/AdventOfCode/src/inputs/day2.txt");
        try {
            Scanner scanner = new Scanner(file);
            String commandList = scanner.nextLine();
            String[] commands = commandList.split(",");
            commands[1] = "12";
            commands[2] = "2";
            for (int i = 0; i < commands.length; i += 4) {
                int command = Integer.parseInt(commands[i]);
                if (command == 99) break;
                int input1Location = Integer.parseInt(commands[i + 1]);
                int input2Location = Integer.parseInt(commands[i + 2]);
                int resultLocation = Integer.parseInt(commands[i + 3]);

                int input1Value = Integer.parseInt(commands[input1Location]);
                int input2Value = Integer.parseInt(commands[input2Location]);
                int result = command == 1 ? input1Value + input2Value : input1Value * input2Value;
                commands[resultLocation] = "" + result;
            }
            return Integer.parseInt(commands[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int day2Part2() {
        File file = new File("/Users/pittawattaveekitworachai/Projects/Java/AdventOfCode/src/inputs/day2.txt");
        try {
            Scanner scanner = new Scanner(file);
            String commandList = scanner.nextLine();
            String[] originalCommands = commandList.split(",");
            int currentNoun = 0;
            int currentVerb = 0;

            loop:
            for (int i = 0; i <= 99; i++) {
                for (int j = 0; j <= 99; j++) {
                    String[] commands = new String[originalCommands.length];
                    System.arraycopy(originalCommands, 0, commands, 0, originalCommands.length);
                    currentNoun = i;
                    currentVerb = j;
                    commands[1] = "" + i;
                    commands[2] = "" + j;

                    for (int k = 0; k < commands.length; k += 4) {
                        int command = Integer.parseInt(commands[k]);
                        if (command == 99) break;
                        int input1Location = Integer.parseInt(commands[k + 1]);
                        int input2Location = Integer.parseInt(commands[k + 2]);
                        int resultLocation = Integer.parseInt(commands[k + 3]);

                        int input1Value = Integer.parseInt(commands[input1Location]);
                        int input2Value = Integer.parseInt(commands[input2Location]);
                        int result = command == 1 ? input1Value + input2Value : input1Value * input2Value;
                        commands[resultLocation] = "" + result;
                    }

                    if (Integer.parseInt(commands[0]) == 19690720) {
                        break loop;
                    }
                }
            }

            return 100 * currentNoun + currentVerb;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
