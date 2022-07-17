/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.iict.pipeline.rule;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class R3 {

    public String makeInitCaps(String source) {
        String result = "";
        for (String cStr : source.toLowerCase().split(" ")) {
            result += Character.toUpperCase(cStr.charAt(0)) + cStr.substring(1) + " ";
        }
        return result.trim();
    }
}
