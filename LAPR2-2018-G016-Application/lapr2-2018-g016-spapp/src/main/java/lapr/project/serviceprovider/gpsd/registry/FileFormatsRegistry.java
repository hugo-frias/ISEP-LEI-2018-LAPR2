package lapr.project.serviceprovider.gpsd.registry;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import lapr.project.serviceprovider.gpsd.model.FileFormat;
import lapr.project.serviceprovider.utils.CompanyFinals;

/**
 *
 * @author Diogo Ribeiro
 */
public class FileFormatsRegistry {

    /**
     * list that has all Company's File Formats
     */
    private final List<FileFormat> fileFormats;

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

    private Properties getProperties() {
        Properties props = new Properties();
        try {
            InputStream in = new FileInputStream(CompanyFinals.FILE_PARAM);
            props.load(in);
            in.close();
        } catch (Exception ex) {
            System.out.println("slcknslc");
        }
        return props;
    }
}
