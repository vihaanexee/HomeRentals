package com.rentals.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Property {
    @Id
    Long propertyId;
}
