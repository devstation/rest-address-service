package de.devstation.demo.ras.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AddressService {

  @Autowired
  private AddressRepository addressRepository;

  public Address getById(int id) {
    return addressRepository.findById(id);
  }

  public Set<Address> getByUserId(int id) {
    return addressRepository.findByUserId(id);
  }

  public void reset() {
    addressRepository.clearAddresses();
    addressRepository.resetId();
  }

  public Address storeAddress(Address address) {
    return addressRepository.storeAddress(address);
  }

}
