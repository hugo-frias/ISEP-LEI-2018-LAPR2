package lapr.project.serviceprovider.utils;

import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author André Novo
 * @author Diogo Ribeiro
 */
public class Utils {

    /**
     * Creates an alert
     *
     * @param alertType alert type
     * @param header alert header text
     * @param message alert content text
     * @return alert
     */
    public static Alert createAlert(Alert.AlertType alertType, String header, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Alert");
        alert.setHeaderText(header);
        alert.setContentText(message);
        return alert;
    }

    /**
     * Prints a list
     *
     * @param list list
     * @return sb
     */
    public static String printList(List<?> list) {
        String sb = "";
        for (int i = 0; i < list.size(); i++) {
            sb += list.get(i) + "\n";
        }
        return sb;
    }

    /**
     * Creates a confirmation alert to leave a scene.
     *
     * @return alert
     */
    public static Alert createConfirmationExitAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to cancel this action?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Cancel");
        alert.setHeaderText("Cancel the action");
        return alert;
    }

    /**
     * Creates an information alert with the header "Successful operation"
     *
     * @param title alert's title
     * @param message alert's content text
     * @return alert
     */
    public static Alert createInformationSuccessfulOperationAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.FINISH);
        alert.setTitle(title);
        alert.setHeaderText("Successful operation");
        return alert;
    }

    /**
     * Creates a confirmation alert.
     *
     * @param title
     * @param header
     * @param message
     * @return
     */
    public static Alert createConfirmationAlert(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message, ButtonType.YES, ButtonType.NO);

        alert.setTitle(title);
        alert.setHeaderText(message);

        return alert;
    }

    public static boolean containsLetter(String s) {

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c)) {
                    return true;

                }
            }
        }

        return false;
    }
}
