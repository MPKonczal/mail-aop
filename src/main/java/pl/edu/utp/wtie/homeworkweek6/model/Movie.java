package pl.edu.utp.wtie.homeworkweek6.model;

public class Movie {

    private long id;
    private String title;
    private int productionYear;
    private String director;

    public Movie(long id, String title, int productionYear, String director) {
        this.id = id;
        this.title = title;
        this.productionYear = productionYear;
        this.director = director;
    }

    public Movie() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", productionYear=" + productionYear +
                ", director='" + director + '\'' +
                '}';
    }
}
