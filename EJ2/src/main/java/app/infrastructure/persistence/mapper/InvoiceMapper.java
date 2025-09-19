package app.infrastructure.persistence.mapper;

import app.domain.model.Invoice;
import app.infrastructure.persistence.entities.InvoiceEntity;

public class InvoiceMapper {

    // Dominio → Entidad
    public static InvoiceEntity toEntity(Invoice domain) {
        if (domain == null) return null;

        InvoiceEntity entity = new InvoiceEntity();
        entity.setInvoiceId(domain.getInvoiceId());
        entity.setPatientName(domain.getPatientName());
        entity.setPatientAge(domain.getPatientAge());
        entity.setPatientIdCard(domain.getPatientIdCard());
        entity.setDoctorName(domain.getDoctorName());
        entity.setInsuranceName(domain.getInsuranceName());
        entity.setPolicyNumber(domain.getPolicyNumber());
        entity.setDate(domain.getDate());
        entity.setTotalAmount(domain.getTotalAmount());

        // Relación con Order (usa el OrderMapper si lo tienes definido)
        entity.setOrder(OrderMapper.toEntity(domain.getOrder()));

        return entity;
    }

    // Entidad → Dominio
    public static Invoice toDomain(InvoiceEntity entity) {
        if (entity == null) return null;

        Invoice domain = new Invoice();
        domain.setInvoiceId(entity.getInvoiceId());
        domain.setPatientName(entity.getPatientName());
        domain.setPatientAge(entity.getPatientAge());
        domain.setPatientIdCard(entity.getPatientIdCard());
        domain.setDoctorName(entity.getDoctorName());
        domain.setInsuranceName(entity.getInsuranceName());
        domain.setPolicyNumber(entity.getPolicyNumber());
        domain.setDate(entity.getDate());
        domain.setTotalAmount(entity.getTotalAmount());

        // Relación con Order
        domain.setOrder(OrderMapper.toDomain(entity.getOrder()));

        return domain;
    }
}
