/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lapr.project.gpsd.model.Availability;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.OperatesAt;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.SchedulePreference;
import lapr.project.gpsd.model.SchedulePreference.SchedulePreferenceStatus;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceRequestDescription;
import lapr.project.gpsd.model.ZipCode;
import lapr.project.utils.Utils;

/**
 *
 * @author Beatriz Ribeiro
 */
public class AffectationRules {

    List<ServiceProvider> listSPBySchedule;

    /**
     * Return list of service providers that perform in service category
     *
     * @param listSP - list of Service Proviers
     * @param servReqDesc - service request description
     * @return a new list of service providers
     */
    public static List<ServiceProvider> affectByCategory(List<ServiceProvider> listSP, ServiceRequestDescription servReqDesc) {
        List<ServiceProvider> listSPByCat = new ArrayList<ServiceProvider>();
        for (ServiceProvider serviceProvider : listSP) {
            for (Category category : serviceProvider.getCategoriesList()) {
                if (servReqDesc.getService().getCategory().equals(category)) {
                    listSPByCat.add(serviceProvider);
                    break;
                }
            }
        }
        return listSPByCat;
    }

    /**
     * Returns list of service providers that have availability according to
     * client's schedules
     *
     * @param listByCategory - previous list of service providers that perform
     * in service category
     * @param servReqPref - service request schedule preference
     * @return a new list of service providers
     */
    public static List<ServiceProvider> affectBySchedule(List<ServiceProvider> listByCategory, SchedulePreference servReqPref) {
        List<ServiceProvider> listSPBySchedule = new ArrayList<ServiceProvider>();
        if (servReqPref.getScheduleStatus().equals(SchedulePreferenceStatus.SUBMITTED.getStatus())) {
            for (ServiceProvider serviceProvider : listByCategory) {
                listSPBySchedule.addAll(handleAvailabilitiesForServiceProvider(serviceProvider, servReqPref));
            }
        }

        return listSPBySchedule;
    }

    /**
     * Returns a list of service providers that perform in the area of the
     * client's postal address
     *
     * @param listBySchedule - previous list of service providers that were
     * available for a certain client's schedule
     * @param postalAddress - client's postal address
     * @return a new list of service providers
     */
    public static List<ServiceProvider> affectByGeographicalArea(List<ServiceProvider> listBySchedule, PostalAddress postalAddress) {
        List<ServiceProvider> listSPByGA = new ArrayList<ServiceProvider>();
        for (ServiceProvider serviceProvider : listBySchedule) {
            for (GeographicalArea geographicalArea : serviceProvider.getGeographicalAreasList()) {
                for (OperatesAt operatesAt : geographicalArea.getOperatesAt()) {
                    if (operatesAt.getZc().equals(postalAddress.getZipCode())) {
                        listSPByGA.add(serviceProvider);
                        break;
                    }
                }

                if (listSPByGA.contains(serviceProvider)) {
                    break;
                }
            }
        }
        return listSPByGA;

    }

    /**
     * Returns a list of service providers with the highest rate
     *
     * @param listByGA - previous list of service providers that perform at a
     * certain area
     * @return a new list of service providers
     */
    public static List<ServiceProvider> affectByRate(List<ServiceProvider> listByGA) {
        List<ServiceProvider> listByRate = new ArrayList<ServiceProvider>();
        double maxRate = 0;
        for (ServiceProvider serviceProvider : listByGA) {
            if (serviceProvider.getLabelRate().getMean() >= maxRate) {
                maxRate = serviceProvider.getLabelRate().getMean();
                listByRate.add(serviceProvider);
            }
        }
        return listByRate;
    }

    /**
     * Returns a list of service providers that are closer to the client
     *
     * @param listByRate - previous list of service providers that perform at a
     * certain
     * @param postAddress - client's postal address
     * @return a new list of service providers
     */
    public static List<ServiceProvider> affectByDistance(List<ServiceProvider> listByRate, PostalAddress postAddress) {
        ZipCode firstZipCode = listByRate.get(0).getPostalAddress().getZipCode();
        double minDistance = Utils.getDistance(firstZipCode.getLatitude(), firstZipCode.getLongitude(), postAddress.getZipCode().getLatitude(), postAddress.getZipCode().getLongitude());
        List<ServiceProvider> listByDistance = new ArrayList<ServiceProvider>();
        for (ServiceProvider serviceProvider : listByRate) {
            ZipCode otherZipCode = serviceProvider.getPostalAddress().getZipCode();
            double otherDistance = Utils.getDistance(otherZipCode.getLatitude(), otherZipCode.getLongitude(), postAddress.getZipCode().getLatitude(), postAddress.getZipCode().getLongitude());
            if (otherDistance <= minDistance) {
                minDistance = otherDistance;
                listByDistance.add(serviceProvider);
            }
        }
        return listByDistance;
    }

    /**
     * Returns a service provider choosed´by alphabetic order
     *
     * @param listByDistance - previous list of service providers that were
     * coler to client
     * @return service provider
     */
    public static List<ServiceProvider> affectByAlphabeticOrder(List<ServiceProvider> listByDistance) {
        Collections.sort(listByDistance, new SPComparator());
        return listByDistance;
    }

    /**
     * class to compare SP names
     */
    public static class SPComparator implements Comparator<ServiceProvider> {

        @Override
        public int compare(ServiceProvider sp1, ServiceProvider sp2) {
            return (sp1.getCompleteName().compareTo(sp1.getCompleteName()));
        }
    }

    private static List<ServiceProvider> handlePatternsListForAvailability(ServiceProvider serviceProvider, Availability availability, SchedulePreference servReqPref) {
        List<ServiceProvider> listSPBySchedule = new ArrayList<>();

        if (!availability.getPatternsList().isEmpty()) {
            for (String pattern : availability.getPatternsList()) {
                while (availability.getDateBeginning().compareTo(availability.getDateEnding()) < 1) {
                    if (pattern.equals(servReqPref.getDate().weekDay())) {
                        if (servReqPref.getHour().isGreater(availability.getHourBeginning()) && availability.getHourEnding().differenceInSeconds(servReqPref.getHour()) >= 1800) {
                            listSPBySchedule.add(serviceProvider);
                            break;
                        }
                    }
                }
            }
        } else {
            if (servReqPref.getHour().compareTo(availability.getHourBeginning())>=0 && availability.getHourEnding().differenceInSeconds(servReqPref.getHour()) >= 1800 && availability.getHourEnding().compareTo(servReqPref.getHour())>=0) {
                listSPBySchedule.add(serviceProvider);
                
            }
        }

        return listSPBySchedule;
    }

    private static List<ServiceProvider> handleAvailabilitiesForServiceProvider(ServiceProvider serviceProvider, SchedulePreference servReqPref) {
        List<ServiceProvider> listSPBySchedule = new ArrayList<>();

        if (!serviceProvider.getAvailabilityList().getAvailabilities().isEmpty()) {
            for (Availability availability : serviceProvider.getAvailabilityList().getAvailabilities()) {
                if (servReqPref.getDate().compareTo(availability.getDateBeginning())>=0 && availability.getDateEnding().compareTo(servReqPref.getDate())>=0) {
                    listSPBySchedule.addAll(handlePatternsListForAvailability(serviceProvider, availability, servReqPref));
                }
            }
        }

        return listSPBySchedule;
    }
}
