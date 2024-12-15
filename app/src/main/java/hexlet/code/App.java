package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true)

public class App implements Callable<Integer> {

    @Parameters(index = "0", description = "The first file to parse.")
    private String filepath1;

    @Parameters(index = "1", description = "The second file to parse.")
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
    public Integer call() throws Exception {
        String diff = Differ.generate(filepath1, filepath2, format);
        System.out.println(diff);
        return 0;
    }
}
