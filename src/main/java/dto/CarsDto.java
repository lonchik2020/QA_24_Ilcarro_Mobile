package dto;

import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarsDto {
    private CarDto [] cars;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarsDto carsDto = (CarsDto) o;
        return Arrays.equals(cars, carsDto.cars);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cars);
    }
}
