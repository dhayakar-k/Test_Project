package watchdog;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.List;

public class FirstExample {

    public static void main(String[] args) {
        List<Integer> new1 = Arrays.asList(1,2,4,50,3);
        List<Integer> new2 = Arrays.asList(10,2,3,50,4);
        List<Integer> integerList = (List<Integer>) CollectionUtils.subtract(new1, new2);
        System.out.println(integerList);
        Customer customer1 = new Customer(1, "Daniel", new Address("Locality1", "HYD"));
        Customer customer2 = new Customer(2, "Fredrik", new Address("Locality2", "BLR"));
        Customer customer3 = new Customer(3, "Kyle", new Address("Locality3", "CHN"));
        Customer customer4 = new Customer(4, "Bob", new Address("Locality4", "KOCHI"));
        Customer customer5 = new Customer(5, "Cat", new Address("Locality5", "DELHI"));
        Customer customer6 = new Customer(6, "John", new Address("Locality", "MUMBAI"));
        List<Customer> list1 = Arrays.asList(customer1, customer2, customer3);
        List<Customer> list2 = Arrays.asList(customer4, customer5, customer6);
        List<Customer> list3 = Arrays.asList(customer1, customer2);
        List<Customer> finalList =(List<Customer>) CollectionUtils.subtract(list1, list3);
        finalList.forEach(customer -> {
            System.out.println("Customer details: Id:"+customer.getId()+", Name:"+customer.getName());
            System.out.println("Address: Locality:"+customer.getAddress().getLocality()+", City:"+customer.getAddress().getCity());
        });
        List<String> newList = Arrays.asList("HYD","CHN","BLR", "KOCHIN", "PUNE","CHANDIGARH");
        List<String> oldList = Arrays.asList("DELHI","MUMBAI","BLR", "CHN", "KOCHIN");
        List<String> subtractCitiesList = (List<String>) CollectionUtils.subtract(newList, oldList);
        System.out.println(subtractCitiesList);
        List<String> unionCitiesList = (List<String>) CollectionUtils.union(newList, oldList);
        System.out.println(unionCitiesList);
        List<String> intersectionCitiesList = (List<String>) CollectionUtils.intersection(newList, oldList);
        System.out.println(intersectionCitiesList);
    }

    public static class  Customer {
        private Integer id;
        private String name;
        private Address address;

        public Customer(Integer id, String name, Address address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }
    }
    public static class Address {
        private String locality;
        private String city;

        public Address(String locality, String city) {
            this.locality = locality;
            this.city = city;
        }

        public String getLocality() {
            return locality;
        }

        public void setLocality(String locality) {
            this.locality = locality;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
