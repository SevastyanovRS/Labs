import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.ZoneOffset;

public class PhotoSorter {
    private static int total = 0;
    private static int skipped = 0;

    public static void main(String[] args) throws IOException {
        //comment for foolproof
//        File sortDir = new File("/.../Pictures");
//        File initialPath = new File("/.../sort");
//        sort(initialPath, sortDir);
        System.out.println("Finished. Moved files count: " + total + ", skipped:" + skipped);
    }

    private static void sort(File dir, File sortDir) throws IOException {
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File original: files) {

                if (original.isHidden()) continue;

                BasicFileAttributes originalAttr = Files.readAttributes(original.toPath(), BasicFileAttributes.class);

                if (originalAttr.isDirectory()) {
                    sort(original, sortDir);
                } else {
                    int year = originalAttr.lastModifiedTime().toInstant().atZone(ZoneOffset.UTC).getYear();

                    System.out.println("Processing file " + original.getName() + " with year of creation " + year);

                    File newDir = new File(sortDir.getAbsolutePath() + "/" + year);
                    if (!newDir.exists()) {
                        if (newDir.mkdir()) {
                            System.out.println("Directory for year " + newDir.getName() + " was created");
                        }
                    }

                    System.out.println("Moving " + original.getName() + " to " + newDir);
                    resolveNameAndMoveFile(newDir, original, original.getName(), 0);
                    System.out.println("---------------");
                }
            }
        }
    }

    private static void resolveNameAndMoveFile(File dir, File original, String fileName, int copyNumber) {
        String[] split = fileName.split("\\.");
        File movedFile = new File(dir + "/" + fileName);
        if (movedFile.exists()) {

            if (movedFile.length() == original.length()) {
                System.out.println("File " + movedFile.getName() + " is identical, skip");
                skipped = skipped + 1;
                return;
            }
            System.out.println("File with name " + movedFile.getName() + " already exist, adding copy number ");
            resolveNameAndMoveFile(dir, original, split[0] + " (" + ++copyNumber + ")." + split[1], ++copyNumber);
        } else {
            if (original.renameTo(movedFile)) {
                System.out.println("File " + movedFile.getName() + " moved successful");
                total = total + 1;
            }
        }
    }

}