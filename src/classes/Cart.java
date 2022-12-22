package classes;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //Cart variables
    private int id;
    private List<Product> product_list;
    private long thread_id;

    //Cart constructors
    public Cart() {
        this.id = 0;
        this.product_list = new ArrayList();
        this.thread_id = 0;
    }

    public Cart(int id, List<Product> product_list, long thread_id) {
        this.id = id;
        this.product_list = product_list;
        this.thread_id = thread_id;
    }

    //Cart functions (get/set)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProduct_list() {
        return this.product_list;
    }

    public void setPoduct_list(List<Product> product_list) {
        this.product_list = product_list;
    }

    public long getThread_id() {
        return this.thread_id;
    }

    public void setThread_id(long thread_id) {
        this.thread_id = thread_id;
    }

}
