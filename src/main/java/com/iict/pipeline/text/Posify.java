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
public class Posify implements Actions {

    @Override
    public String ProcessText(String sourceText) {
        String result = "";
        for (CoreMap currentSentence : Global.NLP_PIPELINE.process(sourceText).get(CoreAnnotations.SentencesAnnotation.class)) {
            for (CoreLabel currentToken : currentSentence.get(CoreAnnotations.TokensAnnotation.class)) {
                final String word = currentToken.get(CoreAnnotations.TextAnnotation.class);
                final String pos = currentToken.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                result += System.lineSeparator() + word + Global.BACK_SLASH + pos + Global.WHITE_SPACE;
            }
        }
        return result;
    }
}
