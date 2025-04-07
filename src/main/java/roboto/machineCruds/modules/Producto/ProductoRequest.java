package roboto.machineCruds.modules.Producto;

public class ProductoRequest {

    private String name;
    private Float price;
    private String message;

    public String getName() {
        return this.name;
    }

    public Float getPrice() {
        return this.price;
    }

    public String getMessage() {
        return this.message;
    }

    public Boolean validate() {

        if (this.price == null || this.price <= 0) {
            this.message = this.message + "You must enter something in price";
            return false;
        }

        if (this.name == null || this.name.isBlank()) {
            this.message = this.message + "You must enter some name";
            return false;
        }
        return true;
    }
}