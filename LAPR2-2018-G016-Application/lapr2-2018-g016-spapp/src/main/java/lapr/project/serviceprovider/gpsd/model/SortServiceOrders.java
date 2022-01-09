package lapr.project.serviceprovider.gpsd.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lapr.project.serviceprovider.gpsd.controller.GPSD;
import lapr.project.serviceprovider.utils.SortParameters;

/**
 *
 * @author Diogo Ribeiro
 */
public class SortServiceOrders {

    /**
     * Sorts the service orders according to a certain parameter.
     * 
     * @param parameter parameter
     * @return sorted service orders's list
     */
    public static List<ServiceOrder> sortServiceOrders(String parameter) {
        List<ServiceOrder> list = GPSD.getInstance().getCompany().getServiceExecutionOrdersRegistry().getServiceExecutionOrders();
        List<ServiceOrder> sortedList = new ArrayList<>();
        if (parameter.equals(SortParameters.CLIENT_NAME.toString())) {
            sortedList = sortServiceOrdersByClientName(list);
        }
        if (parameter.equals(SortParameters.DISTANCE_ASCENDING.toString())) {
            sortedList = sortServiceOrdersByDistanceAscendingOrder(list);
        }
        if (parameter.equals(SortParameters.DISTANCE_DESCENDING.toString())) {
            sortedList = sortServiceOrdersByDistanceDescendingOrder(list);
        }
        if (parameter.equals(SortParameters.SERVICE_CATEGORY.toString())) {
            sortedList = sortServiceOrdersByCategory(list);
        }
        if (parameter.equals(SortParameters.SERVICE_START_DATE.toString())) {
            sortedList = sortServiceOrdersByDate(list);
        }
        if (parameter.equals(SortParameters.SERVICE_START_TIME.toString())) {
            sortedList = sortServiceOrdersByTime(list);
        }
        if (parameter.equals(SortParameters.TYPE_SERVICE.toString())) {
            sortedList = sortServiceOrdersByTypeService(list);
        }
        if (parameter.equals(SortParameters.CLIENT_ADDRESS.toString())) {
            sortedList = sortServiceOrdersByClientAddress(list);
        }
        return sortedList;
    }

    /**
     * Sorts the service orders by client's name.
     *
     * @param list service orders's list to sort
     * @return sorted service order's list
     */
    public static List<ServiceOrder> sortServiceOrdersByClientName(List<ServiceOrder> list) {
        Comparator<ServiceOrder> parameter = new Comparator<ServiceOrder>() {
            @Override
            public int compare(ServiceOrder serv1, ServiceOrder serv2) {
                return serv1.getClientName().compareToIgnoreCase(serv2.getClientName());
            }
        };
        List<ServiceOrder> sortedList = new ArrayList<>();
        sortedList.addAll(list);
        Collections.sort(sortedList, parameter);
        return sortedList;
    }

    /**
     * Sorts the service orders by distance in ascending order.
     *
     * @param list service order's list to sort
     * @return sorted service order's list
     */
    public static List<ServiceOrder> sortServiceOrdersByDistanceAscendingOrder(List<ServiceOrder> list) {
        Comparator<ServiceOrder> parameter = new Comparator<ServiceOrder>() {
            @Override
            public int compare(ServiceOrder serv1, ServiceOrder serv2) {
                return (int) (serv1.getDistance() - serv2.getDistance());
            }
        };
        List<ServiceOrder> sortedList = new ArrayList<>();
        sortedList.addAll(list);
        Collections.sort(sortedList, parameter);
        return sortedList;
    }

    /**
     * Sorts the service orders by distance in descending order.
     *
     * @param list service order's list to sort
     * @return sorted service order's list
     */
    public static List<ServiceOrder> sortServiceOrdersByDistanceDescendingOrder(List<ServiceOrder> list) {
        Comparator<ServiceOrder> parameter = new Comparator<ServiceOrder>() {
            @Override
            public int compare(ServiceOrder serv1, ServiceOrder serv2) {
                return (-1) * (int) (serv1.getDistance() - serv2.getDistance());
            }
        };
        List<ServiceOrder> sortedList = new ArrayList<>();
        sortedList.addAll(list);
        Collections.sort(sortedList, parameter);
        return sortedList;
    }

    /**
     * Sorts the service orders by service category.
     *
     * @param list service orders's list to sort
     * @return sorted service order's list
     */
    public static List<ServiceOrder> sortServiceOrdersByCategory(List<ServiceOrder> list) {
        Comparator<ServiceOrder> parameter = new Comparator<ServiceOrder>() {
            @Override
            public int compare(ServiceOrder serv1, ServiceOrder serv2) {
                return serv1.getServiceCategory().compareToIgnoreCase(serv2.getServiceCategory());
            }
        };
        List<ServiceOrder> sortedList = new ArrayList<>();
        sortedList.addAll(list);
        Collections.sort(sortedList, parameter);
        return sortedList;
    }

    /**
     * Sorts the service orders by service start date.
     *
     * @param list service order's list to sort
     * @return sorted service order's list
     */
    public static List<ServiceOrder> sortServiceOrdersByDate(List<ServiceOrder> list) {
        Comparator<ServiceOrder> parameter = new Comparator<ServiceOrder>() {
            @Override
            public int compare(ServiceOrder serv1, ServiceOrder serv2) {
                return serv1.getDateService().compareTo(serv2.getDateService());
            }
        };
        List<ServiceOrder> sortedList = new ArrayList<>();
        sortedList.addAll(list);
        Collections.sort(sortedList, parameter);
        return sortedList;
    }

    /**
     * Sorts the service orders by service start time.
     *
     * @param list service order's list to sort
     * @return sorted service order's list
     */
    public static List<ServiceOrder> sortServiceOrdersByTime(List<ServiceOrder> list) {
        Comparator<ServiceOrder> parameter = new Comparator<ServiceOrder>() {
            @Override
            public int compare(ServiceOrder serv1, ServiceOrder serv2) {
                return serv1.getTimeService().compareTo(serv2.getTimeService());
            }
        };
        List<ServiceOrder> sortedList = new ArrayList<>();
        sortedList.addAll(list);
        Collections.sort(sortedList, parameter);
        return sortedList;
    }

    /**
     * Sorts the service orders by type of service.
     *
     * @param list service orders's list to sort
     * @return sorted service order's list
     */
    public static List<ServiceOrder> sortServiceOrdersByTypeService(List<ServiceOrder> list) {
        Comparator<ServiceOrder> parameter = new Comparator<ServiceOrder>() {
            @Override
            public int compare(ServiceOrder serv1, ServiceOrder serv2) {
                return serv1.getServiceType().compareToIgnoreCase(serv2.getServiceType());
            }
        };
        List<ServiceOrder> sortedList = new ArrayList<>();
        sortedList.addAll(list);
        Collections.sort(sortedList, parameter);
        return sortedList;
    }

    /**
     * Sorts the service orders by client's address.
     *
     * @param list service orders's list to sort
     * @return sorted service order's list
     */
    public static List<ServiceOrder> sortServiceOrdersByClientAddress(List<ServiceOrder> list) {
        Comparator<ServiceOrder> parameter = new Comparator<ServiceOrder>() {
            @Override
            public int compare(ServiceOrder serv1, ServiceOrder serv2) {
                return serv1.getClientPostalAddress().getAddress().compareToIgnoreCase(serv2.getClientPostalAddress().getAddress());
            }
        };
        List<ServiceOrder> sortedList = new ArrayList<>();
        sortedList.addAll(list);
        Collections.sort(sortedList, parameter);
        return sortedList;
    }
}
