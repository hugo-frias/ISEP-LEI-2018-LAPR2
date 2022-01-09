package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import lapr.project.utils.Utils;
import static lapr.project.utils.Utils.containsLetter;
import static lapr.project.utils.Utils.countDigit;
import static lapr.project.utils.Utils.createAlert;

/**
 * Class of Application
 *
 * @author André Novo
 */
public class Application {

    /**
     * attribute that represents Applicant's name
     */
    private String name;

    /**
     * attribute that represents Applicant's nif
     */
    private int nif;

    /**
     * attribute that represents Applicant's email
     */
    private String email;

    /**
     * attribute that represents Applicant's phone
     */
    private int phone;
    
    private ApplicationStatus as;

    /**
     * attribute that represents Applicant's postal address
     */
    private PostalAddress postalAddress;
    private List<AcademicQualification> academicQualificationList;
    private List<ProfessionalQualification> professionalQualificationList;
    private List<Category> categoryList;

    /**
     * Creates Application's instances
     *
     * @param name - Applicant's name
     * @param nif - Applicant's nif
     * @param email - Applicant's email
     * @param phone - Applicant's phone
     * @param postalAddress - Applicant's postal address
     */
    public Application(String name, int nif, String email, int phone, PostalAddress postalAddress) {
        if(name == null || name.isEmpty() || email == null || email.isEmpty() ){
            throw new NullPointerException();
        }
        if(!Utils.validateNifORPhone(nif) || !Utils.validateNifORPhone(phone)){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.nif = nif;
        this.email = email;
        this.phone = phone;
        this.postalAddress = postalAddress;
        this.academicQualificationList = new ArrayList<>();
        this.professionalQualificationList = new ArrayList<>();
        this.categoryList = new ArrayList<>();
        as = new ApplicationStatus();
    }

    /**
     * Copy Constructor
     *
     * @param app - other Application
     */
    public Application(Application app) {
        this.name = app.name;
        this.nif = app.nif;
        this.email = app.email;
        this.phone = app.phone;
        this.postalAddress = app.postalAddress;
        this.academicQualificationList = app.academicQualificationList;
        this.professionalQualificationList = app.professionalQualificationList;
        this.categoryList = app.categoryList;
        this.as = app.as;
    }

    /**
     * Returns Application's information
     *
     * @return string with Application's information
     */
    @Override
    public String toString() {
        return String.format("Name: %s%nNIF: %d%nEmail: %s%nPhone: %d%nPostal Address: %s", name, nif, email, phone, postalAddress);
    }

    /**
     * Compares two objects
     *
     * @param obj - another object
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        Application otherApplication = (Application) obj;
        
        if (this == obj) {
            return true;
        } else if (
            obj == null || 
            getClass() != obj.getClass()
        ) {
            return false;
        } else if (
                !otherApplication.name.equals(this.name) || 
                otherApplication.nif != this.nif ||
                !otherApplication.email.equals(this.email) ||
                otherApplication.phone != this.phone ||
                !otherApplication.postalAddress.equals(this.postalAddress)) {
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public int getNif() {
        return nif;
    }
    
    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ApplicationStatus getAs() {
        return as;
    }

    public void setAs(ApplicationStatus as) {
        this.as = as;
    }
    
    
    public boolean addAcadQualifications(String designation, String degree, String classification){
        if (validateAcadQuali(designation, degree, classification)){
            AcademicQualification aq = new AcademicQualification(designation, degree, Double.parseDouble(classification));
            if(!academicQualificationList.contains(aq)){
                academicQualificationList.add(aq);
            }
            else{
                createAlert(Alert.AlertType.ERROR, "Academic Qualification",
                            "Academic Qualification repeated!").show();
            }    
            return true;
        }
        return false;
    }
    public boolean addProQualification(String description){
        if (validateProQualification(description)){
            ProfessionalQualification pq = new ProfessionalQualification(description);
            if(!professionalQualificationList.contains(pq)){
                professionalQualificationList.add(pq);
            }
            else{
                createAlert(Alert.AlertType.ERROR, "Professional Qualification",
                            "Professional Qualification repeated!").show();
            }    
            return true;
        }
        return false;
    }
    public boolean addCategory(Category category){
        if (validateCategory(category)){
            categoryList.add(category);
            return true;
        }
        return false;
    }
    private boolean validateCategory(Category category){
        if(!categoryList.contains(category)){
            return true;
        } else{
            createAlert(Alert.AlertType.ERROR, "Category",
                            "Category repeated!").show();
        }
        return false;
    }
    private boolean validateProQualification(String description){
        if (description.equals("")) {
            createAlert(Alert.AlertType.ERROR, "Professional Qualification", "Dont leave blank boxes!").show();
            return false;
        }
        return true;    
    }
    private boolean validateAcadQuali(String designation, String degree, String classification) {
        boolean aux = false;
        if (designation.equals("") || degree.equals("") || classification.equals("")) {
            createAlert(Alert.AlertType.ERROR, "Academic Qualification", "Dont leave blank boxes!").show();
            return aux;
        }
        try {
            classification.split(".");
        } catch (Exception e) {
            createAlert(Alert.AlertType.ERROR, "Academic Qualification", "Insert a valid classification! (ex: XX.X)").show();
            return aux;
        }

        if (Double.parseDouble(classification) < 0 || Double.parseDouble(classification) > 20) {
            createAlert(Alert.AlertType.ERROR, "Academic Qualification", "The classification should be between 0 and 20!").show();
            return aux;
        }
        if (containsLetter(classification)) {
            createAlert(Alert.AlertType.ERROR, "Academic Qualification", "classification only contains numbers!").show();
            return aux;
        }

        aux = true;
        return aux;
    }
    public static boolean validateName(String fullName, String nif, String phoneNumber, String email) {
        boolean aux = false;
        if (fullName.equals("") || nif.equals("") || phoneNumber.equals("") || email.equals("")) {
            createAlert(Alert.AlertType.ERROR, "Validation", "Dont leave blank boxes!").show();
            return aux;
        }
        if(!email.contains("@") || !email.contains(".")){
            createAlert(Alert.AlertType.ERROR, "Validation", "Insert a valid email!").show();
            return aux;
        }
        if (containsLetter(nif) || containsLetter(phoneNumber)) {
            createAlert(Alert.AlertType.ERROR, "Validation", "NIF and phone number only contains number!").show();
            return aux;
        }
        if (countDigit(Integer.parseInt(nif)) != 9 || countDigit(Integer.parseInt(phoneNumber)) != 9) {
            createAlert(Alert.AlertType.ERROR, "Validation", "NIF and phone number are 9 number digits!").show();
            return aux;
        }

        aux = true;
        return aux;
    }
    public static boolean validateAdress(String address, String locality, String postCode) {

        if (address.equals("") || locality.equals("")) {
            return false;
        }
        
        
        if (!postCode.isEmpty()) {
            if (postCode.contains("-")) {
                String[] postCodeParts = postCode.split("-");
                if(!containsLetter(postCodeParts[0]) || !containsLetter(postCodeParts[1])){
                if (countDigit(Integer.parseInt(postCodeParts[0])) == 4 && countDigit(Integer.parseInt(postCodeParts[1])) <=3) {
                        return true;
                    } else {
                    createAlert(Alert.AlertType.ERROR, "Postal Address",
                            "Insert a valid Postal Code! (ex: XXXX-XXX)").show();
                        
                    }
                } else {
                    
                    createAlert(Alert.AlertType.ERROR, "Postal Address",
                                "Postal Code can't have leters!").show();
                }
            } else {
                createAlert(Alert.AlertType.ERROR, "Postal Address",
                        "Separate the 2 sections with a ''-''!").show();
            }
        } else {
            createAlert(Alert.AlertType.ERROR, "Postal Address",
                    "Dont leave blank spaces!").show();
        }
        return false;

    }
    
}
