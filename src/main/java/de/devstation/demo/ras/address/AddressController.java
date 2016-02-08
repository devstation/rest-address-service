package de.devstation.demo.ras.address;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/address")
public class AddressController {

  private static final Logger log = LoggerFactory.getLogger(AddressController.class);

  @Autowired
  private AddressService addressService;

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public HttpEntity<String> create(@RequestBody Address address) {
    addressService.storeAddress(address);
    return new ResponseEntity<>("OK", HttpStatus.OK);
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public void reset() {
    addressService.reset();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public HttpEntity<Address> byId(@PathVariable int id) {
    return new ResponseEntity<>(addressService.getById(id), HttpStatus.OK);
  }

  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
  public HttpEntity<Set<Address>> byUserId(@PathVariable int id) {
    return new ResponseEntity<>(addressService.getByUserId(id), HttpStatus.OK);
  }

}
