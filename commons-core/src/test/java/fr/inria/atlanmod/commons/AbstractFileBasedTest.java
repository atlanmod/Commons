package fr.inria.atlanmod.commons;

import fr.inria.atlanmod.commons.concurrent.MoreThreads;
import fr.inria.atlanmod.commons.log.Log;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * An abstract test-case that manages temporary files.
 */
@ParametersAreNonnullByDefault
public abstract class AbstractFileBasedTest extends AbstractTest {

    /**
     * The temporary folder.
     */
    private static Path tempFolder;

    /**
     * The current temporary file.
     */
    private Path currentTempFile;

    /**
     * Deletes the given directory with all its files and sub-directories.
     *
     * @param directory the directory to delete
     */
    private static void deleteDirectory(Path directory) {
        try {
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.deleteIfExists(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.deleteIfExists(dir);
                    return FileVisitResult.CONTINUE;
                }
            });

            Files.deleteIfExists(directory);
        }
        catch (Exception e) {
            try {
                MoreThreads.executeAtExit(() -> deleteDirectory(directory));
            }
            catch (IllegalStateException ignored) {
            }
        }
    }

    /**
     * Gets or creates the base temporary folder.
     *
     * @return the temporary folder
     */
    @Nonnull
    private static Path createTempFolder() throws IOException {
        if (isNull(tempFolder)) {
            Log.info("Trying to create a new temporary folder...");

            tempFolder = Files.createTempDirectory("atlanmod");

            Log.info("Temporary folder located at {0}", tempFolder);
        }

        return tempFolder;
    }

    /**
     * Deletes all the content of the temporary folder.
     */
    @AfterAll
    static void cleanTempFolder() throws Exception {
        if (nonNull(tempFolder) && Files.exists(tempFolder)) {
            Log.info("Cleaning temporay folder...");

            deleteDirectory(tempFolder);
        }

        tempFolder = null;
    }

    /**
     * Creates a new temporary file.
     *
     * @return a new {@code File} (not created)
     */
    @Nonnull
    private Path createTempFile() throws IOException {
        if (isNull(currentTempFile)) {
            Log.info("Trying to create a new temporary file...");

            Path createdFolder = Files.createTempDirectory(createTempFolder(), "test");
            Files.deleteIfExists(createdFolder);

            Log.info("Temporary file located at {0}", createdFolder);
            currentTempFile = createdFolder;
        }

        return currentTempFile;
    }

    @AfterEach
    void cleanTempFile() throws Exception {
        if (nonNull(currentTempFile) && Files.exists(currentTempFile)) {
            Log.info("Cleaning temporay file...");

            if (Files.isDirectory(currentTempFile)) {
                deleteDirectory(currentTempFile);
            }
            else {
                Files.deleteIfExists(currentTempFile);
            }
        }

        currentTempFile = null;
    }

    /**
     * Returns the current temporary file.
     *
     * @return a {@link File}
     */
    @Nonnull
    protected File currentTempFile() throws IOException {
        return createTempFile().toFile();
    }
}
