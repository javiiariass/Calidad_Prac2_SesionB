package empleado;

public class Empleado {

	float salarioBase;

	public float getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(float salarioBase) {
		this.salarioBase = salarioBase;
	}

	public enum TipoEmpleado {
		Vendedor, Encargado
	}

	public Empleado() {
		salarioBase = 2000;
	}

	public Empleado(TipoEmpleado tipo) {
		salarioBase = (tipo == TipoEmpleado.Vendedor ? 2000 : 2500);
	}

	public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
		float prima = 0; 
		float horas = 0;

		if (ventasMes > 1499 )
			prima = 200;
		else if (ventasMes > 999)
			prima = 100;

		if(horasExtra > 0)
			horas = 30 * horasExtra;
		
		return salarioBase + prima + horas;
		
	}

	public float calculoNominaNeta(float nominaBruta) {

	}
}
