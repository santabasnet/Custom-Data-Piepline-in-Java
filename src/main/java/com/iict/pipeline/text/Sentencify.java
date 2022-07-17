/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.iict.pipeline.text;

import com.iict.pipeline.global.Global;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.util.CoreMap;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class Sentencify implements Actions {
    @Override
    public String ProcessText(String sourceText) {
        String result = "";
        for (CoreMap currentSentence : Global.NLP_PIPELINE.process(sourceText).get(CoreAnnotations.SentencesAnnotation.class)) {
            result += System.lineSeparator() + Global.SENTENCE_BEGIN + currentSentence.toString() + Global.SENTENCE_END;
        }
        return result;
    }

}
