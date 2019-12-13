import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Impresion {
	private String identificadorDeImpresion;
	private byte tama�o;
	private int cantidad;

	public Impresion(String identificadorDeImpresion, byte tama�o, int cantidad) {
		this.identificadorDeImpresion = identificadorDeImpresion;
		this.tama�o = tama�o;
		this.cantidad = cantidad;
	}

	public String getIdentificadorDeImpresion() {
		return identificadorDeImpresion;
	}

	public void setIdentificadorDeImpresion(String identificadorDeImpresion) {
		this.identificadorDeImpresion = identificadorDeImpresion;
	}

	public byte getTama�o() {
		return tama�o;
	}

	public void setTama�o(byte tama�o) {
		this.tama�o = tama�o;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Impresion [identificadorDeImpresion=" + identificadorDeImpresion + ", tama�o=" + tama�o + ", cantidad="
				+ cantidad + "]";
	}

}

interface RegistroImpresiones {
	public void vaciar();

	public Impresion mostrarFrente();

	public Impresion mostrarFin();

	public boolean insertarElemento(Impresion a);

	public boolean eliminarElemento();

	public boolean vacia();

	public boolean llena();

	public int cantidadElementos();

	public boolean imprimir();

	public boolean agregarACola(Impresion a);

	public int hojasImpresas(Impresion a);

	public int mostraBytes(Impresion a);
}

class ImplementacionFilaEstatica implements RegistroImpresiones {

	private Impresion[] filaImpresiones = new Impresion[10];
	private int fr;
	private int fn;

	public ImplementacionFilaEstatica(int t) {
		fn = 0;
		fr = fn - 1;
	}

	@Override
	public void vaciar() {
		fn = 1;
		fr = fn - 1;
	}

	@Override
	public Impresion mostrarFrente() {
		if (vacia()) {
			return null;
		} else {
			return filaImpresiones[fr];
		}

	}

	@Override
	public Impresion mostrarFin() {
		if (vacia()) {
			return null;
		} else {
			return filaImpresiones[fn];
		}

	}

	@Override
	public boolean insertarElemento(Impresion a) {
		if (llena() || fr == 0) {

			return false;
		} else {
			fn++;
			filaImpresiones[fn] = a;
			return true;
		}
	}

	@Override
	public boolean eliminarElemento() {
		if (vacia()) {
			return false;
		} else {
			if (fn == fr) {
				fr--;
				return true;
			}
			fn--;
			return true;
		}

	}

	@Override
	public boolean vacia() {
		if (fr == 0 && fn == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean llena() {
		if (fn == filaImpresiones.length) {
			return true;

		}
		return false;
	}

	@Override
	public int cantidadElementos() {
		if (vacia()) {
			return 0;
		}
		return fn;
	}

	@Override
	public boolean imprimir() {

		return true;
	}

	@Override
	public boolean agregarACola(Impresion a) {
		insertarElemento(a);
		return true;
	}

	@Override
	public int hojasImpresas(Impresion a) {

		return a.getCantidad();
	}

	@Override
	public int mostraBytes(Impresion a) {

		return a.getTama�o();
	}

}

class ImplementacionFilaDinamica implements RegistroImpresiones {

	Queue<Impresion> filaImpresion = new LinkedList<Impresion>();

	@Override
	public void vaciar() {
		filaImpresion.clear();
	}

	@Override
	public Impresion mostrarFrente() {
		if (vacia()) {
			return null;
		} else {
			return filaImpresion.peek();
		}
	}

	@Override
	public Impresion mostrarFin() {
		if (vacia()) {
			return null;
		} else {
			return filaImpresion.peek();
		}
	}

	@Override
	public boolean insertarElemento(Impresion a) {
		if (llena()) {
			return false;
		} else {
			filaImpresion.add(a);
			return true;
		}

	}

	@Override
	public boolean eliminarElemento() {
		if (vacia()) {
			return false;
		}else {
		filaImpresion.remove();
		return false;
		}
	}

	@Override
	public boolean vacia() {
		return filaImpresion.isEmpty();
	}

	@Override
	public boolean llena() {
		return false;
	}

	@Override
	public int cantidadElementos() {
		
		return filaImpresion.size();
	}

	@Override
	public boolean imprimir() {
		
		return false;
	}

	@Override
	public boolean agregarACola(Impresion a) {
		filaImpresion.add(a);
		return false;
	}

	@Override
	public int hojasImpresas(Impresion a) {
		a.getCantidad();
		return 0;
	}

	@Override
	public int mostraBytes(Impresion a) {
		a.getTama�o();
		return 0;
	}

}

public class Prueba {

	public static void main(String[] args) {

		ImplementacionFilaEstatica f1 = new ImplementacionFilaEstatica(0);
		Scanner e = new Scanner(System.in);
		boolean a = true;
		Impresion a1 = new Impresion("abc", (byte) 10, 34);
		do {

			System.out.println("Ingrese una opcion");
			System.out.println("1) Imprimir \n2) Agregar a cola de impresion\n3) Mostrar total de hojas impresas\n4) Mostrar total de bytes recibidos de impresion\n5) Salir");
			byte op = e.nextByte();
			switch (op) {

			case 1:
				f1.imprimir();
				break;
			case 2:
				System.out.println(f1.agregarACola(a1));
				break;
			case 3:
				System.out.println(f1.hojasImpresas(a1));
				break;
			case 4:
				System.out.println(f1.mostraBytes(a1));
				break;
			case 5:
				a = false;
				break;
			default: System.out.println("Sali�...");
				break;
			}
		} while (a);

		e.close();
	}
}