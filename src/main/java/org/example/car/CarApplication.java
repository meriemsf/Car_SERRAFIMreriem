package org.example.car;

import org.example.car.dto.CarDTO;
import org.example.car.service.CarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CarService carService){
        return  args -> {
            carService.saveCars(
                    List.of(
                            CarDTO.builder().model("A").matricul("1").color("Rouge").price(2).build(),
                            CarDTO.builder().model("B").matricul("2").color("jaune").price(4).build(),
                            CarDTO.builder().model("C").matricul("3").color("rose").price(5).build(),
                            CarDTO.builder().model("D").matricul("4").color("orange").price(6).build()
                    )

            );
        };
    }
}
