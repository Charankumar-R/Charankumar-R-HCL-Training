package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ReportPublisher {

    public static void publish() {
        try {
            Files.copy(
                new File("reports/ExtentReport.html").toPath(),
                new File("report-repo/ExtentReport.html").toPath(),
                StandardCopyOption.REPLACE_EXISTING
            );

            Runtime.getRuntime().exec(
                "cmd /c cd report-repo && " +
                "git add . && " +
                "git commit -m \"Update extent report\" && " +
                "git push origin main"
            );

            System.out.println("Report pushed to report repo");

        } catch (Exception e) {
            System.out.println("Report publish failed");
        }
    }
}
