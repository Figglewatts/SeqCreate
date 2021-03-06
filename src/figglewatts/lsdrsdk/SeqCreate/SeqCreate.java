package figglewatts.lsdrsdk.SeqCreate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import figglewatts.lsdrsdk.SeqCreate.datatypes.Sequence;
import figglewatts.lsdrsdk.SeqCreate.datatypes.SequenceData;

public class SeqCreate {

	public static void main(String[] args) throws IOException {
		System.out.println("SeqCreate - Created by Figglewatts, 2014");
		System.out.println("For use with LSD: Revamped SDK");
		
		// create writer to write to a json file
		try (Writer writer = new OutputStreamWriter(new FileOutputStream(".\\output.json"), "UTF-8")) {
			// create instance of gson
			Gson gson = new GsonBuilder().create();
			
			Sequence sequence = new Sequence();
			SequenceData sequenceData = new SequenceData();
			sequence.setData(sequenceData);
			
			for (String arg : args) {
				System.out.println(arg);
				sequenceData.AddSequence(arg);
			}
			
			gson.toJson(sequence, writer);
			writer.close();
		}
	}

}
