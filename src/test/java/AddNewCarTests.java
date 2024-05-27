import api.CarController;
import config.AppiumConfig;
import dto.CarDto;
import dto.CarsDto;
import dto.UserDTO;
import enumclasses.Fuel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

import java.util.Random;

public class AddNewCarTests extends AppiumConfig {

    @Test
    public void addNewCarPositiveTest() {
        UserDTO user = UserDTO.builder()
                .email("lonchik_7_7@walla.co.il")
                .password("Samimi@44@")
                .build();

        int i = new Random().nextInt(1000) + 1000;
        CarDto car = CarDto.builder()
                .serialNumber("444-" + i)
                .manufacture("Toyota")
                .model("Corola")
                .year("2021")
                .fuel(Fuel.DIESEL.getFuel())
                .seats(4)
                .carClass("A")
                .pricePerDay(100.23)
                .city("Haifa")
                .build();
        System.out.println(car.toString());

        new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnLogin()
                .typeLoginForm(user)
                .clickBtnYallaPositive()
                .clickBtnDots()
                .clickBtnMyCarPositive()
                .clickBtnAddNewCar()
                .typeAddNewCarForm(car)
                .clickBtnAddCarPositive();

        boolean flagEquals = false;
        CarController carController = new CarController();
        carController.getTokenForCarController();
        CarsDto carsDto = carController.bodyGetAllUserCarResponse();
        for (CarDto car1 : carsDto.getCars()) {
            //System.out.println(car.getSerialNumber());
            System.out.println(car.toString());
            if (car.equals(car1)){
                System.out.println("equals !!!!"+car1.toString());
            }else
                System.out.println("not equals !!!!");
        }
        Assert.assertTrue(flagEquals);
    }
}
