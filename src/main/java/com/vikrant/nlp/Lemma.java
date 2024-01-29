package com.vikrant.nlp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class Lemma {
    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP= Pipeline.getPipeLine();
        String text="I am trying to learn new technologies";
        CoreDocument coreDocument=new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> coreLabelList=coreDocument.tokens();
        for (CoreLabel coreLabel :coreLabelList){
            String lemma=coreLabel.lemma();
            System.out.println(coreLabel.originalText() +"="+lemma);
        }



    }
}
