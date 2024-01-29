package com.vikrant.nlp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class Tokenize {
    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP =Pipeline.getPipeLine();
        String text="Hey ! THis is Vikrant Ahiwale";

        CoreDocument coreDocument=new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);

        List<CoreLabel>coreLabelList =coreDocument.tokens();
        for (CoreLabel coreLabel : coreLabelList){
            System.out.println(coreLabel.originalText());
        }
    }
}
