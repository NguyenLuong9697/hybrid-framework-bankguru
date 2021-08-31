package common;

import java.io.File;

public class GlobalConstants {
	public static final String PROJECT_PATH=System.getProperty("user.dir");
	public static final String SEPERATOR=File.separator;
	public static final String UPLOAD_FOLDER_PATH= PROJECT_PATH+ SEPERATOR+"uploadFiles"+SEPERATOR;
	public static final int SHORT_TIMEOUT=5;
	public static final int LONG_TIMEOUT=30;
}
