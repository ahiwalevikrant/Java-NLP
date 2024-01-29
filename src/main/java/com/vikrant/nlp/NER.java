package com.vikrant.nlp;


import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class NER {
    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP=Pipeline.getPipeLine();

        String text="Hey I am Vikrant  & I have Wife and her name is Trupti. " +"we both are living in Banglore.";

        CoreDocument coreDocument=new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> coreLabelList=coreDocument.tokens();
        for (CoreLabel coreLabel:coreLabelList){
            String ner=coreLabel.getString(CoreAnnotations.NamedEntityTagAnnotation.class);
            System.out.println(coreLabel.originalText()+"="+ner);
        }
    }
}
