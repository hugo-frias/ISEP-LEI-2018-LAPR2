/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lapr.project.gpsd.model.ZipCode;

/**
 *
 * @author Beatriz Ribeiro
 */
public class Loader {

    public static List<ZipCode> readZipCodes() throws FileNotFoundException, ParseException {
        String line = "";
        ArrayList<ZipCode> zipCodesList = new ArrayList();
        String fileName = "codigopostal_alt_long.csv";
        File f = new File(fileName);
        
        String path = f.getAbsolutePath();
        
        if(!f.isFile()) {
            throw new FileNotFoundException("Ficheiro " + fileName + " não encontrado.");
        }
        Scanner in = new Scanner(f);

        int n = 0;
        in.nextLine();
        
        while (in.hasNext()) {
            line = in.nextLine();
            //line = line.trim();
            if (line.length() > 0) {
                String temp[] = line.split(";");
                try {
                    if (temp.length == 15) {
                        zipCodesList.add(new ZipCode(
                                temp[7].trim() + "-" + String.format("%03d", Integer.parseInt(temp[8].trim())),
                                Double.parseDouble(temp[10].trim().replace(",", ".")),
                                Double.parseDouble(temp[11].replace(",", ".").trim())
                            )
                        );
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }

            }
            n++;
        }
        in.close();
        return zipCodesList;

    }
}
