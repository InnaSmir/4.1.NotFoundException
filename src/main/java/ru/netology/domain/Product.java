package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private int id;
    private String name;
    private int price;

    public boolean matches(String search) {
        if (search.equalsIgnoreCase("")) {
            return false;
        } else {
            return search.equalsIgnoreCase(name);
        }
    }
}
