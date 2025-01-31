package hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "series")
    int series;

    @Column
    String model;

    @OneToOne
    User user;

    public Car() {

    }

    public Car(String model, int series) {
        setSeries(series);
        setModel(model);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Model: " + getModel() + "; Series: " + getSeries();
    }
}
