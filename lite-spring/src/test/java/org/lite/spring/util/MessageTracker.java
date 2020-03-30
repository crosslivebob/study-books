package org.lite.spring.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bfq on 2020/3/27
 */
public class MessageTracker {

    private static List<String> MESSAGES = new ArrayList<String>();

    public static void clearMsgs() {
        MESSAGES.clear();
    }

    public static List<String> getMsgs() {
        return MESSAGES;
    }

    public static void addMsg(String msg) {
        MESSAGES.add(msg);
    }
}
