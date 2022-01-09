/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.registry;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import lapr.project.gpsd.model.FileFormat;
import lapr.project.utils.CompanyFinals;

/**
 *
 * @author Diogo Ribeiro
 */
public class FileFormatsRegistry {
    
        /**
		* list that has all Company's File Formats
		*/
		
    private List<FileFormat> fileFormats;

    /**
     * Creates a list of File Formats
     */
    public FileFormatsRegistry() {
        fileFormats = createSupportedFileFormats(getProperties());
    }

    /**
     * Returns a list of file formats
     *
     * @return file formats
     */
	 
    public List<FileFormat> getFileFormats() {
        return fileFormats;
    }

    /**
     * Creates supported File Formats
     *
     * @param props file of properties
     * @return list of supported file formats
     */
    public List<FileFormat> createSupportedFileFormats(Properties props) {
        List<FileFormat> fileFormatsList = new ArrayList<>();
        String qntTypes = props.getProperty("Company.QuantityOfSupportedFileFormats");
        int qnt = Integer.parseInt(qntTypes);
        for (int i = 1; i <= qnt; i++) {
            String desc = props.getProperty(
                    "Company.FileFormat." + i + ".Name").trim();
            String importerClass = props.getProperty(
                    "Company.FileFormat." + i + ".Class").trim();
            FileFormat fileFormat = new FileFormat(desc, importerClass);
            fileFormatsList.add(fileFormat);
        }
        return fileFormatsList;
    }
	
	/*
	* Method that will create and return the Properties instance
	* @return props Properties instance
	*/
	
    private Properties getProperties() {
        Properties props = new Properties();
        try {
            try (InputStream in = new FileInputStream(CompanyFinals.FILE_PARAM)) {
                props.load(in);
            }
        } catch (IOException ex) {

        }
        return props;
    }
}