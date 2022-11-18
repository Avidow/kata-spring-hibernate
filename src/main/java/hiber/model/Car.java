package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private Integer series;


    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public void setId(Long carId) {
        this.carId = carId;
    }

    public Long getId() {
        return this.carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

}
