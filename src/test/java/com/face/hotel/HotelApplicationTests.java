package com.face.hotel;

import com.face.hotel.entity.VehicleInfo;
import com.face.hotel.service.VehicleInfoService;
import com.face.hotel.service.impl.VehicleInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HotelApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testVehicleInfo() {
        VehicleInfoService vehicleInfoService = new VehicleInfoServiceImpl();

        List<VehicleInfo> vehicleInfos = vehicleInfoService.getAllVehicleInfo();

        for (VehicleInfo vehicleInfo: vehicleInfos) {
            System.out.println(vehicleInfo);
        }
    }
}
