/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.iict.classreflect;

import com.iict.pipeline.global.App;
import com.iict.pipeline.global.CAS;
import com.iict.pipeline.rule.R1;
import com.iict.pipeline.rule.R2;
import com.iict.pipeline.rule.R3;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class TextRules {
    
    private static String TMP_STRING = "heLLo World !";

    
    public static void main(String[] args) throws Exception{
        
        CAS casObj = new CAS(TMP_STRING);
        App newApp = new App();
        
        newApp.Apply(R1.class, casObj);
        newApp.Apply(R2.class, casObj);
        newApp.Apply(R3.class, casObj);
        
        System.out.println("Output\n--------------------------------------------");
        System.out.println(newApp.GetOperation(R1.class));
        
        System.out.println("--------------------------------------------");
        System.out.println(newApp.GetOperation(R2.class));
        
        System.out.println("--------------------------------------------");
        System.out.println(newApp.GetOperation(R3.class));
        System.out.println();
        
    }
    
}
