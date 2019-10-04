/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XcdCliCommands;

/**
 * A common command utility class for the XCD CLI
 * 
 * @author xserlaz
 */
public final class XcdCliCommands {

    public static final String XCDCLI = "xcdcli ";
    public static final String DPERR_EVENT = "dperr b ";
    public static final String DPERR_ERACE_BITMAP = "dperr e ";
    public static final String DPERR_TFCS_COUNTER = "dperr t ";
    public static final String DPERR_SHOW = "dperr s";

    /**
     * Enumerator which represents BCM events
     */
    public static enum dpErrorEvents {
    	BCM_SWITCH_EVENT_UNKNOWN("0 0 0 0" , "07"),
        BCM_SWITCH_EVENT_IO_ERROR("1 0 0 0" , "06"),
        BCM_SWITCH_EVENT_PARITY_ERROR("2 0 0 0", "05"),
        BCM_SWITCH_EVENT_THREAD_ERROR("3 0 0 0", "04"),
        BCM_SWITCH_EVENT_ACCESS_ERROR("4 0 0 0", "03"),
        BCM_SWITCH_EVENT_ASSERT_ERROR("5 0 0 0", "02"),
        
        TFCS("", "20"),
        
        SOC_SWITCH_EVENT_DATA_ERROR_UNKNOWN("2 0 0 0" , "37"),
        SOC_SWITCH_EVENT_DATA_ERROR_PARITY("2 1 0 0", "36"),
        SOC_SWITCH_EVENT_DATA_ERROR_ECC("2 2 0 0", "35"),
        SOC_SWITCH_EVENT_DATA_ERROR_UNSPECIFIED("2 3 0 0","34"),
        SOC_SWITCH_EVENT_DATA_ERROR_FATAL("2 4 0 0", "33"),
        SOC_SWITCH_EVENT_DATA_ERROR_CORRECTED("2 5 0 0", "32"),
        SOC_SWITCH_EVENT_DATA_ERROR_LOG("2 6 0 0", "31"),
        SOC_SWITCH_EVENT_DATA_ERROR_UNCORRECTABLE("2 7 0 0", "30"),
        
        SOC_SWITCH_EVENT_DATA_ERROR_AUTO_CORRECTED("2 8 0 0", "47"),
        SOC_SWITCH_EVENT_DATA_ERROR_FAILEDTOCORRECT("2 9 0 0", "46"),
        SOC_SWITCH_EVENT_DATA_ERROR_ECC_1BIT_CORRECTED("2 10 0 0", "45"),
        SOC_SWITCH_EVENT_DATA_ERROR_ECC_2BIT_CORRECTED("2 11 0 0", "44"),
        SOC_SWITCH_EVENT_DATA_ERROR_PARITY_CORRECTED("2 12 0 0", "43"),
        SOC_SWITCH_EVENT_DATA_ERROR_CFAP_MEM_FAIL("2 13 0 0", "42");

        private final String emulateValue;
        private final String bitmapNumber;

        /**
         * Creates {@code dpErrorEvent} instance
         * 
         * @param name Name of BCM event
         */
        dpErrorEvents(String event, String bitmapNumber) {
        	emulateValue = event;
            this.bitmapNumber = bitmapNumber;
        }
        
        public static dpErrorEvents getOutput(String output) {
        	dpErrorEvents result = BCM_SWITCH_EVENT_UNKNOWN;
            for (final dpErrorEvents error : dpErrorEvents.values()) {
                if (error.bitmapNumber.contains(output)) {
                	result = error;
                    break;
                }
            }
            return result;
        }

        @Override
        public String toString() {
            return name();
        }
    }

    /**
     * A private empty constructor
     */
    private XcdCliCommands() {}

    /**
     * Gets 'dperr b' command
     * 
     * @param event dperror event
     * @return String command
     */
    public static String getDperrEventCommand(dpErrorEvents event) {
        return XCDCLI + DPERR_EVENT + event.toString();
    }

    /**
     * Gets 'dperr e' command
     * 
     * @return String command
     */
    public static String getDperrEraseBitmapCommand() {
        return XCDCLI + DPERR_ERACE_BITMAP;
    }

    /**
     * Gets 'dperr t' command
     * 
     * @param counter int counter
     * @return String command
     */
    public static String getDperrTFCSCommand(int counter) {
        return XCDCLI + DPERR_TFCS_COUNTER + counter;
    }
    
    public static String getDperrShowCommand(){
    	return XCDCLI + DPERR_SHOW;
    }

}

