package chapter06.formatter;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

/**
 * use Registrar to register a formatter
 * @author mohan
 *
 */
public class MyFormatterRegistrar implements FormatterRegistrar {
	private String datePattern;

	public MyFormatterRegistrar(String datePattern) {
		super();
		this.datePattern = datePattern;
	}

	@Override
	public void registerFormatters(FormatterRegistry registry) {
		registry.addFormatter(new LocalDateFormatter(datePattern));
	}
	
}
