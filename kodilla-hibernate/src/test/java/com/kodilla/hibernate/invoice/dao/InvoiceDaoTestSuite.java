package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");
        Item item1 = new Item(product1, BigDecimal.valueOf(100),2,BigDecimal.valueOf(200));
        Item item2 = new Item(product2,BigDecimal.valueOf(300),5,BigDecimal.valueOf(700));
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        Invoice invoice = new Invoice("2020.01.10-0001",items);
        //When
        //productDao.save(product1);
        //productDao.save(product2);
        //itemDao.save(item1);
        //itemDao.save(item2);
        invoiceDao.save(invoice);
        //Then
        int id = invoice.getId();
        List<Invoice> readInvoice = invoiceDao.findById(id);
        assertEquals(1,readInvoice.size());
        //Clean up

        try {
            invoiceDao.deleteById(invoice.getId());

        } catch (Exception e) {
            //do nothing
        }

    }

}
