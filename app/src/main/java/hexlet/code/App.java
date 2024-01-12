package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

public class App {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new genDiffCommand()).execute(args);
        System.exit(exitCode);
    }
}
@Command(name="gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
class genDiffCommand implements Runnable {

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean help;
    @Option(names = {"-V", "--version"}, description = "Print version information and exit.")
    boolean version;

    @Override
    public void run() {
    }
}