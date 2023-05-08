package edu.uaslp.objetos.shoppingcart;

import edu.uaslp.objetos.exception.ItemNotFoundException;

import java.util.*;

public class ShoppingCart {

    private final ShoppingItemCatalog shoppingItemCatalog;
    private List<ShoppingItem> cart;

    ShoppingCart(ShoppingItemCatalog shoppingItemCatalog){
        this.shoppingItemCatalog = shoppingItemCatalog;
        cart = new LinkedList<>();
    }

    public void add(String code)throws ItemNotFoundException {
        ShoppingItem newItem = shoppingItemCatalog.getItem(code);
        cart.add(newItem);
    }

    public int getTotalCostInCents(){
        int total = 0;
        for(ShoppingItem s : cart){
            total += s.getUnitCostInCents();
        }
        return total;
    }

    public Set <ShoppingItem> getDistinctItems(){
        Set <ShoppingItem> itemsSet = new HashSet<>();
        if(!cart.isEmpty()){
            itemsSet.addAll(cart);
            return itemsSet;
        }
        return null;
    }

    public int getDistinctItemsCount(){
        Set <String> itemsSet = new HashSet<>();
        if(!cart.isEmpty()){
            for(ShoppingItem s : cart){
                itemsSet.add(s.getCode());
            }
            return itemsSet.size();
        }
        return 0;
    }

    public int getTotalItemsCount(){
        return cart.size();
    }

    public List<ShoppingItem> getItems(){
        return cart;
    }
}
