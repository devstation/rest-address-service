package de.devstation.demo.ras;

import de.devstation.demo.ras.address.Address;
import de.devstation.demo.ras.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Bootstrap {

  @Autowired
  private AddressService addressService;

  @PostConstruct
  public void fillInDummyData() {
    addressService.storeAddress(new Address(1, "Altenesser Str. 345", "45329", "Essen", "Germany"));
    addressService.storeAddress(new Address(1, "Bebelstr. 123", "46045", "Oberhausen", "Germany"));
    addressService.storeAddress(new Address(2, "Kölner Str. 987", "45481", "Mülheim an der Ruhr", "Germany"));
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Bootstrap.class, args);
  }

}
