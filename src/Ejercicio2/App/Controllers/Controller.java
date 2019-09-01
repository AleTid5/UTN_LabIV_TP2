package Ejercicio2.App.Controllers;

public class Controller {
	protected static void assertOrFail(Boolean comparison, Exception ex) throws Exception {
		if (! comparison) throw ex;
	}
}
