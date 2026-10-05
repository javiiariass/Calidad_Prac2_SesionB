package empleado;

public class Empleado {

	/// Precio de las horas extra
	private static final float PRECIO_HORAS_EXTRA = 30;

	/**
	 * Enum para los tipos de empleados posibles Cada empleado tiene su salario base
	 * asociado
	 */
	public enum TipoEmpleado {

		Vendedor(2000), Encargado(2500);

		private final float salarioBase;

		TipoEmpleado(float salario) {
			this.salarioBase = salario;
		}

		public float getSalarioBase() {
			return salarioBase;
		}
	}

	/**
	 * 
	 * @param ventasMes número de ventas hechas en el mes
	 * @return valor de la prima en función a las ventas del mes
	 */
	private float calculoPrima(float ventasMes) {
		float prima = 0;

		if (ventasMes > 1499)
			prima = 200;

		else if (ventasMes > 999)
			prima = 100;

		return prima;
	}

	/**
	 * 
	 * @param horasExtra Numero de horas extras hechas
	 * @return - 0 si horasExtra tiene valor negativo - costo de las horas extra
	 *         trabajadas al precio de cada una
	 */
	private float calculoHorasExtra(float horasExtra) {
		return horasExtra > 0 ? horasExtra * PRECIO_HORAS_EXTRA : 0;
	}

	/**
	 * 
	 * @param tipo       tipo de empleado
	 * @param ventasMes  número de ventas del mes
	 * @param horasExtra horas extras trabajadas por el empleado
	 * @return nomina bruta del empleado considerando salario base, ventas del mes y
	 *         sus horas extras trabajadas
	 */
	public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
		return tipo.getSalarioBase() + calculoPrima(ventasMes) + calculoHorasExtra(horasExtra);
	}

	
	/**
	 * 
	 * @param nominaBruta Nómina bruta del empleado
	 * @return nomina neta calculada en función a la nomina bruta y las retenciones.
	 */
	public float calculoNominaNeta(float nominaBruta) {
		float retencion = 0;
		
		if (nominaBruta >= 2500)
			retencion = 0.18f;
		else if(nominaBruta >= 2100)
			retencion = 0.15f;
		
		return nominaBruta * (1-retencion);
	}
}
