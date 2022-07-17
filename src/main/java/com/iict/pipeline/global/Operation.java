/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.iict.pipeline.global;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class Operation {
    String actionName;
    String currentValue;

    public Operation(String actionName, String currentValue) {
        this.actionName = actionName;
        this.currentValue = currentValue;
    }

    public String getActionName() {
        return actionName;
    }

    public String getCurrentValue() {
        return currentValue;
    }    

    @Override
    public String toString() {
        return "Operation{" + "actionName = " + actionName + ", currentValue = " + currentValue + '}';
    }
    
    
}
