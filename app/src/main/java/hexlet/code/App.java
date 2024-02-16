package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public final class App implements Callable<String> {

    @Option(names = {"-f", "--format"}, paramLabel = "format",
            defaultValue = "stylish", description = "output format stylish, plain, json [default: stylish]")
    private String formatName;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String file1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String file2;
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean help;
    @Option(names = {"-V", "--version"}, description = "Print version information and exit.")
    private boolean version;

    @Override
    public String call() throws Exception {
        String result = Differ.generate(file1, file2, formatName);
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
