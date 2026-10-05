package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empleado.Empleado;
import empleado.Empleado.TipoEmpleado;

class EmpleadoTest {

	Empleado vendedor;
	Empleado encargado;

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		encargado = new Empleado();
		vendedor = new Empleado();

	}

	@Test
	void calculoNominaBrutaPrimasTest() {
//------------------ Ventas --------------------		
//		<1000 ventas 
		assertEquals(2000, vendedor.calculoNominaBruta(TipoEmpleado.Vendedor, -10, 0));
		assertEquals(2500, encargado.calculoNominaBruta(TipoEmpleado.Encargado, -10, 0));

		assertEquals(2000, vendedor.calculoNominaBruta(TipoEmpleado.Vendedor, 0, 0));
		assertEquals(2500, encargado.calculoNominaBruta(TipoEmpleado.Encargado, 0, 0));

		assertEquals(2000, vendedor.calculoNominaBruta(TipoEmpleado.Vendedor, 999, 0));
		assertEquals(2500, encargado.calculoNominaBruta(TipoEmpleado.Encargado, 999, 0));

//		[1000,1499] ventas
		assertEquals(2100, vendedor.calculoNominaBruta(TipoEmpleado.Vendedor, 1000, 0));
		assertEquals(2600, encargado.calculoNominaBruta(TipoEmpleado.Encargado, 1000, 0));

		assertEquals(2100, vendedor.calculoNominaBruta(TipoEmpleado.Vendedor, 1499, 0));
		assertEquals(2600, encargado.calculoNominaBruta(TipoEmpleado.Encargado, 1499, 0));

//		>=1500 ventas
		assertEquals(2200, vendedor.calculoNominaBruta(TipoEmpleado.Vendedor, 1500, 0));
		assertEquals(2700, encargado.calculoNominaBruta(TipoEmpleado.Encargado, 1500, 0));

		assertEquals(2200, vendedor.calculoNominaBruta(TipoEmpleado.Vendedor, 3000, 0));
		assertEquals(2700, encargado.calculoNominaBruta(TipoEmpleado.Encargado, 3000, 0));

	}

	@Test
	void calculoNominaBrutaHorasExtrasTest() {

//		10 horas extras
		assertEquals(2300, vendedor.calculoNominaBruta(TipoEmpleado.Vendedor, 0, 10));
		assertEquals(2800, encargado.calculoNominaBruta(TipoEmpleado.Encargado, 0, 10));

//		horas negativas (queda igual)
		assertEquals(2000, vendedor.calculoNominaBruta(TipoEmpleado.Vendedor, 0, -10));
		assertEquals(2500, encargado.calculoNominaBruta(TipoEmpleado.Encargado, 0, -10));

	}

	@Test
	void calculoNominaBrutaTest() {
//		Prueba de horas extra y primas a la vez
		assertEquals(2400, vendedor.calculoNominaBruta(TipoEmpleado.Vendedor, 1000, 10));
		assertEquals(3100, encargado.calculoNominaBruta(TipoEmpleado.Encargado, 999, 20));

//		valores negativos
		assertEquals(2000, vendedor.calculoNominaBruta(TipoEmpleado.Vendedor, -10, -120));
		assertEquals(2500, encargado.calculoNominaBruta(TipoEmpleado.Encargado, -30, -50));

	}

	@Test
	void calculoNominaNetaTest() {
//		limite inferior
		assertEquals(-1000, vendedor.calculoNominaNeta(-1000));
		assertEquals(2000, vendedor.calculoNominaNeta(2000));
		
//		[2100, 2499]
		assertEquals(1785, vendedor.calculoNominaNeta(2100));
//		Es necesario indicar la "precision" al usar float o double para que acepte X decimales de "error"
		assertEquals(2124.15f , vendedor.calculoNominaNeta(2499), 0.001f);
		
//		>= 2500
		assertEquals(2050f, vendedor.calculoNominaNeta(2500));
		assertEquals(4100, vendedor.calculoNominaNeta(5000));
		
	
	}

}
