package edu.epam.fadeev.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReaderInformation {

    private static final Logger logger = LogManager.getLogger(ReaderInformation.class);

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
            scanFile = new Scanner(new File("data/test.properties"));
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        }
        String lineString;
        if (scanFile != null) {
            try {
                lineString = scanFile.nextLine();
                lineInfoList = lineString.split(", ");
            } catch (NullPointerException e) {
                logger.error(e.getMessage(), e);
            }
            scanFile.close();
        }
        logger.debug(">> end read file, result <<" + lineInfoList.toString());
        return lineInfoList;
    }
}
