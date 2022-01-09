package ar.com.educacionit.domain;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import ar.com.educacionit.services.impl.SociosServiceImpl;

public class MainCuenta {
	
	public static void main(String[] args) throws Exception {
		
		//quiero tomar una clase .class y setear los datos(atributos)
		// dentro de una template
		
		Cuenta miCuenta = new Cuenta(100l, "Caja de Ahorros", 150000f);
		
		//construir un string que tenga
		// Cuenta = atributo = valor| atributo2 = valor|
		String template = buildTemplate(miCuenta);
		System.out.println(template);
		
		Socios socios = new SociosServiceImpl().getOne(1l);
		template = buildTemplate(socios);
		System.out.println(template);
		
		Categorias cat = new Categorias();
		cat.setCodigo("100");
		cat.setDescripcion("desc100");
		cat.setId(100l);
		template = buildTemplateMethod(cat);
		System.out.println(template);
	}
	
	public static String buildTemplateMethod(Object data) throws Exception {
		
		
		Class clazz = data.getClass();
		
		String className = clazz.getSimpleName();
		StringBuffer template = new StringBuffer(className);
		
		template.append(" = {");
		//tomo los atributos de class
		Method[] methods = clazz.getDeclaredMethods();
		
		for (Method method : methods) {
			method.setAccessible(true);// permitir acceder al atributos private
			String name = method.getName(); //nombre del atributo
			Object value = null;
			if (name.startsWith("get")) {
				value = method.invoke(data);
				template.append(name).append("=");
				if (value != null) {
					template.append(value.toString());
				} else {
					template.append("null");
				}
				template.append(" | ");
			}
			
			/*Object value = field.invoke(data);*/
			
		}
		
		template.append("}");
		
		return template.toString();
	}
	
	public static String buildTemplate(Object data) throws Exception {
		
		
		Class clazz = data.getClass();
		
		String className = clazz.getSimpleName();
		StringBuffer template = new StringBuffer(className);
		
		template.append(" = {");
		//tomo los atributos de class
		Field[] fields = clazz.getDeclaredFields();
		
		for (Field field : fields) {
			field.setAccessible(true);// permitir acceder al atributos private
			String name = field.getName(); //nombre del atributo
			Object value = field.get(data);
			
			template.append(name).append("=");
			if (value != null) {
				template.append(value.toString());
			} else {
				template.append("null");
			}
			template.append(" | ");
		}
		
		template.append("}");
		
		return template.toString();
	}
	
}
