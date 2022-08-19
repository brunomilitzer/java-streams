package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> dtos = people.stream()
                .map( PersonDTO::map ).toList();

        dtos.forEach( System.out::println );
        assertThat(people.size()).isEqualTo( dtos.size() );
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        double average = cars.stream()
                .mapToDouble( Car::getPrice )
                .average().orElse( 0 );

        System.out.println(average);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        int sum = Arrays.stream( integers ).reduce( 0, (a, b) -> a + b );
        int sub = Arrays.stream( integers ).reduce( 0, (a, b) -> a - b );

        System.out.println(sum);
        System.out.println(sub);
    }
}

