package lapr.project.gpsd.model;

/**
 *
 * @author André Novo
 */
public class ApplicationStatus {

    /**
     * attribute that represents Application Status's description
     */
    private String description;

    public enum Status {
        CECKEDACCEPTED("Checked and Accepted"),
        SUBMITTED("Submitted"),
        CHECKEDANDREJECTED("Checked and rejected");
        private String status;

        private Status(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
        
    }

    /**
     * Creates Application Status with status Submitted by defauld 
     */
    public ApplicationStatus() {
        this.description =Status.SUBMITTED.getStatus();
        
    }

    /**
     * Modifies Application status
     * @param description - new application status
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
