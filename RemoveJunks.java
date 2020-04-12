package com.ashoury.de.actualization.RemoveEmptyFolders;
import java.io.File;
import java.util.Scanner;


public class RemoveJunks {

    private static String FOLDER_LOCATION = "E:\\TEST";
    private static boolean isFinished = false;

    public static void main(String[] args) {

        FOLDER_LOCATION = args[0];
        System.out.println("Are you sure you want to remove empty folders inside ::" + FOLDER_LOCATION + "  ?");

        Scanner scanner = new Scanner(System.in);

        String val = scanner.next();
        if (val.equalsIgnoreCase("y") || val.equalsIgnoreCase("yes")) {

            do {
                isFinished = true;
                replaceText(FOLDER_LOCATION);
            } while (!isFinished);


        } else {
            System.out.println("Maybe next time");
        }

    }




    private static void replaceText(String fileLocation) {
        File folder = new File(fileLocation);
        File[] listofFiles = folder.listFiles();
        if (listofFiles.length == 0) {
            System.out.println("Empty Folder Name :: " + folder.getAbsolutePath() + " is already deleted.");
            folder.delete();
            isFinished = false;
        } else {
            for (int j = 0; j < listofFiles.length; j++) {
                File file = listofFiles[j];
                if (file.isDirectory()) {
                    replaceText(file.getAbsolutePath());
                }
            }
        }
    }



}
