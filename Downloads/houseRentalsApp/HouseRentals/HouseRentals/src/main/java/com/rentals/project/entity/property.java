package com.rentals.project.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String address;
    private String city;
    private String state;
    private String pincode;

    private BigDecimal rent;
    private BigDecimal deposit;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @Enumerated(EnumType.STRING)
    private FurnishType furnishType;

    private Integer rooms;
    private Integer bathrooms;
    private Integer area;


    @ElementCollection
    @CollectionTable(name = "property_images" , joinColumns = @JoinColumn(name = "property_id" ))
    @Column(name = "image_url")
    private List<String> imageUrls = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name ="property_amenities" , joinColumns = @JoinColumn(name = "property_id"))
    @Column(name = "amenities")
    private List<String> amenities = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "owner_id" , nullable = false)
    private User owner;

    @ManyToOne
    @JoinColumn(name = "category_id" , nullable = false)
    private Category category;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
