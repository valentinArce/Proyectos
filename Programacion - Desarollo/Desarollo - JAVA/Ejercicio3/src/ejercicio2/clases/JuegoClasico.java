package ejercicio2.clases;

public class JuegoClasico extends Juego {

    private static final String MENSAJE_TRADICIONAL = "%s  - %s        - Precio de Venta: $  %8.2f - %s\n";
    private TipoDePlataforma tipoDePlataforma;

    public JuegoClasico(String nombre, float costoBase, float porcentajeGanancia, TipoDePlataforma tipoDePlataforma, TipoDeJuego tipoDeJuego) {
        super(nombre, costoBase, porcentajeGanancia, tipoDeJuego);
        this.setTipoDeMasa(tipoDePlataforma);
    }

    public void setTipoDeMasa(TipoDePlataforma tipoDePlataforma) {
        this.tipoDePlataforma = tipoDePlataforma;
    }

    @Override
    public void mostrar() {
        System.out.printf(MENSAJE_TRADICIONAL,
            this.getClass().getSimpleName(),
            this.getNombre(),
            this.getPrecioDeVenta(),
            this.getTipoDeMasa()
        );
    }

    public TipoDePlataforma getTipoDeMasa() {
        return tipoDePlataforma;
    }

    @Override
    public float getPrecioDeCosto() {
        return super.getPrecioBase() * tipoDePlataforma.getMultiplicadorPlataforma();
    }

    @Override
    public TipoDeJuego getTipo() {
        return TipoDeJuego.RPG;
    }
}
