package com.vikrant.nlp;


import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class SentenceRecognizer {
    public static void main(String[] args) {
       StanfordCoreNLP stanfordCoreNLP= Pipeline.getPipeLine();
     String text="Hey ! I am Vikrant Ahiwale. I'm a software Developer.";

        CoreDocument coreDocument=new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreSentence> sentences =coreDocument.sentences();
        for (CoreSentence sentence: sentences){
            System.out.println(sentence.toString());
        }
    }

}
