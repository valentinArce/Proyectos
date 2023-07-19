package ejercicio2.clases;

public class JuegoEdicionEspecial extends Juego {

    public static final float DESCUENTO_LANZAMIENTO = 15890.1f;
    public static final String MENSAJE_ESPECIAL = "%s     - %s       - Precio de Venta: $ %8.2f - Anio de Lanzamiento %d - %s\n";
    private int anioDeLanzamiento;

    private ContenidoAdicional contenidoAdicional;

    public JuegoEdicionEspecial(String nombre, float costoDeProduccion, float porcentajeGanancia, int anioDeLanzamiento, ContenidoAdicional contenidoAdicional, TipoDeJuego tipoDeJuego) {
        super(nombre, costoDeProduccion, porcentajeGanancia, tipoDeJuego);
        this.setAnioDeLanzamiento(anioDeLanzamiento);
        this.setContenidoAdicional(contenidoAdicional);

    }

    private void setAnioDeLanzamiento(int anioDeLanzamiento) {
        if (anioDeLanzamiento < 1951) {
            throw new IllegalArgumentException("El anio de lanzamiento no puede ser menor a 0");
        }

        this.anioDeLanzamiento = anioDeLanzamiento;
    }

    private void setContenidoAdicional(ContenidoAdicional contenidoAdicional) {
        this.contenidoAdicional = contenidoAdicional;
    }

    @Override
    public void mostrar() {
        System.out.printf(MENSAJE_ESPECIAL,
            this.getClass().getSimpleName(),
            this.getNombre(),
            this.getPrecioDeVenta(),
            this.getAnioDeLanzamiento(),
            this.contenidoAdicional.getDescripcion()
        );
    }

    public int getAnioDeLanzamiento() {
        return anioDeLanzamiento;
    }

    public ContenidoAdicional getContenidoAdicional() {
        return contenidoAdicional;
    }

    @Override
    public float getPrecioDeCosto() {
        float precioCosto = 0;
        precioCosto = super.getPrecioBase() + this.contenidoAdicional.getAdicional();
        precioCosto = precioCosto - (DESCUENTO_LANZAMIENTO / this.anioDeLanzamiento);
        return precioCosto;
    }

    @Override
    public TipoDeJuego getTipo() {
        return TipoDeJuego.AVENTURA;
    }
}
