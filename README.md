# Custom-Data-Piepline-in-Java
This project illustrates how to inject class rules while writing Data/Workflow pipeline in Java.

### Usage: Data Pipeline 1
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
