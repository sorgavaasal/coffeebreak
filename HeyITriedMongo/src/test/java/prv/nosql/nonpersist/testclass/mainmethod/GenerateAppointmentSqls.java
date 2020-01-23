package prv.nosql.nonpersist.testclass.mainmethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GenerateAppointmentSqls {
	
	//private static final List<String> mrnList = Arrays.asList("5000305067", "5000311180", "5000311179", "5000601978",
	//		"5000602242", "5000602044", "5000313429", "5000603838");
	private static final List<String> mrnList = Arrays.asList("5000552632", "5000552634", "5000552635", "5000552639",
			"5000552643", "5000552641", "5000552636", "5000552637");

	private static final String[] sqlContent = {"insert into appointments(mrn,appt_datetime,appt_status,created_date, created_by) values (", 
			",'NEW',to_date(to_char(sysdate,'dd/mon/yyyy hh24:mi:ss'), 'dd/mm/yyyy hh24:mi:ss'),'CCDA-INITIATING GTWAY');"
	};
	
	private static final int recordLimit = 1040;
	
	public static void main(String[] args) throws IOException {
		List<String> outputLines = new ArrayList<>();
		Format dateFormat = new SimpleDateFormat("dd-MMM-yy");
		Calendar apptDate = Calendar.getInstance();
		apptDate.setTimeInMillis(new Date().getTime());
		
		while (outputLines.size() < recordLimit) {
			apptDate.add(Calendar.DAY_OF_YEAR, 1);
			for (String mrn : mrnList) {
				StringBuilder sb = new StringBuilder(sqlContent[0]);
				sb.append("'").append(mrn).append("'").append(",");
				sb.append("'").append(dateFormat.format(apptDate.getTime()).toUpperCase()).append("'");
				sb.append(sqlContent[1]);
				//sb.append("\n");
				outputLines.add(sb.toString());
			}		
		}
		Files.write(Paths.get("/Users/sridharramanadmin/Downloads/trialAndErrorSpace/coffeebreak/HeyITriedMongo/src/test/resources/sampleAppointmentsOutputFile"), (Iterable<String>)outputLines);
	}

}
