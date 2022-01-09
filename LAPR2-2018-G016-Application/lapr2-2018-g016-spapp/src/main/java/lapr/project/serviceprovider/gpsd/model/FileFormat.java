package lapr.project.serviceprovider.gpsd.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 *
 * @author Diogo Ribeiro
 */
public class FileFormat {

    /**
     * atributte that represents File Format's name
     */
    private final String name;

    /**
     * atributte that represents Importer's class
     */
    private final String importerClass;

    /**
     * Creates File Format's instances
     *
     * @param name - File Format's name
     * @param importerClass - Importer's class
     */
    public FileFormat(String name, String importerClass) {
        this.name = name;
        this.importerClass = importerClass;
    }

    /**
     * Retuns the File Format's name
     * 
     * @return File Format's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the Importer's class
     * 
     * @return importer's class
     */
    public String getImporterClass() {
        return importerClass;
    }

    /**
     * Returns information about file format
     *
     * @return String with information
     */
    @Override
    public String toString() {
        return String.format("File format type: %s", name);
    }

    /**
     * Imports the file by Reflection
     *
     * @param nameFile - name of file
     * @return list of service orders
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.NoSuchMethodException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     */
    public List<ServiceOrder> importServiceOrders(String nameFile) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> oClass = Class.forName(this.importerClass);
        Object obj = oClass.newInstance();
        Method importFile = oClass.getDeclaredMethod("importFile", String.class);
        List<ServiceOrder> serviceOrdersList = (List<ServiceOrder>) importFile.invoke(obj, nameFile);
        return serviceOrdersList;
    }

}
