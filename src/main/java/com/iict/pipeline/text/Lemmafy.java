/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.iict.pipeline.text;

import com.iict.pipeline.global.Global;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.util.CoreMap;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class Lemmafy implements Actions {

    @Override
    public String ProcessText(String sourceText) {
        String result = "";
        for (CoreMap currentSentence : Global.NLP_PIPELINE.process(sourceText).get(CoreAnnotations.SentencesAnnotation.class)) {
            for (CoreLabel currentToken : currentSentence.get(CoreAnnotations.TokensAnnotation.class)) {
                result += System.lineSeparator() + currentToken.originalText() + Global.UNDER_SCORE + currentToken.get(CoreAnnotations.LemmaAnnotation.class) + Global.WHITE_SPACE;
            }
        }
        return result;
    }

}
