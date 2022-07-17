/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.iict.pipeline.global;

import com.iict.pipeline.global.CAS;
import com.iict.pipeline.global.Operation;
import com.iict.pipeline.rule.R1;
import com.iict.pipeline.rule.R2;
import com.iict.pipeline.rule.R3;
import com.iict.pipeline.text.Lemmafy;
import com.iict.pipeline.text.Posify;
import com.iict.pipeline.text.Sentencify;

import java.lang.reflect.Method;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class App {

    private CAS currentCAS = null;

    public void Apply(Class cName, CAS casObj) throws Exception {
        this.currentCAS = casObj;
        if (cName == R1.class) {
            final Method cMethod = R1.class.getMethod("makeUpper", String.class);
            final String result = (String) cMethod.invoke(new R1(), casObj.GetMainText());
            this.currentCAS.UpdateCas(new Operation(R1.class.getName(), result));
        } else if (cName == R2.class) {
            final Method cMethod = R2.class.getMethod("makeLower", String.class);
            final String result = (String) cMethod.invoke(new R2(), casObj.GetMainText());
            this.currentCAS.UpdateCas(new Operation(R2.class.getName(), result));
        } else if (cName == R3.class) {
            final Method cMethod = R3.class.getMethod("makeInitCaps", String.class);
            final String result = (String) cMethod.invoke(new R3(), casObj.GetMainText());
            this.currentCAS.UpdateCas(new Operation(R3.class.getName(), result));
        } else {
            System.out.println("Else Case !");
        }
    }

    public void ApplyNLP(Class cName, CAS casObj) throws Exception {
        this.currentCAS = casObj;
        if (cName == Sentencify.class) {
            final Method cMethod = Sentencify.class.getMethod(GetMethodName(), String.class);
            final String result = (String) cMethod.invoke(new Sentencify(), casObj.GetMainText());
            this.currentCAS.UpdateCas(new Operation(Sentencify.class.getName(), result));
        } else if (cName == Lemmafy.class) {
            final Method cMethod = Lemmafy.class.getMethod(GetMethodName(), String.class);
            final String result = (String) cMethod.invoke(new Lemmafy(), casObj.GetMainText());
            this.currentCAS.UpdateCas(new Operation(Lemmafy.class.getName(), result));
        } else if (cName == Posify.class) {
            final Method cMethod = Posify.class.getMethod(GetMethodName(), String.class);
            final String result = (String) cMethod.invoke(new Posify(), casObj.GetMainText());
            this.currentCAS.UpdateCas(new Operation(Posify.class.getName(), result));
        } else {
            System.out.println("Else Case !");
        }
    }

    private String GetMethodName() {
        return "ProcessText";
    }

    public String GetOperation(Class cName) {
        return this.currentCAS.GetChanges(cName).toString();
    }
}
