package service;

import CsLinkedList.CsLinkedList;
import model.Item;
import model.Receipt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;


@RunWith(MockitoJUnitRunner.class)
public class CustomerCheckoutTest {

    @Mock
    Receipt receipt;

    @Test
    public void testWithMocking() throws IllegalAccessException {
        CsLinkedList<Item> list = new CsLinkedList<Item>();
        list.add(new Item(0.1, ""));

        when(receipt.getStoreNumber()).thenReturn("store");
        when(receipt.getItemList()).thenReturn(list);

        CustomerCheckout customerCheckout = new CustomerCheckout("1", "1");
        customerCheckout.scanAnItem(new Item(0.1, ""));
        verify(receipt).add(new Item(0.1, ""));

        customerCheckout.scanAnItem(new Item(0.1, ""), 10);
        verify(receipt, times(10)).add(any(Item.class));
        customerCheckout.endTransaction();
    }

}