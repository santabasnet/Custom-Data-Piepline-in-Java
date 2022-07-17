/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.iict.classreflect;

import com.iict.pipeline.global.App;
import com.iict.pipeline.global.CAS;
import com.iict.pipeline.text.Lemmafy;
import com.iict.pipeline.text.Posify;
import com.iict.pipeline.text.Sentencify;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class ProcessText {
    private static String SOURCE_STRING = "If you run the tagger without changing how much memory you give to Java,"
            + " you may run out of memory. This will be evident when the program terminates with an OutOfMemoryError." 
            + " Running from the command line, you need to supply a flag like -mx1g. The number 1g is just an example;"
            + " if you do not have that much memory available, use less so your computer doesn't start paging. For"
            + " running a tagger, -mx500m should be plenty; for training a complex tagger, you may need more memory."
            + " When running from within Eclipse, follow these instructions to increase the memory given to a program"
            + " being run from inside Eclipse. Increasing the amount of memory given to Eclipse itself won't help.";    
    
    public static void main(String[] args) throws Exception{
        
        CAS casObj = new CAS(SOURCE_STRING);
        App newApp = new App();
        
        newApp.ApplyNLP(Sentencify.class, casObj);
        newApp.ApplyNLP(Lemmafy.class, casObj);
        newApp.ApplyNLP(Posify.class, casObj);
        
        System.out.println("Output\n--------------------------------------------");
        System.out.println(newApp.GetOperation(Sentencify.class));
        
        System.out.println("\n--------------------------------------------");
        System.out.println(newApp.GetOperation(Lemmafy.class));
        
        System.out.println("\n--------------------------------------------");
        System.out.println(newApp.GetOperation(Posify.class));
        System.out.println();
        
    }
    
}
