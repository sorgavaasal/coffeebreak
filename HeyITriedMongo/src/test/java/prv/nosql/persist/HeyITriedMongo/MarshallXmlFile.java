package prv.nosql.persist.HeyITriedMongo;

import java.io.File;
import java.util.List;

import javax.sql.DataSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.fhir.error.dto.RESULTS;

public class MarshallXmlFile {

	private static final String fileLocation = "/Users/sridharramanadmin/Downloads/fhir-error-repo-QA-Download.xml";
	
	private static final String insertSql = "INSERT INTO FHIR_ERROR_REPO (ERR_CODE,ERR_MSG,ERR_SEVERITY,ERR_ORIGIN,CREATED_DATETIME,ERR_REQUEST,ERR_STAT) VALUES (";
	
	private static DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
		ds.setUrl("jdbc:oracle:thin:@haa-ora-119:1521/CCDADV");
		ds.setUsername("ccdafetch");
		ds.setPassword("welcome");
		return ds;
	}

	private static void insertIntoFhirErrorRepo() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance("com.fhir.error.dto");
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		//@SuppressWarnings("unchecked")
		RESULTS results =  (RESULTS) unmarshaller.unmarshal(new File(fileLocation));
		results.getROW().stream().forEach(row -> row.getCOLUMN().stream().forEach(column -> System.out
				.println("columnName===> " + column.getNAME() + " columnValue===> " + column.getValue())));
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		
		List<RESULTS.ROW> rowStream = results.getROW();
		
		for (RESULTS.ROW row : rowStream) {
			List<RESULTS.ROW.COLUMN> columnStream = row.getCOLUMN();
			StringBuilder insertSqlStr = new StringBuilder(insertSql);
			for (RESULTS.ROW.COLUMN column: columnStream) {
				if (column.getNAME().equals("ERR_ID"))
					break;
				insertSqlStr.append("'");
				insertSqlStr.append(column.getValue());
				if (!"ERR_STAT".equals(column.getNAME())) {
					insertSqlStr.append("',");
				}
				else {
					insertSqlStr.append("'");
				}
			}
			insertSqlStr.append(")");
			System.out.println(insertSqlStr);
			jdbcTemplate.update(insertSqlStr.toString());
			insertSqlStr.setLength(0);
		}
	}

	public static void main(String[] args) throws JAXBException {
		insertIntoFhirErrorRepo();
	}

}
