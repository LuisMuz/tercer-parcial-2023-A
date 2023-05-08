package edu.uaslp.objetos.shoppingcart;

import edu.uaslp.objetos.exception.ItemNotFoundException;
import edu.uaslp.objetos.exception.ShoppingCartException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Exercise3ShoppingItemCatalog {

    private final ShoppingItemCatalog shoppingItemCatalog = new ShoppingItemCatalog();

    @Test
    public void givenAValidCode_whenGetItem_thenShoppingItemIsReturned(){
        // Given:
        String code = "ABC1000";

        // When:
        ShoppingItem shoppingItem = shoppingItemCatalog.getItem(code);

        // Then:
        Assertions.assertEquals(code,shoppingItem.getCode());
    }

    @Test
    public void givenANotValidCode_whenGetItem_thenNullIsReturned(){
        // Given:
        String code = "ABC1100";

        // When & then:
        Assertions.assertThrows(ItemNotFoundException.class, () -> shoppingItemCatalog.getItem(code));
    }
}
