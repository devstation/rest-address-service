package de.devstation.demo.ras.address;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AddressRepository {

  private static final Map<Integer, Address> addressesById = new HashMap<>();
  private static final Map<Integer, Set<Address>> addressesByUserId = new HashMap<>();
  private AtomicInteger nextId = new AtomicInteger(1);

  public Collection<Address> getAllUsers() {
    return addressesById.values();
  }

  public Address findById(int id) {
    return addressesById.get(id);
  }

  public Set<Address> findByUserId(int id) {
    return addressesByUserId.get(id);
  }

  public int nextId() {
    return nextId.getAndIncrement();
  }

  public void resetId() {
    nextId = new AtomicInteger(1);
  }

  public void clearAddresses() {
    addressesById.clear();
    addressesByUserId.clear();
  }

  public void storeAddress(Address address) {
    addressesById.put(address.getId(), address);
    Set<Address> addresses = addressesByUserId.get(address.getUserId());
    if (addresses == null) {
      addresses = new HashSet<>();
    }
    addresses.add(address);
    addressesByUserId.put(address.getUserId(), addresses);
  }

}
