public class Cancion implements IntCancion {
    private String name;
    private String genre;
    private int year;

    public Cancion(String name, String genre, int year) {
        this.name = name;
        this.genre = genre;
        this.year = year;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "nombre='" + name + '\'' +
                ", género='" + genre + '\'' +
                ", año=" + year +
                '}';
    }
}
