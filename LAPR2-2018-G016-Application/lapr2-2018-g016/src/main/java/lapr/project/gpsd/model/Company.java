package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import lapr.project.autorizacao.FacadeAuthorization;
import lapr.project.gpsd.algorithm.TaskFactory;
import lapr.project.gpsd.registry.AffectationsRegistry;
import lapr.project.gpsd.registry.CategoriesRegistry;
import lapr.project.gpsd.registry.ClientsRegistry;
import lapr.project.gpsd.registry.ServiceTypesRegistry;
import lapr.project.gpsd.registry.ServicesRegistry;
import lapr.project.gpsd.registry.ApplicationsRegistry;
import lapr.project.gpsd.registry.FileFormatsRegistry;
import lapr.project.gpsd.registry.GeographicalsAreasRegistry;
import lapr.project.gpsd.registry.ServiceOrdersRegistry;
import lapr.project.gpsd.registry.ServiceProvidersRegistry;
import lapr.project.gpsd.registry.ServiceRequestRegistry;

/**
 *
 * @author André Novo
 */
public class Company {

    /**
     * attribute that represents Company's name
     */
    private String name;

    /**
     * attribute that represents Company's nif
     */
    private String nif;

    /**
     * attribute that represents Clients registry
     */
    private final ClientsRegistry clientsRegistry;

    /**
     * attribute that represents Categories registry
     */
    private final CategoriesRegistry categoriesRegistry;

    /**
     * attribute that represents Services registry
     */
    private final ServicesRegistry servicesRegistry;

    /**
     * attribute that represents Service Types registry
     */
    private final ServiceTypesRegistry serviceTypesRegistry;
    /**
     * attribute that represents Applications Registry
     */
    private final ApplicationsRegistry applicationsRegistry;
    /**
     * attribute that represents Geographical Area Registry
     */
    private final GeographicalsAreasRegistry geographicalAreaResgitry;
    
    /**
     * attribute that represents ServiceRequest registry 
     */
    private final ServiceRequestRegistry serviceRequestRegistry;
    
    /**
     * attribute that represents File Formats registry
     */
    
    private final FileFormatsRegistry fileFormatRegistry;
    /**
     * attribute that represents External Service
     */
    
    private final ExternalService externalService;
    
    /**
     * attribute that represents ServiceProvidersRegistry
     */
    private final ServiceProvidersRegistry serviceProvidersRegistry;
    
    /**
     * attribute that represents affectations registry
     */
    private final AffectationsRegistry affectationsRegistry;
    
    /**
     * attribute that represents servce orders registry;
     */
    private final ServiceOrdersRegistry serviceOrdersRegistry;
    
    /**
     * attribute that represents authorization
     */
    private final FacadeAuthorization authorization;
    
    /**
     * attribute that represents Task Factory
     */
    private TaskFactory taskFactory;

    /**
     * Creates Company's instances
     *
     * @param name - Company's name
     * @param nif - Company's nif
     */
    public Company(String name, String nif) {
        this.name = name;
        this.nif = nif;
        clientsRegistry = new ClientsRegistry();
        authorization = new FacadeAuthorization();
        categoriesRegistry = new CategoriesRegistry();
        serviceTypesRegistry = new ServiceTypesRegistry();
        servicesRegistry = new ServicesRegistry();
        applicationsRegistry = new ApplicationsRegistry();
        geographicalAreaResgitry = new GeographicalsAreasRegistry();
        serviceRequestRegistry= new ServiceRequestRegistry();
        externalService = new ExternalService();
        serviceProvidersRegistry = new ServiceProvidersRegistry();
        affectationsRegistry= new AffectationsRegistry();
        serviceOrdersRegistry= new ServiceOrdersRegistry();
        fileFormatRegistry = new FileFormatsRegistry();
         
    }

    /**
     * Returns Client's Registry
     *
     * @return clients registry
     */
    public ClientsRegistry getClientsRegistry() {
        return this.clientsRegistry;
    }

    /**
     * Returns Categories's Registry
     *
     * @return categories registry
     */
    public CategoriesRegistry getCategoriesRegistry() {
        return categoriesRegistry;
    }

    /**
     * Returns Services's Registry
     *
     * @return services registry
     */
    public ServicesRegistry getServicesRegistry() {
        return servicesRegistry;
    }

    /**
     * Returns Service Types's Registry
     *
     * @return service types registry
     */
    public ServiceTypesRegistry getServiceTypesRegistry() {    
        return serviceTypesRegistry;
    }
    
    /**
     * Returns geographical area registry
     * @return geographical areas registry
     */

    public GeographicalsAreasRegistry getGeographicalAreaResgitry() {
        return geographicalAreaResgitry;
    }
    
    /**
     * Returns Applications Registry
     * @return Applications Registry
     */
    public ApplicationsRegistry getApplicationsRegistry(){
        return applicationsRegistry;
    }
    
    /**
     * Returns External Service
     * @return external service
     */
    public ExternalService getExternalService() {
        return externalService;
    }

    /**
     * Returns ServiceRequestRegistry
     * @return servicerRequestRegistry
     */
    public ServiceRequestRegistry getServiceRequestRegistry() {
        return serviceRequestRegistry;
    }
    
    /**
     * Returns ServiceProvidersRegistry
     * @return serviceProvidersRegistry
     */
    public ServiceProvidersRegistry getServiceProvidersRegistry() {
        return serviceProvidersRegistry;
    }

    /**
     * Returns AffectationsRegistry
     * @return affectations registry
     */
    public AffectationsRegistry getAffectationsRegistry() {
        return affectationsRegistry;
    }

    /**
     * Returns service order registry
     * @return service order registry
     */
    public ServiceOrdersRegistry getServiceOrdersRegistry() {
        return serviceOrdersRegistry;
    }
    
    /**
     * Returns file formats registry
     * @return file formats registry
     */
    
    public FileFormatsRegistry getFileFormatsRegistry() {
        return fileFormatRegistry;
    }
    
    /**
     * Returns authorization instance
     *
     * @return authorization
     */
    public FacadeAuthorization getAuthorization() {
        return this.authorization;
    }

    /**
     * Creates supported ServiceTypes
     *
     * @param props file of properties
     * @return list of supported service types
     */
    public List<ServiceType> createSupportedServiceTypes(Properties props) {
        List<ServiceType> serviceTypesList = new ArrayList<ServiceType>();
        String qntTypes = props.getProperty("Company.QuantityOfSupportedServiceTypes");
        int qnt = Integer.parseInt(qntTypes);
        for (int i = 1; i <= qnt; i++) {
            String desc = props.getProperty(
                    "Company.ServiceType." + i + ".Name");
            String serviceClass = props.getProperty(
                    "Company.ServiceType." + i + ".Class");
            ServiceType serviceType = new ServiceType(desc, serviceClass);
            serviceTypesList.add(serviceType);
        }
        return serviceTypesList;
    }
}
