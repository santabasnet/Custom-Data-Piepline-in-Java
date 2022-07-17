/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.iict.pipeline.global;

import com.iict.pipeline.global.Operation;

import java.util.ArrayList;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class CAS {

    String mainText;
    ArrayList<Operation> listOfOperation;

    public CAS(String mainText) {
        init(mainText);
    }

    public void SetMainText(String mainText) {
        init(mainText);
    }

    public void UpdateCas(Operation cOperation) {
        listOfOperation.add(cOperation);
    }

    public Object GetChanges(Class cName) {
        for (Operation ope : listOfOperation) {
            if (ope.getActionName().equals(cName.getName())) {
                return ope;
            }
        }
        return "";
    }

    public String GetMainText() {
        return this.mainText;
    }

    private void init(String mainText) {
        this.mainText = mainText;
        this.listOfOperation = new ArrayList<>();
    }
}
