package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empleado.Empleado;
import empleado.Empleado.TipoEmpleado;

class EmpleadoTest {

	Empleado vendedor;
	Empleado encargado;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		encargado = new Empleado(TipoEmpleado.Encargado);
		encargado.setSalarioBase(2500);

		vendedor = new Empleado(TipoEmpleado.Vendedor);
		vendedor.setSalarioBase(2000);

	}

//	@AfterEach
//	void tearDown() throws Exception {
//	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Test
	void salarioBaseTest() {
		assertEquals(2000, vendedor.getSalarioBase());
		assertEquals(2500, encargado.getSalarioBase());
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

	void calculoNominaBrutaHorasExtrasTest() {

//		10 horas extras
		assertEquals(2300, vendedor.calculoNominaBruta(TipoEmpleado.Vendedor, 0, 10));
		assertEquals(2800, encargado.calculoNominaBruta(TipoEmpleado.Encargado, 0, 10));

//		horas negativas (queda igual)
		assertEquals(2000, vendedor.calculoNominaBruta(TipoEmpleado.Vendedor, 0, -10));
		assertEquals(2500, encargado.calculoNominaBruta(TipoEmpleado.Encargado, 0, -10));

	}

	void calculoNominaBrutaTest() {
//		Prueba de horas extra y primas a la vez
		assertEquals(2400, vendedor.calculoNominaBruta(TipoEmpleado.Vendedor, 1000, 10));
		assertEquals(3100, encargado.calculoNominaBruta(TipoEmpleado.Encargado, 999, 20));
		
//		valores negativos
		assertEquals(2000, vendedor.calculoNominaBruta(TipoEmpleado.Vendedor, -10, -120));
		assertEquals(2500, encargado.calculoNominaBruta(TipoEmpleado.Encargado, -30, -50));
		
	}

}
