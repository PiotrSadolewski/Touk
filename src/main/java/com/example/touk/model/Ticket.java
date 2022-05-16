package com.example.touk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

enum TicketType{
    ADULT,
    STUDENT,
    CHILD
}

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate buyDate = LocalDate.now();
    @Enumerated(EnumType.ORDINAL)
    private TicketType ticketType;
    private float ticketPrice;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ticket")
    private List<Order> orders = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_Show_id", referencedColumnName = "Id")
    private FilmShow filmShow;

    public FilmShow getFilmShow() {
        return filmShow;
    }

    public void setFilmShow(FilmShow filmShow) {
        this.filmShow = filmShow;
    }


    public void addOrder(Order order){
        orders.add(order);
    }

    public void removeOrder(Order order){
        orders.remove(order);
    }
}
