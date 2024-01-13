package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.io.File;

@Command(name="gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {

    @Option(names = {"-f", "--format"}, paramLabel = "format", defaultValue = "stylish", description = "output format [default: stylish]")
    private String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private File file1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private File file2;
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean help;
    @Option(names = {"-V", "--version"}, description = "Print version information and exit.")
    boolean version;

    @Override
    public void run() {
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}