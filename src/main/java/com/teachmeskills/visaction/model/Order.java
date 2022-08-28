package com.teachmeskills.visaction.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn (name="user_id")
    private User user;
    @ManyToOne (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn (name="country_id")
    private Country country;
    @ElementCollection(targetClass = Visa.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "order_visa", joinColumns = @JoinColumn(name = "order_id"))
    @Enumerated(EnumType.STRING)
    private Set<Visa> visas;
    @ElementCollection(targetClass = ValidPeriod.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "order_valid_period", joinColumns = @JoinColumn(name = "order_id"))
    @Enumerated(EnumType.STRING)
    private Set<ValidPeriod> validPeriods;
    private LocalDateTime createdOrderAt = LocalDateTime.now();
    private int costOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Visa> getVisas() {
        return visas;
    }

    public void setVisas(Set<Visa> visas) {
        this.visas = visas;
    }

    public Set<ValidPeriod> getValidPeriods() {
        return validPeriods;
    }

    public void setValidPeriods(Set<ValidPeriod> validPeriods) {
        this.validPeriods = validPeriods;
    }

    public LocalDateTime getCreatedOrderAt() {
        return createdOrderAt;
    }

    public void setCreatedOrderAt(LocalDateTime createdOrderAt) {
        this.createdOrderAt = createdOrderAt;
    }

    public int getCostOrder() {
        return costOrder;
    }

    public void setCostOrder(int costOrder) {
        this.costOrder = costOrder;
    }
}
