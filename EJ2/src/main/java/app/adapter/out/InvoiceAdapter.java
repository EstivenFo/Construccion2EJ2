package app.adapter.out;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import app.domain.model.Invoice;
import app.domain.ports.InvoicePort;

@Repository  // Para que Spring lo registre como un bean
public class InvoiceAdapter implements InvoicePort {

    private final Map<Long, Invoice> database = new HashMap<>();

    @Override
    public void save(Invoice invoice) throws Exception {
        database.put(invoice.getInvoiceId(), invoice);
        System.out.println("Factura guardada en memoria con ID: " + invoice.getInvoiceId());
    }

    @Override
    public Invoice searchById(int invoiceId) throws Exception {
        return database.get((long) invoiceId);
    }
}
