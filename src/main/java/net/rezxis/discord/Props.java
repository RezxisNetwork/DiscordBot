package net.rezxis.discord;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.Properties;

public class Props {

	public final String TOKEN;
	public final String SYNC_ADDRESS;
	public final int SYNC_PORT;
	public final String DB_HOST;
	public final int DB_PORT;
	public final String DB_PASS;
	public final String DB_USER;
	public final String DB_NAME;
	
	final Properties prop=new Properties();
	public Props(String fname) {
        InputStream istream;
		try {
			ProtectionDomain pd = this.getClass().getProtectionDomain();
			CodeSource cs = pd.getCodeSource();
			URL location = cs.getLocation();
			URI uri = location.toURI();
			Path path = Paths.get(uri);


			istream = new FileInputStream(new File(new File(""+path).getParent(),fname));
	        prop.load(istream);
		} catch (Exception e) {
			e.printStackTrace();
		}
        this.TOKEN = prop.getProperty("TOKEN");
        this.SYNC_ADDRESS = prop.getProperty("SYNC_ADDRESS");
        this.SYNC_PORT = Integer.valueOf(prop.getProperty("SYNC_PORT"));
        this.DB_HOST = prop.getProperty("DB_HOST");
        this.DB_PORT = Integer.valueOf(prop.getProperty("DB_PORT"));
        this.DB_USER = prop.getProperty("DB_USER");
        this.DB_PASS = prop.getProperty("DB_PASS");
        this.DB_NAME = prop.getProperty("DB_NAME");
	}
}