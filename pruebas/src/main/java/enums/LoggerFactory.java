package enums;

public final class LoggerFactory {

	public static ILogger getLoggerFromEnum(LoggersEnum loggerEnum) throws RuntimeException {
		
		if (loggerEnum == null) {
			throw new RuntimeException("Debe indicar un ENUM valido");
		}
		
		if (loggerEnum == LoggersEnum.FS) {
			return new FSLogger();
		} else {
			return new ConsoleLogger();
		}
		
	}
	
}
