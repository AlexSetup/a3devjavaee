package fr.imie.contact.entities;

public class Main {

    public static void main(String[] args) {

        Brand citroen = new Brand();
        citroen.name = "Citroen";

        Brand peugeot = new Brand();
        peugeot.name = "Peugeot";

        Brand renault = new Brand();
        renault.name = "Renault";

        Model p206 = new Model();
        p206.name = "206";
        p206.brand = peugeot;

        Model p208 = new Model();
        p208.name = "208";
        p208.brand = peugeot;

        Model rClio = new Model();
        p206.name = "Clio";
        p206.brand = renault;

        Model c4 = new Model();
        c4.name = "C4";
        c4.brand = citroen;

        Model a380 = new Model();
        a380.name = "A380";
        a380.brand = null;

        Car v1 = new Car();
        v1.model = rClio;

        Car v2 = new Car();
        v2.model = p206;

        Car v3 = new Car();
        v3.model = c4;
        v3.trunk = "coffre : TODO";

        Plane p1 = new Plane();
        p1.model = a380;
        p1.hold = "soute : TODO";

        // System.out.println(v3.brand.name); // plus possible en direct
        System.out.println(v3.model.name); // C4
        System.out.println(v3.model.brand.name); // citroen
    }

}
