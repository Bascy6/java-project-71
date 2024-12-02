package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true)
public class App implements Runnable {

    @Parameters(index = "0", description = "The first file to compare.")
    private String filepath1;

    @Parameters(index = "1", description = "The second file to compare.")
    private String filepath2;

    @Option(
            names = {"-f", "--format"},
            paramLabel = "format",
            defaultValue = "stylish",
            description = "output format [default: ${DEFAULT-VALUE}]")
    private String format;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        Parsing parsing = new Parsing();
        try {
            Config mergedConfig = parsing.mergeConfigs(filepath1, filepath2);
            System.out.println("Parsing: " + mergedConfig);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}