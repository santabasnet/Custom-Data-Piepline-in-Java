# Custom-Data-Piepline-in-Java
This project illustrates how to inject class rules while writing Data/Workflow pipeline in Java. I utilize the Java reflections for dependency injection.

### Usage: Data Pipeline 1
-----
It transforms given text with three rules R1, R2 and R2. R1 transforms the text to upper case, R2 transforms the text to lowercase and finally R3 transforms the text in init-caps.

-----
```Java
        private static String TMP_STRING = "heLLo World !";

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

```

### Usage: Data Pipeline 2
-----
This pipeline transforms the given text through three phases (I used Stanford NLP library for text transformation.):
* Sentencify: It splits the text into the available sentenences. 
* Lemmafy: It attaches lemma to the words.
* Posify: It tags all the Parts of Speech(POS) of the words in the sentences.
Finally displays the output of every steps in the pipeline.

-----
```Java
        private static String SOURCE_STRING = "If you run the tagger without changing how much memory you give to Java,"
            + " you may run out of memory. This will be evident when the program terminates with an OutOfMemoryError." 
            + " Running from the command line, you need to supply a flag like -mx1g. The number 1g is just an example;"
            + " if you do not have that much memory available, use less so your computer doesn't start paging. For"
            + " running a tagger, -mx500m should be plenty; for training a complex tagger, you may need more memory."
            + " When running from within Eclipse, follow these instructions to increase the memory given to a program"
            + " being run from inside Eclipse. Increasing the amount of memory given to Eclipse itself won't help."; 
    
    
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
    
```
