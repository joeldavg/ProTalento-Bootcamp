package enums;

import java.util.Scanner;

public class LoggerMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese una opcion (FS/CONSOLE)");
		
		LoggersEnum fsEnum = LoggersEnum.getEnumFromString(sc.next());
		
		ILogger logger = LoggerFactory.getLoggerFromEnum(fsEnum);
		
		logger.loguear();
		
		sc.close();
	}
	
}
