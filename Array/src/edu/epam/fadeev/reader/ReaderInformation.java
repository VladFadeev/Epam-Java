package edu.epam.fadeev.reader;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReaderInformation {

    private static final Logger logger = LogManager.getLogger(ReaderInformation.class);
    private static final String FILE_NAME = "data/test.properties";
    private static final String REGEX = ", ";

    public static int[] read() {
        logger.info(">> start <<");
        String[] lineInfo = readFromFile();
        return Arrays.stream(lineInfo).mapToInt(elem -> Integer.valueOf(elem)).toArray();
    }

    private static String[] readFromFile() {
        logger.trace(">> start read file <<");
        String[] lineInfoList = null;
        Scanner scanFile = null;
        try {
            scanFile = new Scanner(new File(FILE_NAME));
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        }
        String lineString = "";
        if (scanFile != null) {
            try {
                lineString = scanFile.nextLine();
                lineInfoList = lineString.split(REGEX);
            } catch (NullPointerException e) {
                lineInfoList = new String[]{};
                logger.info(e.getMessage(), e);
            }
            scanFile.close();
        }
        logger.debug(">> end read file, result: " + Arrays.toString(lineInfoList));
        return lineInfoList;
    }
}
