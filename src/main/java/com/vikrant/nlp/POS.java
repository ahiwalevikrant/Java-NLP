package com.vikrant.nlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class POS {
    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP =Pipeline.getPipeLine();
        String text="Hey.! I'm Vikrant Ahiwale";

        CoreDocument coreDocument=new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
          List< CoreLabel> coreLabels =coreDocument.tokens();
          for (CoreLabel coreLabel:coreLabels){
               String pos=coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
              System.out.println(coreLabel.originalText()+"="+pos);
          }

    }

}
