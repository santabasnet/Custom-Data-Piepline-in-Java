/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.iict.pipeline.global;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.Properties;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class Global {

    private static final String ANNOTATORS = "annotators";
    private static final String ANNOTATION_TYPES = "tokenize, ssplit, pos, lemma";

    public static final StanfordCoreNLP NLP_PIPELINE = InitNlp();

    private static StanfordCoreNLP InitNlp() {
        Properties actionsProperty = new Properties();
        actionsProperty.put(ANNOTATORS, ANNOTATION_TYPES);
        return new StanfordCoreNLP(actionsProperty);
    }

    /**
     * Global Variables
     */
    public static final String WHITE_SPACE = " ";
    public static final String UNDER_SCORE = "_";
    public static final String BACK_SLASH = "/";
    public static final String SENTENCE_BEGIN = "<S>";
    public static final String SENTENCE_END = "</S>";
}
