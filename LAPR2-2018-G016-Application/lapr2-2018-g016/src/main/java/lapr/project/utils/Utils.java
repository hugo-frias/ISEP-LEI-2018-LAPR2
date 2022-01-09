/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message, ButtonType.YES, ButtonType.NO);
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

    public static int countDigit(int num) {
        if (num == 0) {
            return 1;
        }
        int n = 0;
        while (num > 0) {
            num /= 10;
            n++;
        }
        return n;
    }

    public static boolean containsNum(String s) {

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    return true;

                }
            }
        }

        return false;
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

    public static boolean validateNifORPhone(double nif) {
        if (nif < 100000000 || nif > 999999999) {
            return false;      
        }
        return true;
    }
    
    /*
    * Method to validate two string fields
     */
    public static void validadeTwoStringFields(String s1, String s2) {
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            throw new NullPointerException("Argumment invalid.");
        }
    }
    public static double getDistance(double latitude1, double longitude1, double latitude2, double longitude2) {

        final double R = 6371e3;
        double theta1 = Math.toRadians(latitude1);
        double theta2 = Math.toRadians(latitude2);
        double deltaTheta = Math.toRadians(latitude2 - latitude1);
        double deltaLambda = Math.toRadians(longitude2 - longitude1);
        double a = Math.sin(deltaTheta / 2) * Math.sin(deltaTheta / 2) + Math.cos(theta1) * Math.cos(theta2) * Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c;
        if (d <= 0) {
            return 0;
        } else {
            return d;
        }
    }
    public static boolean validateServicePeriod(int period){
        if(period<CompanyFinals.PERIOD_SERVICE_MIN && period%CompanyFinals.PERIOD_SERVICE_MIN!=0){
            return true;
        }
        return false;
    }
}
