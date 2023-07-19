package ejercicio2.clases;

public class JuegoMultijugador extends Juego {

    public static final float PRECIO_POR_JUGADOR = 45f;
    private static final String MENSAJE_RECTANGULAR = "%s  - %s        - Precio de Venta: $  %8.2f - %d jugadores - %s\n";
    private long cantidadJugadoresEnLinea;

    private ContenidoAdicional contenidoAdicional;


    public JuegoMultijugador(String nombre, float costoDeProduccion, float porcentajeGanancia, long cantidadJugadoresEnLinea, ContenidoAdicional contenidoAdicional, TipoDeJuego tipoDeJuego) {
        super(nombre, costoDeProduccion, porcentajeGanancia, tipoDeJuego);
        this.setCantidadJugadoresEnLinea(cantidadJugadoresEnLinea);
        this.setContenidoAdicional(contenidoAdicional);
    }


    public void setCantidadJugadoresEnLinea(long cantidadJugadoresEnLinea) {
        this.cantidadJugadoresEnLinea = cantidadJugadoresEnLinea;
    }

    public void setContenidoAdicional(ContenidoAdicional contenidoAdicional) {
        this.contenidoAdicional = contenidoAdicional;
    }

    @Override
    public void mostrar() {
        System.out.printf(MENSAJE_RECTANGULAR,
                this.getClass().getSimpleName(),
                this.getNombre(),
                this.getPrecioDeVenta(),
                this.getCantidadJugadoresEnLinea(),
                this.getContenidoAdicional().getDescripcion()
        );
    }

    public long getCantidadJugadoresEnLinea() {
        return cantidadJugadoresEnLinea;
    }

    public ContenidoAdicional getContenidoAdicional() {
        return contenidoAdicional;
    }

    @Override
    public float getPrecioDeCosto() {
        float precioCosto = 0;
        float precioCostoPorJugador = PRECIO_POR_JUGADOR * this.cantidadJugadoresEnLinea;
        precioCosto = (super.getPrecioBase() + precioCostoPorJugador) + contenidoAdicional.getAdicional();

        return precioCosto;
    }

    @Override
    public TipoDeJuego getTipo() {
        return TipoDeJuego.PLATAFORMAS;
    }
}
