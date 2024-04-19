public class Libro {
    String titulo = "";
    Autor autor;
    String isbn = "";
    String categoria = "";
    int ejemplares = 0;

    public Libro(String titulo, Autor autor, String isbn, String categoria, int ejemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoria = categoria;
        this.ejemplares = ejemplares;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    @Override
    public String toString() {
        return " Titulo del libro: " + titulo + "   " + autor + "   ISBN: " + isbn + "   Categoria:" + categoria
                + "   Ejemplares: " + ejemplares + "\n";
    }

}