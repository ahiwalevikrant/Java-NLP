package com.vikrant.AssembliAI;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.assemblyai.api.AssemblyAI;
import com.assemblyai.api.resources.lemur.requests.LemurTaskParams;
import com.assemblyai.api.resources.lemur.types.LemurTaskResponse;
import com.assemblyai.api.resources.transcripts.types.Transcript;
import com.assemblyai.api.resources.transcripts.types.TranscriptOptionalParams;

public class AI {
    	
//	 public static void main(String[] args) {
//	        AssemblyAI client = AssemblyAI.builder()
//	                .apiKey("" )
//	                .build();
//
//	        String url = "";
//
//	        TranscriptOptionalParams params = TranscriptOptionalParams.builder()
//	                .speakerLabels(true)
//	                .build();
//
//	        Transcript transcript = client.transcripts().transcribe(url, params);
//
//	        System.out.println(transcript.getText());
//
//	        transcript.getUtterances().ifPresent(utterances ->
//	            utterances.forEach(utterance ->
//	                System.out.println("Speaker " + utterance.getSpeaker() + ": " + utterance.getText())
//	            )
//	        );
//	    }
	
	 public static void main(String[] args) throws Exception {
        AssemblyAI client = AssemblyAI.builder()
                .apiKey("")
                .build();

        // Replace this with the actual path to your local audio file
        String filePath = "C:/Users/vikrant.ahiwale/Downloads/20240129-100427_4042467238-all 1.mp3";

        Path audioFilePath = Paths.get(filePath);

        // Step 1: Transcribe an audio file.
        Transcript transcript = transcribeAudio(client, audioFilePath);

        // Step 2: Apply LeMUR.
        String prompt = "Provide a brief summary of the transcript.";

        LemurTaskParams lemurParams = LemurTaskParams.builder()
                .prompt(prompt)
                .transcriptIds(List.of(transcript.getId()))
                .build();

        LemurTaskResponse lemurResponse = client.lemur().task(lemurParams);

        System.out.println(lemurResponse.getResponse());
    }

    private static Transcript transcribeAudio(AssemblyAI client, Path audioFilePath) throws Exception {
        try {
            TranscriptOptionalParams params = TranscriptOptionalParams.builder()
                    .speakerLabels(true)
                    .build();

            return client.transcripts().transcribe(audioFilePath.toFile(), params);
        } finally {
            // Clean up: delete the temporary file
            Files.deleteIfExists(audioFilePath);
        }
    }
   
}
