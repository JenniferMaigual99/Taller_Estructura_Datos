package ReproductorMusica;

public class Cancion {
    private int duracion;
    private String autor;
    private String titulo;

    public Cancion(int duracion, String autor, String titulo) {
        this.duracion = duracion;
        this.autor = autor;
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

