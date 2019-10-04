/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worktest;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import XcdCliCommands.XcdCliCommands;
import XcdCliCommands.XcdCliCommands.dpErrorEvents;

/**
 *
 * @author slazur
 */
enum FirstOctet {
    BCM_SWITCH_EVENT_UNKNOWN(7),
    BCM_SWITCH_EVENT_IO_ERROR(6),
    BCM_SWITCH_EVENT_PARITY_ERROR(5),
    BCM_SWITCH_EVENT_THREAD_ERROR(4),
    BCM_SWITCH_EVENT_ACCESS_ERROR(3),
    BCM_SWITCH_EVENT_ASSERT_ERROR(2),
    BCM_SWITCH_EVENT_MODID_CHANGE(1),
    BCM_SWITCH_EVENT_DOS_ATTACK(0);

    FirstOctet(int value) {
        this.value = value;
    }

    private int value;
}

enum FourthOctet {
    BCM_SWITCH_EVENT_UNKNOWN(7),
    SOC_SWITCH_EVENT_DATA_ERROR_PARITY(6),
    SOC_SWITCH_EVENT_DATA_ERROR_ECC(5),
    SOC_SWITCH_EVENT_DATA_ERROR_UNSPECIFIED(4),
    SOC_SWITCH_EVENT_DATA_ERROR_FATAL(3),
    SOC_SWITCH_EVENT_DATA_ERROR_CORRECTED(2),
    SOC_SWITCH_EVENT_DATA_ERROR_LOG(1),
    SOC_SWITCH_EVENT_DATA_ERROR_UNCORRECTABLE(0);

    FourthOctet(int value) {
        this.value = value;
    }

    private int value;

}

public class WorkTest {

    final static String hexString = "20 00 00 7f fc";
    final static byte test1 = 0b0101_0010;
    final static Byte ob1 = Byte.valueOf(test1);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final String log = "2019-09-24T13:32:15.337+00:00 err dperr: dperrcounter_cb: event=4 (ACCESS_ERROR) arg1=0 arg2=0, arg3=0\n" +
"2019-09-24T13:32:15.548+00:00 info dperr: simulate_bcm_event: simulating BCM event=5 (ASSERT_ERROR) arg1=0 arg2=0, arg3=0\n" +
"2019-09-24T13:32:15.548+00:00 err dperr: dperrcounter_cb: event=5 (ASSERT_ERROR) arg1=0 arg2=0, arg3=0\n" +
"2019-09-24T13:32:15.757+00:00 info dperr: simulate_bcm_event: simulating BCM event=1 (IO_ERROR) arg1=0 arg2=0, arg3=0\n" +
"2019-09-24T13:32:15.757+00:00 err dperr: dperrcounter_cb: event=1 (IO_ERROR) arg1=0 arg2=0, arg3=0\n" +
"2019-09-24T13:32:15.967+00:00 info dperr: simulate_bcm_event: simulating BCM event=2 (PARITY_ERROR) arg1=0 arg2=0, arg3=0\n" +
"2019-09-24T13:32:16.175+00:00 info dperr: simulate_bcm_event: simulating BCM event=3 (THREAD_ERROR) arg1=0 arg2=0, arg3=0\n" +
"2019-09-24T13:32:16.175+00:00 err dperr: dperrcounter_cb: event=3 (THREAD_ERROR) arg1=0 arg2=0, arg3=0\n" +
"2019-09-24T13:33:05.695+00:00 err dperr: genDPErrCounter=0 Severity=0 Parity=0 TFCS=0 all_events=11 bitmap='7C 00 00 86 B8'\n" +
"2019-09-24T13:34:58.213+00:00 info sntp 4.2.8p12@1.3728 Fri Sep 13 21:28:31 UTC 2019 (2)\n" +
"2019-09-24T13:34:59.578+00:00 info 2019-09-24 13:34:58.216481 (+0000) +1.360193 +/- 0.947577 10.34.0.18 s3 no-leap\n" +
"2019-09-25T06:46:05.541+00:00 info dperr: simulate_bcm_event: simulating BCM event=2 (PARITY_ERROR) arg1=3 arg2=0, arg3=0\n" +
"2019-09-25T06:46:05.541+00:00 err dperr: dperrcounter_cb: event=2 (PARITY_ERROR) arg1=3 (UNSPECIFIED) arg2=0, arg3=0\n" +
"2019-09-25T06:46:08.986+00:00 info dperr: simulate_bcm_event: simulating BCM event=2 (PARITY_ERROR) arg1=5 arg2=0, arg3=0\n" +
"2019-09-25T06:46:12.103+00:00 info dperr: simulate_bcm_event: simulating BCM event=2 (PARITY_ERROR) arg1=8 arg2=0, arg3=0\n" +
                "2019-09-25T08:12:39.784+00:00 err dperr: genDPErrCounter=0 Severity=0 Parity=0 TFCS=5 all_events=11 bitmap='20 00 01 08 00'";
        final String bitstring = getBitmapFromLog(log);
        System.out.println("bitmap string = " + bitstring);
        Integer tfcsCounter = calculateTFCS(log);
        System.out.println(tfcsCounter.getClass());
        ArrayList<dpErrorEvents> expectedEventsList = new ArrayList<>();
        ArrayList<dpErrorEvents> eventsList = parseDperrBitMap(bitstring);

//        expectedEventsList.add(dpErrorEvents.BCM_SWITCH_EVENT_PARITY_ERROR);
//        expectedEventsList.add(dpErrorEvents.SOC_SWITCH_EVENT_DATA_ERROR_CORRECTED);
//        expectedEventsList.add(dpErrorEvents.SOC_SWITCH_EVENT_DATA_ERROR_PARITY);
//        expectedEventsList.add(dpErrorEvents.SOC_SWITCH_EVENT_DATA_ERROR_UNKNOWN);

        System.out.println("events: " + eventsList);
//        System.out.println("events: " + eventsList.contains(dpErrorEvents.SOC_SWITCH_EVENT_DATA_ERROR_CORRECTED));
//
//        System.out.println("events: function " + checkEventsConsystent(eventsList, expectedEventsList));
//        
//        System.out.println(calculateErrorsInLog(log));

    }

    static private int calculateErrorsInLog(String errlogs) {

        String prevLine = null;
        int errorsParityInLogNumber = 0;
        // Line example: 2018-10-06T11:13:52.543+00:00 err dperr: dperrcounter_cb: DATA_ERROR_PARITY(1)
        final Pattern p = Pattern.compile(
                "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}\\+\\d{2}:\\d{2}\\s+(?:err)\\s+(?:dperr:)\\s+(?:"
                + "dperrcounter_cb:)\\s+DATA_ERROR_(?:PARITY|ECC)\\(\\d+\\)");
        final Pattern pNew = Pattern.compile("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}\\+\\d{2}:\\d{2}\\s+err\\s+dperr: dperrcounter_cb:\\s+event=(\\d+)\\W+\\w+\\W\\s\\w+=\\d+\\s+(\\W+\\w+\\W)?");
      //newLine made by me =)
        final Pattern repeat = Pattern.compile(
                "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}\\+\\d{2}:\\d{2}\\s+(?:err)\\s+Last message '.*'"
                + " repeated (\\d+) times");
        for (String line : errlogs.split("\n")) {
            final Matcher m = pNew.matcher(line);
            if (m.find()) {
                System.out.println(line);
                errorsParityInLogNumber++;
            } else {
                final Matcher mr = repeat.matcher(line);
                if (mr.find()) {
                    System.out.println(mr.group(1));
                    if (prevLine != null && p.matcher(prevLine).find()) {
                        errorsParityInLogNumber += Integer.valueOf(mr.group(1));
                    }
                }
            }
            prevLine = line;
        }
        System.out.println("Total parity errors = " + errorsParityInLogNumber);
        return errorsParityInLogNumber;
    }

    static boolean checkEventsConsystent(ArrayList<dpErrorEvents> eventsList, ArrayList<dpErrorEvents> expectedEventsList) {
        boolean result = true;
        for (dpErrorEvents event : eventsList) {
            result &= expectedEventsList.contains(event);
        }
        return result;
    }

    static private ArrayList<dpErrorEvents> parseDperrBitMap(String bitmapString) {
        final String[] octetStrings = bitmapString.split(" ");
        ArrayList<dpErrorEvents> eventsList = new ArrayList<>();
        for (int octetnumber = 0; octetnumber < 5; octetnumber++) {
            byte octet = (byte) Integer.parseInt(octetStrings[octetnumber], 16);
            for (int bitNumber = 0; bitNumber < 8; bitNumber++) {
                if (checkBitOnPosition(octet, bitNumber)) {
                    eventsList.add(dpErrorEvents.getOutput("" + octetnumber + bitNumber));
                    System.out.println("event number - " + octetnumber + bitNumber);
                }
            }
        }
        return eventsList;
    }

    static Integer calculateTFCS(String log){
        String result = "";
        final Pattern p = Pattern.compile("TFCS=(\\d*)");
    	 for (String line : log.split("\n")) {
             final Matcher m = p.matcher(line);
             if (m.find()) {
                 System.out.println(line);
                 result = m.group(1);
             }
    	 }
        return Integer.parseInt(result);
    }
    
    static String getBitmapFromLog(String log){
        String result = "";
        final Pattern p = Pattern.compile("bitmap='([\\d\\sA-Fa-f]*)'");
    	 for (String line : log.split("\n")) {
             final Matcher m = p.matcher(line);
             if (m.find()) {
                 System.out.println(line);
                 result = m.group(1);
             }
    	 }
        return result;
    }
    static boolean checkBitOnPosition(byte event, int position) {
        boolean result = false;
//        byte local;
        event <<= 7 - position;
        event >>= 7;
        final byte local = (byte) event;
        if (local != 0) {
            result = true;
        }
        return result;
    }

//        byte test;
//        byte x = 3;
//        byte y;
//        int i;
//
//        for (String temp:hexString.split(" ")){
//           int fromString = Integer.parseInt(temp, 16);
//           byte tempByte = (byte) fromString;
//           System.out.println(Integer.toBinaryString(fromString));
//           System.out.println(Integer.toBinaryString(tempByte));
//        }        
//        i = x << 2; // сдвиг влево
//        y = (byte) (x << 7);
//        y = (byte) (x >> 7);// сдвиг влево с приведением
//        test = (byte) (test1 <<= 7);
//        
//        System.out.println("test  = " + test1);
//        System.out.println("test  = " + Integer.toBinaryString(test));
//        
//        test = (byte) (test1 >>= 7);
//        System.out.println("test  = " + checkBitOnPosition(test1, 1));
//        System.out.println("test  = " + test1);
//        System.out.println("test  = " + checkBitOnPosition(test1, 6));
//        System.out.println("test  = " + test1);
//        System.out.println("test  = " + Integer.valueOf(hexString, 0);
//        System.out.println("test  = " + Integer.toBinaryString(test));
}
