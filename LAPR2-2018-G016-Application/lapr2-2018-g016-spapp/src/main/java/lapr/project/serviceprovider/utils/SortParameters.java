package lapr.project.serviceprovider.utils;

/**
 *
 * @author Diogo Ribeiro
 */
public enum SortParameters {

    /**
     * Parameters.
     */
    CLIENT_NAME {
        @Override
        public String toString() {
            return "Client's name";
        }
    },
    DISTANCE_ASCENDING {
        @Override
        public String toString() {
            return "Distance in ascending order";
        }
    },
    DISTANCE_DESCENDING {
        @Override
        public String toString() {
            return "Distance in descending order";
        }
    },
    SERVICE_CATEGORY {
        @Override
        public String toString() {
            return "Service category";
        }
    },
    SERVICE_START_DATE {
        @Override
        public String toString() {
            return "Service start date";
        }
    },
    SERVICE_START_TIME {
        @Override
        public String toString() {
            return "Service start time";
        }
    },
    TYPE_SERVICE {
        @Override
        public String toString() {
            return "Type of service";
        }
    },
    CLIENT_ADDRESS {
        @Override
        public String toString() {
            return "Client's address";
        }
    };

    /**
     * variable that represents the number of sort parameters.
     */
    public static final int NUMBER_SORT_PARAMETERS = 8;

    /**
     * Returns the name of the parameter whose order is received by parameter.
     *
     * @param sortParametersOrder the order of the sort parameters goes from
     * zero to seven.
     * @return sort parameters designation.
     */
    public static String sortParametersDesignation(int sortParametersOrder) {
        return SortParameters.values()[sortParametersOrder].toString();
    }
}
